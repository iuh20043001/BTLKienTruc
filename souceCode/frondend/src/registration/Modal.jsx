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
              <td><strong>Hạn nộp:</strong></td>
              <td>Chờ thông báo</td>
            </tr>
            <tr>
              <td><strong>Tình trạng:</strong></td>
              <td>Chờ sinh viên đăng ký</td>
            </tr>
            <tr>
              <td><strong>Nhóm TH:</strong></td>
              <td>{course.practiceGroup}</td>
            </tr>
            <tr>
              <td><strong>Tình trạng:</strong></td>
              <td>{course.registrationStatus}</td>
            </tr>
            <tr>
              <td><strong>Học phí:</strong></td>
              <td>Chờ thông báo</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Modal;