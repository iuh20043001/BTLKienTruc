import React, { useState } from 'react';
import Modal from './Modal';

const SomeComponent = ({ course, classDetails }) => {
  const [selectedClassDetail, setSelectedClassDetail] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = (detail) => {
    setSelectedClassDetail(detail);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setSelectedClassDetail(null);
    setIsModalOpen(false);
  };

  return (
    <div>
      <h1>{course.courseName}</h1>
      <table>
        <thead>
          <tr>
            <th>Nhóm thực hành</th>
            <th>Lịch học</th>
            <th>Giảng viên</th>
            <th>Phòng học</th>
            <th>Dãy nhà</th>
            <th>Cơ sở</th>
            <th>Thời gian</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {classDetails.map(detail => (
            <tr key={detail.detailId}>
              <td>{detail.practiceGroup}</td>
              <td>{detail.schedule}</td>
              <td>{detail.instructor}</td>
              <td>{detail.room}</td>
              <td>{detail.building}</td>
              <td>{detail.campus}</td>
              <td>{detail.time}</td>
              <td>
                <button onClick={() => handleOpenModal(detail)}>View Details</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {isModalOpen && (
        <Modal 
          course={course} 
          classDetail={selectedClassDetail} 
          onClose={handleCloseModal} 
        />
      )}
    </div>
  );
};

export default SomeComponent;
