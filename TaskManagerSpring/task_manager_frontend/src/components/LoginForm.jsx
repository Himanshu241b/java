import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import { useDispatch } from 'react-redux';
import { setLogin } from '../state';


const LoginForm = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');


  const handleRegisterClick = (e) =>{
      e.preventDefault();
      navigate('/register');
      }
  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:5555/users/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          email,
          password,
        }),
      });

      if (!response.ok) {
        throw new Error('Login failed');
      }

      const data = await response.json();

      dispatch(
        setLogin({
          token: data.token,
          userName: data.userName
        })
      );
      navigate('/home');

      console.log('Successfully logged in with token:', data.token);
      // You can store the token in local storage or session storage for further use
    } catch (error) {
      console.error('Login failed:', error.message);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Login</h2>
      <div>
        <label>Email:</label>
        <input type="email" value={email} onChange={handleEmailChange} />
      </div>
      <div>
        <label>Password:</label>
        <input type="password" value={password} onChange={handlePasswordChange} />
      </div>
      <button type="submit">Login</button>
      {/* Add a register link */}
      <p>Don't have an account? <a href="/register" onClick = {handleRegisterClick}>Register</a></p>

    </form>

  );
};

export default LoginForm;
