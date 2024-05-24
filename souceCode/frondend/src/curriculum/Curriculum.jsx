import React, { useState, useEffect } from 'react';
import './curriculum.scss';

const Curriculum = () => {
  const [curriculumCourses, setCurriculumCourses] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/curriculum-courses');
        if (!response.ok) {
          throw new Error('Failed to fetch curriculum courses');
        }
        const data = await response.json();
        setCurriculumCourses(data); // Cập nhật state curriculumCourses với dữ liệu nhận được từ API
      } catch (error) {
        console.error('Error fetching curriculum courses:', error);
        setError(error.message);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="curriculum-container">
      <h2>CHƯƠNG TRÌNH KHUNG</h2>
      {error && <p>{error}</p>}
      <table className="curriculum-table">
        <thead>
          <tr style={{ fontSize: 15 }}>
            <th>Mã môn học</th>
            <th>STT</th>
            <th>Tên môn học</th>
            <th>Học kỳ 1</th>
            <th>Mã học phần</th>
            <th>Học phần: học phần trước (a), tiên quyết (b), song hành (c)</th>
            <th>Số TC/ DVHT</th>
            <th>Số tiết LT</th>
            <th>Số tiết TH</th>
            <th>Đạt</th>
            <th>Đề cương môn học</th>
          </tr>
          <tr>
            <th colSpan="5">HỌC KÌ 1</th>
            <th colSpan="6">TỔNG SỐ TC: 11</th>
          </tr>
        </thead>
        <tbody>
          {curriculumCourses.map((course) => (
            <tr key={course.id}>
              <td>{course.courseCode}</td>
              <td>{course.stt}</td>
              <td>{course.courseName}</td>
              <td>{course.courseId}</td>
              <td>{course.companion}</td>
              <td>{course.prerequisites}</td>
              <td>{course.credits}</td>
              <td>{course.lectureHours}</td>
              <td>{course.labHours}</td>
              <td>{course.passStatus}</td>
              <td>
                <input type="checkbox" />
              </td>
              <td>
                <a href="#">Xem</a>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Curriculum;
