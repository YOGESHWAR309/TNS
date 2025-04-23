import React from 'react';
import { Link } from 'react-router-dom';
import './Header.css';

const Header = () => {
    return (
        <header className="header">
            <h1>Pothole Complaint Management System</h1>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/complaints">View Complaints</Link></li>
                    <li><Link to="/submit-complaint">Submit a Complaint</Link></li>
                </ul>
            </nav>
        </header>
    );
};

export default Header;