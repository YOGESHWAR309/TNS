import React from 'react';
import ComplaintForm from '../components/ComplaintForm';

const Home = () => {
    return (
        <div>
            <h1>Pothole Complaint Management System</h1>
            <p>Welcome to the Pothole Complaint Management System. Please submit your complaints below:</p>
            <ComplaintForm />
        </div>
    );
};

export default Home;