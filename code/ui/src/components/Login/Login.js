import React, { useState } from 'react'
import PropTypes from 'prop-types';
import Paper from '@mui/material/Paper';
import './Login.css'


async function loginUser(credentials) {
    var loginAPIURL = 'http://localhost:8080/login'
    return fetch(loginAPIURL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: credentials
    }).then(response => {
        console.log(response.ok)
        return response.ok ? response.json() : null
    })
}

export default function Login({ setToken }) {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async event => {
        event.preventDefault();
        const token = await loginUser({
            username,
            password
        });
        if (token != null) {
            setToken(token);
        }
    }

    return (
        <div className='login-main'>
            <h1 style={{textAlign: 'center', fontSize : 50}}>Do TODO</h1>
            <Paper elevation={3} className='login-wrapper' style={{backgroundColor: '#f7fcf9'}}>
                <div className='login'>
                    <p style={{textAlign: 'center'}}>Login</p>
                    <form onSubmit={handleSubmit}>
                        <label>
                            <p style={{marginBottom : 0}}>Username</p>
                            <input type="text" onChange={event => setUsername(event.target.value)} />
                        </label>
                        <label>
                            <p style={{marginBottom : 0}}>Password</p>
                            <input type="password" onChange={event => setPassword(event.target.value)} />
                        </label>
                        <div>
                            <button type='submit' style={{marginTop : 30}}>Sign In</button>
                        </div>
                    </form>
                </div>
            </Paper>
        </div>
    )
}

Login.propTypes = {
    setToken: PropTypes.func.isRequired
}