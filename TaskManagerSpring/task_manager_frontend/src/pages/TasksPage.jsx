import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom'; // Import Link
import { useSelector } from 'react-redux';
import { useLocation } from 'react-router-dom';

const TasksPage = () => {
  const { classId } = useParams();
  const [tasks, setTasks] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [deadline, setDeadline] = useState('');
  const token = useSelector((state) => state.auth.token);
  const [taskAdded, setTaskAdded] = useState(false);
  const [showAddTaskButton, setShowAddTaskButton] = useState(false);
  const location = useLocation();

  useEffect(() => {
    if (location.state && location.state.fromCreatedClassroom) {
      setShowAddTaskButton(true);
    } else {
      setShowAddTaskButton(false);
    }
  }, [location]);

  useEffect(() => {
    const fetchTasks = async () => {
      try {
        const response = await fetch(`http://localhost:5555/tasks/${classId}`, { method: 'GET' });
        if (!response.ok) {
          throw new Error('Failed to fetch tasks');
        }
        const data = await response.json();
        setTasks(data);
        console.log(tasks);
      } catch (error) {
        console.error('Error fetching tasks:', error);
      }
    };
    fetchTasks();
  }, [classId]);

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch(`http://localhost:5555/tasks/${classId}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + token
        },
        body: JSON.stringify({
          title,
          description,
          deadline
        })
      });

      if (!response.ok) {
        throw new Error('Failed to add task');
      }

      // Refresh the tasks list after adding the new task
      const newTask = await response.json();
      setTasks([...tasks, newTask]);
      // Clear the form fields
      setTitle('');
      setDescription('');
      setDeadline('');

      // Hide the form
      setShowForm(false);
      setTaskAdded(!taskAdded);
    } catch (error) {
      console.error('Error adding task:', error);
    }
  };

  const handleSubmitTask = async (taskId) => {
    try {
      const response = await fetch(`http://localhost:5555/submit?classId=${classId}&taskId=${taskId}`, { method: 'POST'
      ,headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
        }},
      );
      if(!response.ok){
          console.log("failed to submit task");
          }
      else{
        console.log(response)
        setTasks(tasks.filter((task) => task.taskId !== taskId));
      }
    } catch (error) {
      console.error('Error submitting task:', error);
    }
  };

  return (
    <div>

      {/* Link to navigate to '/submitted/${classId}' */}
      <Link to={`/submitted/${classId}`} style={{ float: 'right' }}>View Submitted Tasks</Link>

      {/* Button to toggle the visibility of the form */}
      {showAddTaskButton && (
        <button onClick={() => setShowForm(!showForm)}>
          {showForm ? 'Hide Form' : 'Add New Task'}
        </button>
      )}

      {/* Form to add a new task */}
      {showForm && (
        <form onSubmit={handleFormSubmit}>
          <label>
            Title:
            <input
              type="text"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              required
            />
          </label>
          <br />
          <label>
            Description:
            <input
              type="text"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              required
            />
          </label>
          <br />
          <label>
            Deadline:
            <input
              type="date"
              value={deadline}
              onChange={(e) => setDeadline(e.target.value)}
              required
            />
          </label>
          <br />
          <button type="submit">Add Task</button>
        </form>
      )}

      {/* Display the list of tasks */}
      <ul>
        {tasks.map(task => (
          <li key={task.taskId}>
            <h4>{task.title}</h4>
            <h5>{task.description}</h5>
            <p>{task.deadline}</p>
            {/* Submit button for each task */}
            <button onClick={() => handleSubmitTask(task.taskId)}>Submit Task</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TasksPage;
