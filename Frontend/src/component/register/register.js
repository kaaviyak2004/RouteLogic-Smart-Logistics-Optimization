import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './register.css';
import apiClient from '../../service/api_service';

export default function Register() {

   const [firstName, setFirstName] = useState('');
   const [lastName, setLastName] = useState('');
   const [email, setEmail] = useState('');
   const [password, setPassword] = useState('');
   const [phoneNumber, setPhoneNumber] = useState('');
   const [error, setError] = useState('');
   const [loading, setLoading] = useState(false);
   const navigate = useNavigate();

   const handleRegister = async (e) => {
       e.preventDefault();
       if (!firstName || !lastName || !email || !password || !phoneNumber) {
           setError('All fields are required.');
           return;
       }
       setLoading(true);
       try {
           const response = await apiClient.post('/api/users/register', {
               firstName,
               lastName,
               email,
               password,
               phoneNumber,
           });
           const userData = response.data;
           console.log('Registration successful:', userData);
           localStorage.setItem('user', JSON.stringify(userData));
           navigate('/user-dashboard');
       } catch (error) {
           console.error('Registration failed:', error);
           setError('Registration failed. Please try again.');
       } finally {
           setLoading(false);
       }
   };

    return(
        <div id="form-container" className="container-fluid">
            {loading && (
                <div className="loading-overlay">
                    <div className="loading-circle"></div>
                </div>
            )}
            <form onSubmit={handleRegister}>
            <h2> <span className="bi bi-person-fill"></span> Register</h2>
                {error && <div className="alert alert-danger">{error}</div>}
                <div className="mb-2">
                    <label className="form-label">First Name</label>
                    <div>
                        <input type="text" placeholder="First Name" className="form-control" value={firstName} onChange={(e) => setFirstName(e.target.value)}/>
                    </div>
                </div>
                <div className="mb-2">
                    <label className="form-label">Last Name</label>
                    <div>
                        <input type="text" placeholder="Last Name" className="form-control" value={lastName} onChange={(e) => setLastName(e.target.value)}/>
                    </div>
                </div>
                <div className="mb-2">
                    <label className="form-label">Email Address</label>
                    <div>
                        <input type="email" placeholder="example@gmail.com" className="form-control" value={email} onChange={(e) => setEmail(e.target.value)}/>
                    </div>
                </div>
                <div className="mb-2">
                    <label className="form-label">Password</label>
                    <div>
                        <input type="password" placeholder="Password" className="form-control" value={password} onChange={(e) => setPassword(e.target.value)}/>
                    </div>
                </div>
                <div className="mb-2">
                    <label className="form-label">Phone Number</label>
                    <div>
                        <input type="number" placeholder="1234567890" className="form-control" value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)}/>
                    </div>
                </div>
                <div className="mb-2"> 
                    <button type="submit" className="btn btn-primary w-100" disabled={loading}>Register</button>
                </div>
            </form>
        </div>
    )
}