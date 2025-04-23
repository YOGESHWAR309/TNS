import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import Complaints from './pages/Complaints';
import ComplaintForm from './components/ComplaintForm';
import './styles/App.css';

function App() {
    return (
        <Router>
            <div className="App">
                <Header />
                <Switch>
                    <Route path="/" exact component={Home} />
                    <Route path="/complaints" component={Complaints} />
                    <Route path="/submit-complaint" component={ComplaintForm} />
                </Switch>
                <Footer />
            </div>
        </Router>
    );
}

export default App;