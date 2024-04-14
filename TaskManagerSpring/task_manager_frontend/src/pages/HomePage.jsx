import React, { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";
import { useDispatch } from 'react-redux';
import { setLogin } from '../state';
import Navbar from '../components/Navbar';
import { useSelector } from 'react-redux';

const HomePage = ({ onLogout }) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const userName = useSelector((state)=> state.auth.userName);

  const handleLogout = () => {
    dispatch(
      setLogin({
        token: null,
        userName: null
      })
    );
    navigate('/');
  };

  return (
    <div>
      <h2>Hello, {userName}</h2>
      <Navbar/>
      <div style={{ padding: '20px' }}>
        {/* Content of your home page */}
      </div>
    </div>
  );
};

export default HomePage;

