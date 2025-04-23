import React from 'react';

const Complaints = () => {
    const [complaints, setComplaints] = React.useState([]);

    React.useEffect(() => {
        // Fetch complaints from an API or local storage
        const fetchComplaints = async () => {
            // Placeholder for fetching logic
            const response = await fetch('/api/complaints'); // Adjust the API endpoint as needed
            const data = await response.json();
            setComplaints(data);
        };

        fetchComplaints();
    }, []);

    return (
        <div>
            <h1>Submitted Complaints</h1>
            <ul>
                {complaints.map((complaint) => (
                    <li key={complaint.id}>
                        <p>{complaint.description}</p>
                        <p>Status: {complaint.status}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Complaints;