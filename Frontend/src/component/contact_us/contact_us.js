import React, { useState } from "react";
import "./contact_us.css";

export default function ContactUs() {
   const [formData, setFormData] = useState({
      name: "",
      email: "",
      message: "",
   });

   const [errors, setErrors] = useState({});
   const [submitted, setSubmitted] = useState(false);

   const handleChange = (e) => {
      const { name, value } = e.target;
      setFormData({
         ...formData,
         [name]: value,
      });
   };

   const validateForm = () => {
      const newErrors = {};
      if (!formData.name) newErrors.name = "Name is required";
      if (!formData.email) newErrors.email = "Email is required";
      if (!formData.message) newErrors.message = "Message is required";
      setErrors(newErrors);
      return Object.keys(newErrors).length === 0;
   };

   const handleSubmit = (e) => {
      e.preventDefault();
      if (validateForm()) {
         setSubmitted(true);
         // Logic to handle form submission
         console.log("Form submitted", formData);
      }
   };

   return (
      <div className="contact-us-page">
         <h2>Contact Us</h2>
         {submitted ? (
            <div className="thank-you-message">
               <h3>Thank you for contacting us!</h3>
               <p>We will get back to you within 24 hours.</p>
            </div>
         ) : (
            <form className="contact-form" onSubmit={handleSubmit}>
               <div className="form-group">
                  <label>Name:</label>
                  <input
                     type="text"
                     name="name"
                     value={formData.name}
                     onChange={handleChange}
                     placeholder="Enter your name"
                  />
                  {errors.name && <span className="error">{errors.name}</span>}
               </div>
               <div className="form-group">
                  <label>Email:</label>
                  <input
                     type="email"
                     name="email"
                     value={formData.email}
                     onChange={handleChange}
                     placeholder="Enter your email"
                  />
                  {errors.email && <span className="error">{errors.email}</span>}
               </div>
               <div className="form-group">
                  <label>Message:</label>
                  <textarea
                     name="message"
                     value={formData.message}
                     onChange={handleChange}
                     placeholder="Enter your message"
                  />
                  {errors.message && <span className="error">{errors.message}</span>}
               </div>
               <button type="submit" className="submit-button">
                  Submit
               </button>
            </form>
         )}
      </div>
   );
}
