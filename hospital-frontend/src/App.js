import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LandingPage from './components/LandingPage';
import PatientList from './components/Patient/PatientList';
import DoctorList from './components/Doctor/DoctorList';
import AppointmentList from './components/Appointment/AppointmentList';
import AddPatient from './components/Patient/AddPatient';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/patients" element={<PatientList />} />
        <Route path="/doctors" element={<DoctorList />} />
        <Route path="/appointments" element={<AppointmentList />} />
        <Route path="/add-patient" element={<AddPatient />} />

      </Routes>
    </Router>
  );
}

export default App;
