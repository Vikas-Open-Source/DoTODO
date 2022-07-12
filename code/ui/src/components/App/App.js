import './App.css';
import '../Dashboard/Dashboard'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Dashboard from '../Dashboard/Dashboard';
import React, { useState } from 'react';
import Login from '../Login/Login'

function App() {
  const [token, setToken] = useState()

  if(!token){
    return <Login setToken={setToken}/>
  }

  return (
    <div className='wrapper'>
      <h1>DoTODO Application</h1>
      <BrowserRouter>
        <Routes>
          <Route exact path="/dashboard" element={<Dashboard />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;