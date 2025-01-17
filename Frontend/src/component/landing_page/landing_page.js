import React from "react";
import "./landing_page.css";
import { Link } from "react-router-dom";

export default function LandingPage() {
  return (
    <div className="page-container">
      {/* Dropdown Menu */}
      <div className="dropdown">
        <button className="dropbtn">Login</button>
        <div className="dropdown-content">
          <Link to="/login">User Login</Link>
          <Link to="/admin_login">Admin Login</Link>
        </div>
      </div>

      {/* Hero Section */}
      <div className="hero-section">
        <h1>Smart Logistics</h1>
        <p>Your trusted courier service, making delivery seamless and reliable.</p>
        <div className="hero-buttons">
          <Link to="/register" className="hero-button">Register</Link>
          <Link to="/contactus" className="hero-button">Contact Us</Link>
        </div>
      </div>

      {/* Footer */}
      <footer className="footer">
        <p>&copy; 2023 Smart Logistics. Crafted with care for your convenience.</p>
      </footer>
    </div>
  );
}
