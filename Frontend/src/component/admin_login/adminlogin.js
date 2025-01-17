import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./adminlogin.css";

export default function AdminLogin() {
   const navigate = useNavigate();
   const [formData, setFormData] = useState({
      email: "",
      password: "",
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
      if (!formData.email) newErrors.email = "Email is required";
      if (!formData.password) newErrors.password = "Password is required";
      setErrors(newErrors);
      return Object.keys(newErrors).length === 0;
   };

   const handleSubmit = async (e) => {
      e.preventDefault();
      if (validateForm()) {
         setSubmitted(true);
         // Logic to handle form submission
         console.log("Form submitted", formData);
         // try {
         //    const response = await fetch("https://api.example.com/admin/login", {
         //       method: "POST",
         //       headers: {
         //          "Content-Type": "application/json",
         //       },
         //       body: JSON.stringify(formData),
         //    });
         //    if (response.ok) {
         //       // Simulate successful login
         //       navigate("/admin_dashboard");
         //    } else {
         //       setErrors({ api: "Login failed. Please check your credentials." });
         //       setSubmitted(false);
         //    }
         // } catch (error) {
         //    setErrors({ api: "An error occurred. Please try again later." });
         //    setSubmitted(false);
         // }
         navigate("/admin_dashboard");
      }
   };

   return (
      <div className="admin-login-page">
         <h2>Admin Login</h2>
         {submitted ? (
            <div className="thank-you-message">
               <h3>Login Successful!</h3>
               <p>Redirecting to admin dashboard...</p>
            </div>
         ) : (
            <form className="login-form" onSubmit={handleSubmit}>
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
                  <label>Password:</label>
                  <input
                     type="password"
                     name="password"
                     value={formData.password}
                     onChange={handleChange}
                     placeholder="Enter your password"
                  />
                  {errors.password && <span className="error">{errors.password}</span>}
               </div>
               {errors.api && <span className="error">{errors.api}</span>}
               <button type="submit" className="submit-button">
                  Login
               </button>
            </form>
         )}
      </div>
   );
}
