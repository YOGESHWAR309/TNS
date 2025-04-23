import React, { useState } from 'react';

const ComplaintForm = () => {
    const [location, setLocation] = useState('');
    const [description, setDescription] = useState('');
    const [contactInfo, setContactInfo] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle form submission logic here
        console.log({ location, description, contactInfo });
        // Reset form fields
        setLocation('');
        setDescription('');
        setContactInfo('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="location">Location of Pothole:</label>
                <input
                    type="text"
                    id="location"
                    value={location}
                    onChange={(e) => setLocation(e.target.value)}
                    required
                />
            </div>
            <div>
                <label htmlFor="description">Description:</label>
                <textarea
                    id="description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    required
                />
            </div>
            <div>
                <label htmlFor="contactInfo">Your Contact Information:</label>
                <input
                    type="text"
                    id="contactInfo"
                    value={contactInfo}
                    onChange={(e) => setContactInfo(e.target.value)}
                    required
                />
            </div>
            <button type="submit">Submit Complaint</button>
        </form>
    );
};

export default ComplaintForm;