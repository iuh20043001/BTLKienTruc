import './App.css';
import Home from './home/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './login/Login';
import Student from './student/StudentInfo';
import Curriculum from './curriculum/Curriculum';
import Registration from './registration/Registration';
import AcademicResults from './academicResults/AcademicResults'
import WeeklySchedule from './weeklySchedule/WeeklySchedule'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/course-registration" element={<Registration />} />
       
        <Route path="/home" element={<Home />} />
        <Route path="/student-info" element={<Student />} />
        <Route path="/curriculum" element={<Curriculum />} />
        <Route path="/academic-results" element={<AcademicResults />} />
        <Route path="/weekly-schedule" element={<WeeklySchedule />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
