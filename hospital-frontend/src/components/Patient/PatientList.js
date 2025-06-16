import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const PatientList = () => {
  const [patients, setPatients] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchPatients();
  }, []);

  const fetchPatients = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/patients");
      setPatients(response.data);
    } catch (error) {
      console.error("Error fetching patients", error);
    }
  };

  const handleDelete = async (id) => {
    const confirm = window.confirm("Are you sure you want to delete this patient?");
    if (!confirm) return;

    try {
      await axios.delete(`http://localhost:8080/api/patients/${id}`);
    //  alert("Patient deleted");
      fetchPatients(); // refresh list
    } catch (error) {
      console.error("Error deleting patient", error);
    }
  };

  const handleEdit = (id) => {
    navigate(`/edit-patient/${id}`);
  };

  return (
    <div>
      <h2>Patient List</h2>
      <button onClick={() => navigate('/add-patient')}>Add Patient</button>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Contact</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {patients.map((p) => (
            <tr key={p.id}>
              <td>{p.name}</td>
              <td>{p.age}</td>
              <td>{p.gender}</td>
              <td>{p.contactNumber}</td>
              <td>{p.email}</td>
              <td>
                <button onClick={() => handleEdit(p.id)}>Edit</button>
                &nbsp;
                <button onClick={() => handleDelete(p.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PatientList;
