import React from 'react';
import './modal.scss';

const Modal = ({ course, onClose }) => {
  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <button className="close-button" onClick={onClose}>
          ×
        </button>
        <h2>Chi tiết môn học</h2>
        <table className="course-details-table">
          <tbody>
            <tr>
              <td><strong>Mã MH:</strong></td>
              <td>{course.courseCode}</td>
            </tr>
            <tr>
              <td><strong>Tên môn học:</strong></td>
              <td>{course.courseName}</td>
            </tr>
            <tr>
              <td><strong>Số tín chỉ:</strong></td>
              <td>{course.credits}</td>
            </tr>
            <tr>
              <td><strong>Giảng viên:</strong></td>
              <td>{course.instructor}</td>
            </tr>
            <tr>
              <td><strong>Lịch học:</strong></td>
              <td>{course.schedule}</td>
            </tr>
            <tr>
              <td><strong>Phòng học:</strong></td>
              <td>{course.room}</td>
            </tr>
            <tr>
              <td><strong>Dãy nhà:</strong></td>
              <td>{course.building}</td>
            </tr>
            <tr>
              <td><strong>Cơ sở:</strong></td>
              <td>{course.campus}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Modal;
