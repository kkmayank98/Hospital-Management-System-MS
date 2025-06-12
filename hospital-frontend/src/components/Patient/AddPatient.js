import React, { useState } from 'react';
import axios from 'axios';

const AddPatient = () => {
  const [patient, setPatient] = useState({
    name: '',
    age: '',
    gender: '',
    contactNumber: '',
    email: ''
  });

  const handleChange = (e) => {
    setPatient({ ...patient, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
     await axios.post("http://localhost:8080/api/patients", patient);// 8080 = API Gateway
      alert("Patient added successfully");
    } catch (error) {
      alert("Error adding patient");
      console.error(error);
    }
  };

  return (
    <div>
      <h2>Add Patient</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" placeholder="Name" value={patient.name} onChange={handleChange} required /><br />
        <input type="number" name="age" placeholder="Age" value={patient.age} onChange={handleChange} required /><br />
        <input type="text" name="gender" placeholder="Gender" value={patient.gender} onChange={handleChange} required /><br />
        <input type="text" name="contactNumber" placeholder="Contact Number" value={patient.contactNumber} onChange={handleChange} required /><br />
        <input type="email" name="email" placeholder="Email" value={patient.email} onChange={handleChange} required /><br />
        <button type="submit">Add Patient</button>
      </form>
    </div>
  );
};

export default AddPatient;
