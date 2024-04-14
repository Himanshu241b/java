import './App.css';
import './components/RegisterForm';
import LoginForm from './components/LoginForm';
import RegisterForm from './components/RegisterForm';
import HomePage from './pages/HomePage';
import {BrowserRouter, Navigate, Routes, Route} from 'react-router-dom';
import { useSelector } from 'react-redux/es/hooks/useSelector.js';
import JoinedClasses from './pages/JoinedClasses';
import CreatedClasses from './pages/CreatedClasses';
import TasksPage from './pages/TasksPage';
import SubmittedTasks from './pages/SubmittedTasks';


function App() {
  const isAuth = Boolean(useSelector((state)=> state.auth.token));
   return (
    <>
    <BrowserRouter>
    <Routes>
    <Route path="/home" element={isAuth ? <HomePage/> : <LoginForm/>}></Route>
    <Route path="/" element={<LoginForm/>}></Route>
    <Route path='/register' element = {<RegisterForm/>}></Route>
    <Route path="/joinedClasses" element={<JoinedClasses/>}></Route>
    <Route path="/createdClasses" element={<CreatedClasses/>}></Route>
    <Route path="/tasksPage/:classId" element={<TasksPage/>}></Route>
    <Route path="/submitted/:classId" element={<SubmittedTasks/>}></Route>
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
