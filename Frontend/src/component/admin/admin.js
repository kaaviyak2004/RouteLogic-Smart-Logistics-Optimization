import React, { useState, useEffect } from "react";
import apiClient from "../../service/api_service";
import "./admin.css";

export default function Admin() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  const fetchOrders = async () => {
    setLoading(true);
    try {
      const response = await apiClient.get("/listAllParcels");
      const responseData = response.data.content;
      if (Array.isArray(responseData)) {
        setData(responseData);
      } else {
        console.error("Unexpected response format:", responseData);
        setData([]);
      }
    } catch (error) {
      console.error("There was an error fetching the data!", error);
      setData([]);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchOrders();
  }, []);

  // Handle status change
  const handleStatusChange = (parcelId, newStatus) => {
    const updatedData = data.map((row) =>
      row.parcelId === parcelId ? { ...row, status: newStatus } : row
    );
    setData(updatedData);
    alert(`Status changed to ${newStatus}`);
  };

  return (
    <div className="admin-container">
      <div className="admin-header">
        <h2>Admin Page</h2>
        <button className="refresh-button" onClick={fetchOrders}>
          &#x21bb; Refresh
        </button>
      </div>
      <table className="admin-table">
        <thead>
          <tr>
            <th>Parcel ID</th>
            <th>User ID</th>
            <th>Receiver First Name</th>
            <th>Receiver Last Name</th>
            <th>Pickup Address</th>
            <th>Destination Address</th>
            <th>Receiver Phone Number</th>
            <th>No. of Items</th>
            <th>Item Type</th>
            <th>Delivery Type</th>
            <th>Fragile Item</th>
            <th>Total Bill</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {loading ? (
            <tr>
              <td colSpan="13">Loading...</td>
            </tr>
          ) : data.length === 0 ? (
            <tr>
              <td colSpan="13">No orders found.</td>
            </tr>
          ) : (
            data.map((row) => (
              <tr key={row.parcelId}>
                <td>{row.parcelId}</td>
                <td>{row.userId}</td>
                <td>{row.receiverFirstName}</td>
                <td>{row.receiverLastName}</td>
                <td>{row.pickupAddress}</td>
                <td>{row.destinationAddress}</td>
                <td>{row.receiverPhoneNumber}</td>
                <td>{row.noOfItems}</td>
                <td>{row.itemType}</td>
                <td>{row.deliveryType}</td>
                <td>{row.fragileItem ? "Yes" : "No"}</td>
                <td>{row.totalBill}</td>
                <td>
                  <select
                    value={row.status}
                    onChange={(e) => handleStatusChange(row.parcelId, e.target.value)}
                  >
                    <option value="New">New</option>
                    <option value="Accepted">Accepted</option>
                    <option value="On the way">On the way</option>
                    <option value="Delivered">Delivered</option>
                    <option value="Rejected">Rejected</option>
                  </select>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}
