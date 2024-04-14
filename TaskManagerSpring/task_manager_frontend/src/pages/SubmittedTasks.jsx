import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useSelector } from 'react-redux';


const SubmittedTasks = () => {
  const { classId } = useParams();
  const [submittedTasks, setSubmittedTasks] = useState([]);
  const token = useSelector((state)=>state.auth.token);

  useEffect(() => {
    const fetchSubmittedTasks = async () => {
      try {
        const response = await fetch(`http://localhost:5555/submit/submitted?classId=${classId}`,
        {
          method: 'GET',
        headers:{
          'Content-Type': 'application/json',
          Authorization: 'Bearer ' + token,
        }
      }
        );
        if (!response.ok) {
          throw new Error('Failed to fetch submitted tasks');
        }
        const data = await response.json();
        setSubmittedTasks(data);
        console.log(data);
      } catch (error) {
        console.error('Error fetching submitted tasks:', error);
      }
    };
    fetchSubmittedTasks();
  }, [classId]);

  return (
    <div>
      <ul>
        {submittedTasks.map(submittedTask => (
          <li key={submittedTask.submissionId}>
            <h4>{submittedTask.taskTitle}</h4>
            <h5>{submittedTask.taskDescription}</h5>
            <p>{submittedTask.taskDeadline}</p>
            <h5>{submittedTask.status}</h5>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SubmittedTasks;
