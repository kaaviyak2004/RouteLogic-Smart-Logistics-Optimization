import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './login.css';
import apiClient from '../../service/api_service';

export default function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();
    
    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await apiClient.post('/api/users/login', {
                email,
                password,
            });
            const userData = response.data;
            console.log('Login successful:', userData);
            localStorage.setItem('user', JSON.stringify(userData));
            navigate('/user-dashboard');
        } catch (error) {
            console.error('Login failed:', error);
            setError('Login failed. Please try again.');
        }
    };

    return (
        <div id="form-container" className="container-fluid">
            <form onSubmit={handleLogin}>
                <h2> <span className="bi bi-person-fill"></span>User Login</h2>
                {error && <div className="alert alert-danger">{error}</div>}
                <div className="mb-2">
                    <label className="form-label">Email Address</label>
                    <div>
                        <input type="text" placeholder="Email Address" className="form-control" value={email} onChange={(e) => setEmail(e.target.value)} />
                    </div>
                </div>
                <div className="mb-2">
                    <label className="form-label">Password</label>
                    <div>
                        <input type="password" placeholder="Password" className="form-control" value={password} onChange={(e) => setPassword(e.target.value)} />
                    </div>
                </div>
                <div className="mb-2"> 
                    <button type="submit" className="btn btn-primary w-100">Login</button>
                </div>
            </form>
        </div>
    );
}