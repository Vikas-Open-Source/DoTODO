import React, { useState } from 'react'
import PropTypes from 'prop-types';
import './Login.css'


async function loginUser(credentials){
    var loginAPIURL = 'http://localhost:8080/login'
    return fetch(loginAPIURL, {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body: credentials
    }).then(data => data.json())
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
        setToken(token);
    }

    return (
        <div className='login-wrapper'>
            <h1>Please Login</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    <p>Username</p>
                    <input type="text" onChange={event => setUsername(event.target.value)} />
                </label>
                <label>
                    <p>Password</p>
                    <input type="password" onChange={event => setPassword(event.target.value)} />
                </label>
                <div>
                    <button type='submit'>Submit</button>
                </div>
            </form>
        </div>
    )
}

Login.propTypes = {
    setToken: PropTypes.func.isRequired
}