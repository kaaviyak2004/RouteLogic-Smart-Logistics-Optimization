import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { PayPalScriptProvider, PayPalButtons } from "@paypal/react-paypal-js";
import "./createparcel.css";
import apiClient from "../../service/api_service";

export default function CreateParcel() {
   const navigate = useNavigate();
   const [formData, setFormData] = useState({
      userId: "",
      receiverFirstName: "",
      receiverLastName: "",
      pickupAddress: "",
      destinationAddress: "",
      receiverPhoneNumber: "",
      noOfItems: "",
      itemType: "",
      deliveryType: "Standard",
      fragileItem: false,
      totalBill: "",
   });

   const [errors, setErrors] = useState({});
   const [showPayPal, setShowPayPal] = useState(false);
   const [paymentSuccess, setPaymentSuccess] = useState(false);
   const [baseBill, setBaseBill] = useState(0);

   useEffect(() => {
      const userData = localStorage.getItem('user');
      if (userData) {
         const user = JSON.parse(userData);
         setFormData((prevFormData) => ({
            ...prevFormData,
            userId: user.userId,
         }));
      }
   }, []);

   const calculateTotalBill = (items, isFragile, deliveryType) => {
      let total = baseBill;
      if (isFragile) {
         total = (total * 1.5).toFixed(2);
      }
      if (deliveryType === "Express") {
         total = (parseFloat(total) + 5).toFixed(2); // Add $5 for express delivery
      }
      return total;
   };

   const handleChange = (e) => {
      const { name, value, type, checked } = e.target;
      const updatedFormData = {
         ...formData,
         [name]: type === "checkbox" ? checked : value,
      };
      if (name === "noOfItems") {
         const newBaseBill = (Math.random() * (value * 3 - value * 2) + value * 2).toFixed(2);
         setBaseBill(newBaseBill);
         updatedFormData.totalBill = calculateTotalBill(value, formData.fragileItem, formData.deliveryType);
      } else if (name === "fragileItem" || name === "deliveryType") {
         updatedFormData.totalBill = calculateTotalBill(formData.noOfItems, name === "fragileItem" ? checked : formData.fragileItem, name === "deliveryType" ? value : formData.deliveryType);
      }
      setFormData(updatedFormData);
   };

   const validateForm = () => {
      const newErrors = {};
      if (!formData.receiverFirstName) newErrors.receiverFirstName = "First Name is required";
      if (!formData.receiverLastName) newErrors.receiverLastName = "Last Name is required";
      if (!formData.pickupAddress) newErrors.pickupAddress = "Pickup Address is required";
      if (!formData.destinationAddress) newErrors.destinationAddress = "Destination Address is required";
      if (!formData.receiverPhoneNumber || !/^\d{10}$/.test(formData.receiverPhoneNumber))
         newErrors.receiverPhoneNumber = "Phone number must be a valid 10-digit number";
      if (!formData.noOfItems || isNaN(formData.noOfItems))
         newErrors.noOfItems = "Items must be a valid number";
      if (!formData.itemType) newErrors.itemType = "Item Type is required";

      setErrors(newErrors);
      return Object.keys(newErrors).length === 0;
   };

   const handleSubmit = async (e) => {
      e.preventDefault();
      if (validateForm()) {
         try {
            setShowPayPal(true);
            const response = await apiClient.post('/createParcel', formData);
            console.log("Parcel created successfully:", response)
         } catch (error) {
            console.error("Failed to create parcel:", error);
            setErrors({ api: "Failed to create parcel. Please try again." });
         }
      }
   };

   const handlePaymentSuccess = () => {
      setPaymentSuccess(true);

      setTimeout(() => {
         setFormData({
            userId: "",
            receiverFirstName: "",
            receiverLastName: "",
            pickupAddress: "",
            destinationAddress: "",
            receiverPhoneNumber: "",
            noOfItems: "",
            itemType: "",
            deliveryType: "Standard",
            fragileItem: false,
            totalBill: "",
         }); // Reset form data
         setPaymentSuccess(false); // Reset paymentSuccess state
         navigate("/user-dashboard"); // Redirect to Create Parcel page after 5 seconds
      }, 5000); // Redirect after 5 seconds
   };

   return (
      <div className="parcel-modal">
         {!paymentSuccess ? (
            <>
               <h2 className="parcel-details-text">Parcel Details</h2>
               <form className="create-parcel-form" onSubmit={handleSubmit}>
                  <div className="form-group row">
                     <div className="col">
                        <label>Receiver's First Name:</label>
                        <input
                           type="text"
                           name="receiverFirstName"
                           value={formData.receiverFirstName}
                           onChange={handleChange}
                           placeholder="Enter First name"
                        />
                        {errors.receiverFirstName && (
                           <span className="error">{errors.receiverFirstName}</span>
                        )}
                     </div>
                     <div className="col">
                        <label>Receiver's Last Name:</label>
                        <input
                           type="text"
                           name="receiverLastName"
                           value={formData.receiverLastName}
                           onChange={handleChange}
                           placeholder="Enter Last name"
                        />
                        {errors.receiverLastName && (
                           <span className="error">{errors.receiverLastName}</span>
                        )}
                     </div>
                  </div>

                  <div className="form-group">
                     <label>Pickup Address:</label>
                     <textarea
                        name="pickupAddress"
                        value={formData.pickupAddress}
                        onChange={handleChange}
                        placeholder="Enter address"
                     />
                     {errors.pickupAddress && <span className="error">{errors.pickupAddress}</span>}
                  </div>

                  <div className="form-group">
                     <label>Destination Address:</label>
                     <textarea
                        name="destinationAddress"
                        value={formData.destinationAddress}
                        onChange={handleChange}
                        placeholder="Enter address"
                     />
                     {errors.destinationAddress && <span className="error">{errors.destinationAddress}</span>}
                  </div>

                  <div className="col">
                     <label>Receiver's Phone Number:</label>
                     <input
                        type="text"
                        name="receiverPhoneNumber"
                        value={formData.receiverPhoneNumber}
                        onChange={handleChange}
                        placeholder="Enter phone number"
                     />
                     {errors.receiverPhoneNumber && <span className="error">{errors.receiverPhoneNumber}</span>}
                  </div>

                  <div className="form-group row align-items-center">
                     <div className="col">
                        <label>Items:</label>
                        <input
                           type="number"
                           name="noOfItems"
                           value={formData.noOfItems}
                           onChange={handleChange}
                           placeholder="Enter number of items"
                        />
                        {errors.noOfItems && <span className="error">{errors.noOfItems}</span>}
                     </div>
                     <div className="col">
                        <label>Item Type:</label>
                        <input
                           type="text"
                           name="itemType"
                           value={formData.itemType}
                           onChange={handleChange}
                           placeholder="Enter item type"
                        />
                        {errors.itemType && <span className="error">{errors.itemType}</span>}
                     </div>
                  </div>

                  <div className="form-group">
                     <label>Delivery Type:</label>
                     <select
                        name="deliveryType"
                        value={formData.deliveryType}
                        onChange={handleChange}
                     >
                        <option value="Standard">Standard</option>
                        <option value="Express">Express</option>
                     </select>
                  </div>

                  <div className="form-group row align-items-center">
                     <div className="col d-flex align-items-center">
                        <label style={{ marginRight: "10px" }}>Fragile:</label>
                        <input
                           type="checkbox"
                           name="fragileItem"
                           checked={formData.fragileItem}
                           onChange={handleChange}
                        />
                     </div>
                  </div>

                  <div className="form-group">
                     <label>Total Bill ($):</label>
                     <p>{formData.totalBill}</p>
                  </div>

                  {!showPayPal ? (
                     <button type="submit" className="submit-button">
                        Proceed to Payment
                     </button>
                  ) : (
                     <PayPalScriptProvider
                        options={{
                           "client-id":
                              "Af8O4xVxQcyeUVCOo9vhzkbFfrHV9OH3EokGi4MMjbvU9QTBqEqw2Fnv3VfcQW3IMuBLbGgxYjbldr-L",
                           currency: "USD",
                        }}
                     >
                        <PayPalButtons
                           createOrder={(data, actions) => {
                              return actions.order.create({
                                 purchase_units: [
                                    {
                                       amount: {
                                          value: formData.totalBill,
                                       },
                                    },
                                 ],
                              });
                           }}
                           onApprove={(data, actions) => {
                              return actions.order.capture().then(() => {
                                 handlePaymentSuccess();
                              });
                           }}
                           onCancel={() => {
                              alert("Payment was canceled.");
                           }}
                           onError={(err) => {
                              console.error("Error during payment:", err);
                              alert("Something went wrong during the payment process.");
                           }}
                        />
                     </PayPalScriptProvider>
                  )}
               </form>
            </>
         ) : (
            <div className="success-card">
               <div className="icon">✔️</div>
               <h3>Payment Successful!</h3>
               <p>Thank you for your payment. Redirecting in few seconds...</p>
            </div>
         )}
      </div>
   );
}