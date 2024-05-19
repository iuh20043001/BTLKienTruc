import React, { useEffect, useState } from 'react';
import './registration.scss';
const Registration = () => {
  const [courses, setCourses] = useState([]);
  const [selectedRow, setSelectedRow] = useState(null);
  const [classRegistrations, setClassRegistrations] = useState([]);
  const [classDetails, setClassDetails] = useState([]);
  const [registeredCourses, setRegisteredCourses] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/courses')
      .then((response) => response.json())
      .then((data) => {
        setCourses(data);
      })
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8080/class-registrations')
      .then((response) => response.json())
      .then((data) => {
        setClassRegistrations(data);
      })
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8080/class-details')
      .then((response) => response.json())
      .then((data) => {
        setClassDetails(data);
      })
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8080/registered-courses') // Thay thế URL này bằng URL thực tế của bạn
      .then(response => response.json())
      .then(data => {
        setRegisteredCourses(data);
      })
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  const handleRowClick = (index) => {
    setSelectedRow(index);
  };

  return (
    <div className="registration-container">
      <h2>ĐĂNG KÝ HỌC PHẦN</h2>
      <div
        className="registration-form"
        style={{ fontSize: 17, marginBottom: '20px' }}>
        <label htmlFor="registration-period">Đợt đăng ký:</label>
        <select id="registration-period" style={{ paddingRight: '20px' }}>
          <option value="HK1">HK1</option>
          <option value="HK1">HK2</option>
          <option value="HK1">HK3</option>
          <option value="HK1">HK4</option>
          <option value="HK1">HK5</option>
          <option value="HK1">HK6</option>
          <option value="HK1">HK7</option>
          <option value="HK1">HK8</option>
        </select>
        <input type="radio" id="new" name="registration-type" value="new" />
        <label htmlFor="new">Học mới</label>
        <input
          type="radio"
          id="repeat"
          name="registration-type"
          value="repeat"
        />
        <label htmlFor="repeat">Học lại</label>
        <input
          type="radio"
          id="improve"
          name="registration-type"
          value="improve"
        />
        <label htmlFor="improve">Học cải thiện</label>
      </div>

      <h4>MÔN HỌC PHẦN ĐANG CHỜ ĐĂNG KÝ</h4>
      <table className="registration-table">
        <thead>
          <tr>
            <th>Chọn</th>
            <th>STT</th>
            <th>Mã MH</th>
            <th>Mã HP</th>
            <th>Tên môn học</th>
            <th>TC</th>
            <th>Bắt buộc</th>
          </tr>
        </thead>
        <tbody>
          {courses.map((course, index) => (
            <tr
              key={index}
              style={{
                backgroundColor: selectedRow === index ? '#f2f2f2' : 'white',
              }}
              onClick={() => handleRowClick(index)}>
              <td>
                <input
                  type="radio"
                  name="selectedRow"
                  checked={selectedRow === index}
                  onChange={() => {}}
                />
              </td>
              <td>{index + 1}</td>
              <td>{course.courseCode}</td>
              <td>{course.courseId}</td>
              <td>{course.courseName}</td>
              <td>{course.credits}</td>
              <td>{course.prerequisiteCourses ? 'Có' : 'Không'}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="class-registration-container">
        <h4>LỚP HỌC PHẦN CHỜ ĐĂNG KÝ</h4>
        <div className="class-registration-options">
          <input
            type="checkbox"
            id="schedule-difference"
            name="schedule-difference"
          />
          <label htmlFor="schedule-difference">
            Hiển thị lớp học phần không trùng lịch
          </label>
        </div>
        <table className="class-registration-table">
          <thead>
            <tr>
              <th>STT</th>
              <th>Mã LHP</th>
              <th>Tên lớp học phần</th>
              <th>Lớp dự kiến</th>
              <th>Sĩ số tối đa</th>
              <th>Đã đăng ký</th>
              <th>Trạng thái</th>
            </tr>
          </thead>
          <tbody>
            {classRegistrations.map((registration, index) => (
              <tr
                key={index}
                style={{
                  backgroundColor: selectedRow === index ? '#f2f2f2' : 'white',
                }}
                onClick={() => handleRowClick(index)}>
                <td>{index + 1}</td>
                <td>{registration.classCode}</td>
                <td>{registration.className}</td>
                <td>{registration.plannedClass}</td>
                <td>{registration.maxCapacity}</td>
                <td>{registration.registeredStudents}</td>
                <td>{registration.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="additional-info">
        <h4>Chi Tiết Lớp Học Phần</h4>
        <div className="select-wrapper">
          <label htmlFor="group">Nhóm thức hành:</label>
          <select id="group" name="group">
            <option value="group1">Nhóm 1</option>
            <option value="group2">Nhóm 2</option>
            <option value="group3">Nhóm 3</option>
            <option value="group4">Nhóm 4</option>
          </select>
        </div>
        <button className="btn-check-schedule">Xem lịch trùng</button>

        <table className="class-details-table">
          <thead>
            <tr>
              <th>STT</th>
              <th>Lịch học</th>
              <th>Nhóm TH</th>
              <th>Phòng</th>
              <th>Dãy nhà</th>
              <th>Cơ sở</th>
              <th>Giảng viên</th>
              <th>Thời gian</th>
            </tr>
          </thead>
          <tbody>
            {classDetails.map((detail, index) => (
              <tr
                key={index}
                className={selectedRow === index ? 'selected-row' : ''}
                onClick={() => handleRowClick(index)}>
                <td>{index + 1}</td>
                <td>{detail.schedule}</td>
                <td>{detail.practiceGroup}</td>
                <td>{detail.room}</td>
                <td>{detail.building}</td>
                <td>{detail.campus}</td>
                <td>{detail.instructor}</td>
                <td>{detail.time}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <button className="btn-register-course">Đăng ký môn học</button>

      <h4>LỚP HỌC PHẦN ĐÃ ĐĂNG KÝ</h4>

      <div className="registered-courses">
        <table className="registered-courses-table">
          <thead>
            <tr>
              <th>Thao tác</th>
              <th>STT</th>
              <th>Mã LHP</th>
              <th>Tên môn học</th>
              <th>Lớp học dự kiến</th>
              <th>Số TC</th>
              <th>Nhóm TH</th>
              <th>Học phí</th>
              <th>Hạn nộp</th>
              <th>Thu</th>
              <th>Trạng thái DK</th>
            </tr>
          </thead>
          <tbody>
            {registeredCourses.map((course, index) => (
              <tr key={index}>
                <td>
                <div className="dropdown">
                  <button className="dropbtn">⋮</button>
                  <div className="dropdown-content">
                    <button>Hủy đăng ký</button>
                    <button>Xem</button>
                  </div>
                </div>
              </td>
                <td>{index + 1}</td>
                <td>{course.registrationId}</td>
                <td>{course.courseName}</td>
                <td>{course.plannedClass}</td>
                <td>{course.credits}</td>
                <td>{course.practiceGroup}</td>
                <td>{course.tuitionFee}</td>
                <td>{course.deadline}</td>
                <td>{course.feeStatus}</td>
                <td>{course.registrationStatus}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Registration;
