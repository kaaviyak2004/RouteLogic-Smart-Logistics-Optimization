import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./myorder.css";
import apiClient from "../../service/api_service";

export default function MyOrder() {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();
  const [userId, setUserId] = useState(null);

  useEffect(() => {
    const userData = localStorage.getItem('user');
    if (userData) {
      const user = JSON.parse(userData);
      setUserId(user.userId);
    }
  }, []);

  const fetchOrders = async () => {
    setLoading(true);
    try {
      const response = await apiClient.get("/listAllParcels");
      const allOrders = response.data.content;
      const userOrders = allOrders.filter(order => order.userId === userId);
      setOrders(userOrders);
    } catch (error) {
      console.error("Failed to fetch orders:", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    if (userId) {
      fetchOrders();
    }
  }, [userId]);

  const handleRefresh = () => {
    fetchOrders();
  };

  return (
    <div className="my-order-page">
      <div className="my-order-header">
        <h1 className="my-orders">My Orders</h1>
        <div>
          <button className="refresh-button" onClick={handleRefresh}>
            &#x21bb; Refresh
          </button>
          <button className="create-button" onClick={() => navigate("/createparcel")}>
            + Create Order
          </button>
        </div>
      </div>

      <div className="table-container">
        {loading ? (
          <p>Loading...</p>
        ) : orders.length === 0 ? (
          <p>No orders found.</p>
        ) : (
          <table>
            <thead>
              <tr>
                <th>Parcel ID</th>
                <th>Receiver First Name</th>
                <th>Receiver Last Name</th>
                <th>Pickup Address</th>
                <th>Destination Address</th>
                <th>Receiver Phone Number</th>
                <th>No of Items</th>
                <th>Item Type</th>
                <th>Delivery Type</th>
                <th>Fragile Item</th>
                <th>Total Bill</th>
              </tr>
            </thead>
            <tbody>
              {orders.map((order) => (
                <tr key={order.parcelId}>
                  <td>{order.parcelId}</td>
                  <td>{order.receiverFirstName}</td>
                  <td>{order.receiverLastName}</td>
                  <td>{order.pickupAddress}</td>
                  <td>{order.destinationAddress}</td>
                  <td>{order.receiverPhoneNumber}</td>
                  <td>{order.noOfItems}</td>
                  <td>{order.itemType}</td>
                  <td>{order.deliveryType}</td>
                  <td>{order.fragileItem ? "Yes" : "No"}</td>
                  <td>{order.totalBill}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}
