import React, { useState } from 'react'
import PropTypes from 'prop-types';
import './Login.css'

export default function Login({ setToken }) {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    return (
        <div className='login-wrapper'>
            <h1>Please Login</h1>
            <form>
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