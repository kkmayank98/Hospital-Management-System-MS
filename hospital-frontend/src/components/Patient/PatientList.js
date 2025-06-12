import React from 'react';
import { useNavigate } from 'react-router-dom';

const PatientList = () => {
  const navigate = useNavigate();

  return (
    <div>
      <h2>Patient List</h2>
      <button onClick={() => navigate('/add-patient')}>Add Patient</button>
    </div>
  );
};

export default PatientList;
