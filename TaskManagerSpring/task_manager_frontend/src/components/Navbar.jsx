import React from 'react'
import { setLogout } from '../state';
import { useNavigate } from "react-router-dom";
import { useDispatch } from 'react-redux';

const Navbar = () =>{

    const navigate = useNavigate();
    const dispatch = useDispatch();
    



    const home=(e)=>{
        e.preventDefault();
        navigate('/home');
    }
    const createdClassrooms=(e) =>{
        e.preventDefault();
        navigate('/createdClasses');
    }
    const joinedClassrooms=(e) =>{
        e.preventDefault();
        navigate('/joinedClasses');
    }

    const logout=()=>{
        dispatch(
            setLogout()
          );
          navigate('/');
    };

   return(
        <>
        <div className="navbar">
            <ul>
                <li>
                    <a href="" onClick={home}> HOME </a>
                </li>
                <li>
                    <a href="" onClick={createdClassrooms}> Created classes </a>
                </li>
                <li>
                    <a href="" onClick={joinedClassrooms}> Joined classes </a>
                </li>
               
            
                <li style={{ position: 'absolute', right: 30 }}>
                <button type="button" onClick={logout} >LOGOUT</button>
                </li>
            </ul>
           
        </div>
        <br/>
        </>
    )
}

export default Navbar;