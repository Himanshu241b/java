import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import Navbar from '../components/Navbar';
import { useNavigate } from "react-router-dom";


const JoinedClassrooms = () => {
  const token = useSelector((state) => state.auth.token);
  const [classrooms, setClassrooms] = useState([]);
  const navigate = useNavigate();


  const handleClassroomClick = (classId) => {
    navigate(`/tasksPage/${classId}`);   
  }

  const leaveClassroom = async (classId) => {
    try {
      const response = await fetch(`http://localhost:5555/classroom/leaveClassroom/${classId}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          Authorization: 'Bearer ' + token,
        },
      }).then((response)=> console.log(response))
      
      // Remove the classroom from the list after leaving
      setClassrooms(classrooms.filter((classroom) => classroom.classId !== classId));
    } catch (error) {
      console.error('Error leaving classroom:', error.message);
    }
  };

  useEffect(() => {
    const fetchJoinedClassrooms = async () => {
      try {
        const response = await fetch('http://localhost:5555/classroom/joinedClassrooms', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + token,
          },
        });
        if (!response.ok) {
          throw new Error('Failed to fetch joined classrooms');
        }
        const data = await response.json();
        setClassrooms(data);
      } catch (error) {
        console.error('Error fetching joined classrooms:', error.message);
      }
    };

    fetchJoinedClassrooms();

    // Cleanup function
    return () => {};
  }, []); // Empty dependency array to run only once when component mounts

  return (
    <>
      <Navbar />
      <div>
        <h2>Joined Classrooms</h2>
        <ul>
          {classrooms.map((classroom, index) => (
            <li key={classroom.classId} onClick={() => handleClassroomClick(classroom.classId)}>
              {classroom.classroomName}
              <button onClick={() => leaveClassroom(classroom.classId)}>Leave</button>
            </li>
          ))}
        </ul>
      </div>
    </>
  );
};

export default JoinedClassrooms;
