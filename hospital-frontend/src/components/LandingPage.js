import React from 'react';
import { useNavigate } from 'react-router-dom';

const LandingPage = () => {
  const navigate = useNavigate();

  return (
    <div style={{ textAlign: "center", paddingTop: "50px" }}>
      <h1>🏥 Hospital Management System</h1>
      <div style={{ marginTop: "30px" }}>
        <button onClick={() => navigate('/patients')} style={buttonStyle}>Manage Patients</button>
        <button onClick={() => navigate('/doctors')} style={buttonStyle}>Manage Doctors</button>
        <button onClick={() => navigate('/appointments')} style={buttonStyle}>Manage Appointments</button>
      </div>
    </div>
  );
};

const buttonStyle = {
  margin: "10px",
  padding: "10px 20px",
  fontSize: "16px",
  cursor: "pointer"
};

export default LandingPage;
