import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import Navbar from '../components/Navbar';
import { useNavigate } from "react-router-dom";


const CreatedClassroom = () => {
  const token = useSelector((state) => state.auth.token);
  const [classrooms, setClassrooms] = useState([]);
  const [newClassroomName, setNewClassroomName] = useState('');
  const [showForm, setShowForm] = useState(false);
  const [updateClassroomName, setUpdateClassroomName] = useState('');
  const [classroomAdded, setClassroomAdded] = useState(false); // State to track new classroom addition
  const [classroomDeleted, setClassroomDeleted] = useState(false); // State to track of deleted class
  const [classroomUpdated, setClassroomUpdated] = useState(false); // State to track update of classroom
  const [editingClassId, setEditingClassId] = useState(null); // State to track which classroom is being edited
  const navigate = useNavigate();

  const handleClassroomClick = (classId) => {
    navigate(`/tasksPage/${classId}`, { state: { fromCreatedClassroom: true } });   
  }

  
  const handleClassroomDelete = (e, classId) => {
    e.preventDefault();

    fetch(`http://localhost:5555/classroom/${classId}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token,
      },
    })
      .then((data) => {
        console.log(data);
        setClassroomDeleted(!classroomDeleted);
      })
      .catch((error) => {
        console.error('Error deleting classroom:', error);
      });
  };

  const handleClassroomUpdate = (e, classId) => {
    e.preventDefault();

    fetch(`http://localhost:5555/classroom/${classId}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token,
      },
      body: JSON.stringify({
        classroomName: updateClassroomName,
      }),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        setClassroomUpdated(!classroomUpdated);
        setEditingClassId(null); // Reset editing state after updating
      })
      .catch((error) => {
        console.error('Error updating classroom:', error);
      });
  };

  useEffect(() => {
    fetch('http://localhost:5555/classroom/createdClassrooms', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token,
      },
    })
      .then((response) => response.json())
      .then((data) => {
        setClassrooms(data);
      })
      .catch((error) => {
        console.error('Error fetching classrooms:', error);
      });
  }, [classroomAdded, classroomDeleted, classroomUpdated]); // Trigger useEffect when classroomAdded state changes

  const handleInputChange = (event) => {
    setNewClassroomName(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    fetch('http://localhost:5555/classroom', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token,
      },
      body: JSON.stringify({
        classroomName: newClassroomName,
      }),
    })
      .then((response) => response.json())
      .then((data) => {
        setClassrooms([...classrooms, data]);
        setNewClassroomName('');
        setShowForm(false);
        setClassroomAdded(!classroomAdded); // Update classroomAdded state to trigger useEffect
      })
      .catch((error) => {
        console.error('Error adding classroom:', error);
      });
  };

  return (
    <>
      <Navbar />
      <div>
        <h2>Classrooms</h2>
        <button onClick={() => setShowForm(true)}>Add New Classroom</button>

        {showForm && (
          <form onSubmit={handleSubmit}>
            <input
              type="text"
              placeholder="Enter classroom name"
              value={newClassroomName}
              onChange={handleInputChange}
            />
            <button type="submit">Add Classroom</button>
          </form>
        )}

        <ul>
          {classrooms.map((classroom) => (
            <li key={classroom.classId} onClick={() => handleClassroomClick(classroom.classId)}>
              {editingClassId === classroom.classId ? (
                <>
                  <input
                    type="text"
                    value={updateClassroomName}
                    onChange={(e) => setUpdateClassroomName(e.target.value)}
                  />
                  <button onClick={(e) => handleClassroomUpdate(e, classroom.classId)}>UPDATE</button>
                </>
              ) : (
                <>
                  {classroom.classroomName}
                  <button onClick={(e) => handleClassroomDelete(e, classroom.classId)}>DELETE</button>
                  <button onClick={() => { setUpdateClassroomName(classroom.classroomName); setEditingClassId(classroom.classId); }}>EDIT</button>
                </>
              )}
            </li>
          ))}
        </ul>
      </div>
    </>
  );
};

export default CreatedClassroom;
