import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import React from "react";
import "./App.css";
import Login from "./component/Login/login";
import AdminLogin from "./component/admin_login/adminlogin";
import Admin from "./component/admin/admin";
import CreateParcel from "./component/customer/createparcel";
import Register from "./component/register/register";
import LandingPage from "./component/landing_page/landing_page";
import UserDashboard from "./component/customer/user_dashboard";
import Profile from "./component/profile/profile";
import ContactUs from "./component/contact_us/contact_us";

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/user-dashboard" element={<UserDashboard />} />
          <Route path="/createparcel" element={<CreateParcel />} />
          <Route path="/admin_login" element={<AdminLogin />} />
          <Route path="/admin_dashboard" element={<Admin />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/contactus" element={<ContactUs />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
