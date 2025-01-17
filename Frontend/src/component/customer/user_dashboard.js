import React from 'react';
import { useNavigate } from 'react-router-dom';
import "./user_dashboard.css";
import MyOrder from './myorder';

export default function UserDashboard() {
  const navigate = useNavigate();

  return (
    <div className="customer-dashboard">
      <div className="dashboard-header">
        <div className="dashboard-title">Dashboard</div>
        <button className="profile-button" onClick={() => navigate('/profile')}>
          <span className="bi bi-person-fill"></span> Profile
        </button>
      </div>
      <MyOrder />
    </div>
  );
}
