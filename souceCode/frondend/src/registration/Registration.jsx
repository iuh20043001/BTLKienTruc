import React, { useEffect, useState } from 'react';
import Modal from './Modal';
import './registration.scss';

const Registration = () => {
  const [courses, setCourses] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [selectedCourse, setSelectedCourse] = useState(null);
  const [selectedRow, setSelectedRow] = useState(null);
  const [classRegistrations, setClassRegistrations] = useState([]);
  const [classDetails, setClassDetails] = useState([]);
  const [selectedClassRow, setSelectedClassRow] = useState(null);
  const [selectedClassRegistrationRow, setSelectedClassRegistrationRow] =
    useState(null);
  const [registeredCourses, setRegisteredCourses] = useState([]);
  const [selectedPracticeGroup, setSelectedPracticeGroup] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/courses')
      .then((response) => response.json())
      .then((data) => {
        console.log('Courses fetched:', data);
        setCourses(data);
      })
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  // const handleCourseSelect = (course) => {
  //   console.log('Selected course:', course);
  //   setSelectedCourse(course);
  //   setClassDetails([]);
  //   setClassRegistrations([]);
  //   fetch(
  //     `http://localhost:8080/courses/${course.courseId}/class-registrations`
  //   )
  //     .then((response) => response.json())
  //     .then((data) => {
  //       console.log('Class registrations fetched:', data);
  //       setClassRegistrations(data);
  //     })
  //     .catch((error) =>
  //       console.error('Error fetching class registrations:', error)
  //     );
  // };

  const handleCourseSelect = (course) => {
    console.log('Selected course:', course);
    setSelectedCourse(course);
    setClassDetails([]); // Reset class details when a new course is selected
    setClassRegistrations([]); // Reset class registrations when a new course is selected

    fetch(
      `http://localhost:8080/courses/${course.courseId}/class-registrations`
    )
      .then((response) => response.json())
      .then((data) => {
        console.log('Class registrations fetched:', data);
        setClassRegistrations(data);

        // Extract all class details
        let allDetails = [];
        data.forEach((registration) => {
          // Check if classRegistration and classDetails exist before accessing them
          if (
            registration.classRegistration &&
            registration.classRegistration.classDetails
          ) {
            allDetails = allDetails.concat(
              registration.classRegistration.classDetails
            );
          }
        });
        setClassDetails(allDetails);
      })
      .catch((error) =>
        console.error('Error fetching class registrations:', error)
      );
  };

  const handleClassRegistrationRowClick = (index, classId) => {
    setSelectedClassRegistrationRow(index);
    fetch(`http://localhost:8080/class-registrations/${classId}/class-details`)
      .then((response) => response.json())
      .then((data) => {
        setClassDetails(data);
      })
      .catch((error) => console.error('Error fetching class details:', error));
  };

  useEffect(() => {
    fetch('http://localhost:8080/registered-courses')
      .then((response) => response.json())
      .then((data) => {
        setRegisteredCourses(data);
      })
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  const handleRowClick = (index) => {
    setSelectedRow(index);
  };

  const handleViewCourse = (course) => {
    console.log('Viewing course:', course);
    setSelectedCourse({
      ...course,
      instructor: course.instructor || 'Unknown', // Giảng viên
      schedule: course.schedule || 'Unknown', // Lịch học
      room: course.room || 'Unknown', // Phòng học
      building: course.building || 'Unknown', // Dãy nhà
      campus: course.campus || 'Unknown', // Cơ sở
    });
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
  };

  const handleClassRowClick = (index) => {
    const selectedGroup = classDetails[index].practiceGroup;
    setSelectedPracticeGroup(selectedGroup);
    setSelectedClassRow(index);
  };

  const handlePracticeGroupSelect = (event) => {
    const selectedGroup = event.target.value;
    setSelectedPracticeGroup(selectedGroup);
  };

  const handleRegisterCourse = () => {
    if (
      !selectedCourse ||
      selectedClassRow === null ||
      !selectedPracticeGroup
    ) {
      console.error(
        'Vui lòng chọn môn học, lớp học và nhóm thực hành trước khi đăng ký.'
      );
      return;
    }

    if (classDetails.length > 0 && selectedClassRow < classDetails.length) {
      const selectedClass = classDetails[selectedClassRow];

      const studentId = selectedCourse.studentId;

      const plannedClasses = classRegistrations.map(
        (registration) => registration.classRegistration?.plannedClass || ''
      );

      const data = {
        studentId: studentId,
        classId: selectedClass.classId,
        courseId: selectedCourse.courseId,
        courseName: selectedCourse.courseName,
        // plannedClass: plannedClasses,
        credits: selectedCourse.credits,
        practiceGroup: selectedPracticeGroup,
        registrationStatus: 'Dang ky moi',
        tuitionFee: '',
        deadline: '',
        feeStatus: 'Chua',
        instructor: selectedClass.instructor,
        schedule: selectedClass.schedule,
        room: selectedClass.room,
        building: selectedClass.building,
        campus: selectedClass.campus,
      };

      console.log('Payload to be sent:', JSON.stringify(data));

      fetch('http://localhost:8080/registered-courses', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error(
              `Network response was not ok: ${response.statusText}`
            );
          }
          return response.json();
        })
        .then((responseData) => {
          console.log('Dữ liệu đã được lưu:', responseData);
          setRegisteredCourses([...registeredCourses, responseData]);
        })
        .catch((error) => {
          console.error('Lỗi khi gửi yêu cầu đăng ký:', error);
        });
    } else {
      console.log('Không có thông tin chi tiết lớp học được chọn');
    }
  };

  const handleCancelRegistration = (registrationId) => {
    fetch(`http://localhost:8080/registered-courses/${registrationId}`, {
      method: 'DELETE',
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            `Network response was not ok: ${response.statusText}`
          );
        }
        return response.text(); // Trả về văn bản để kiểm tra phản hồi, không cần JSON
      })
      .then((responseText) => {
        console.log('Đã hủy đăng ký:', responseText);
        // Sau khi xóa thành công, cập nhật danh sách lớp học phần đã đăng ký bằng cách loại bỏ phần tử đã xóa
        setRegisteredCourses(
          registeredCourses.filter(
            (course) => course.registrationId !== registrationId
          )
        );
        // Làm mới trang sau 500ms
        setTimeout(() => {
          console.log('Reloading page...');
          window.location.reload(true); // Buộc làm mới trang từ server
          // history.go(0); // Bạn có thể thử cái này nếu window.location.reload không hoạt động
        }, 500);
      })
      .catch((error) => {
        console.error('Lỗi khi gửi yêu cầu hủy đăng ký:', error); // In ra lỗi cụ thể
      });
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
          <option value="HK2">HK2</option>
          <option value="HK3">HK3</option>
          <option value="HK4">HK4</option>
          <option value="HK5">HK5</option>
          <option value="HK6">HK6</option>
          <option value="HK7">HK7</option>
          <option value="HK8">HK8</option>
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
              onClick={() => {
                handleRowClick(index);
                handleCourseSelect(course);
              }}>
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

      <h4 style={{ marginTop: '17px', fontSize: '25px' }}>
        LỚP HỌC PHẦN CHỜ ĐĂNG KÝ
      </h4>

      <div className="class-registration-container">
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
                  backgroundColor:
                    selectedClassRegistrationRow === index
                      ? '#f2f2f2'
                      : 'white',
                }}
                onClick={() =>
                  handleClassRegistrationRowClick(index, registration.classId)
                }>
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

      <h4 style={{ fontSize: '27px', marginTop: '20px' }}>
        Chi Tiết Lớp Học Phần
      </h4>
      <label htmlFor="group">Nhóm thực hành:</label>
      <select
        className="select-input"
        id="group"
        name="group"
        value={selectedPracticeGroup || ''}
        onChange={handlePracticeGroupSelect}>
        <option value="">Chọn nhóm thực hành</option>
        {classDetails.map((classDetail, index) => (
          <option key={index} value={classDetail.practiceGroup}>
            {classDetail.practiceGroup}
          </option>
        ))}
      </select>

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
          {classDetails.map((classDetail, index) => (
            <tr
              key={index}
              style={{
                backgroundColor:
                  selectedPracticeGroup === classDetail.practiceGroup
                    ? '#f2f2f2'
                    : 'white',
              }}
              onClick={() => handleClassRowClick(index)}>
              <td>{index + 1}</td>
              <td>{classDetail.schedule}</td>
              <td>{classDetail.practiceGroup}</td>
              <td>{classDetail.room}</td>
              <td>{classDetail.building}</td>
              <td>{classDetail.campus}</td>
              <td>{classDetail.instructor}</td>
              <td>{classDetail.time}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <button className="btn-register-course" onClick={handleRegisterCourse}>
        Đăng ký môn học
      </button>

      <h4>LỚP HỌC PHẦN ĐÃ ĐĂNG KÝ</h4>
      <div className="registered-courses">
        <table className="registered-courses-table">
          <thead>
            <tr>
              <th>Thao tác</th>
              <th>STT</th>
              <th>Mã LHP</th>
              <th>Tên môn học</th>
              <th>Lịch học</th>
              <th>Số TC</th>
              <th>Nhóm TH</th>
              <th>Học phí</th>
              <th>Giảng viên</th>
              <th>Thu</th>
              <th>Trạng thái DK</th>
            </tr>
          </thead>
          <tbody>
            {registeredCourses.map((course, index) => (
              <tr key={index}>
                <td>
                  <div className="dropdown">
                    <button
                      className="dropbtn"
                      onClick={() => handleViewCourse(course, index)}>
                      ⋮
                    </button>
                    <div className="dropdown-content">
                      <button
                        onClick={() =>
                          handleCancelRegistration(course.registrationId)
                        }>
                        Hủy đăng ký
                      </button>

                      <button onClick={() => handleViewCourse(course, index)}>
                        Xem
                      </button>
                    </div>
                  </div>
                </td>
                <td>{index + 1}</td>
                <td>{course.registrationId}</td>
                <td>{course.courseName}</td>
                <td>{course.schedule}</td>
                <td>{course.credits}</td>
                <td>{course.practiceGroup}</td>
                <td>{course.tuitionFee}</td>
                <td>{course.instructor}</td>
                <td>{course.feeStatus}</td>
                <td>{course.registrationStatus}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      {showModal && selectedCourse && (
        <Modal
          course={selectedCourse}
          classDetail={classDetails[selectedClassRow]} // Chỉ truyền chi tiết của lớp học đã chọn
          onClose={handleCloseModal}
        />
      )}
    </div>
  );
};

export default Registration;
