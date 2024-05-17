import React from 'react';
import './registration.scss';

const Registration = () => {
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
            <th>STT</th>
            <th>Mã MH cũ</th>
            <th>Mã HP</th>
            <th>Tên môn học</th>
            <th>TC</th>
            <th>Bắt buộc</th>
            <th>Học phần</th>
            <th>Học phần tương đương</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>2113434</td>
            <td>4203003193</td>
            <td>Toán ứng dụng</td>
            <td>3</td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>1</td>
            <td>2113434</td>
            <td>4203003193</td>
            <td>Lập trình di động</td>
            <td>3</td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
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
            <tr>
              <td>1</td>
              <td>HP001</td>
              <td>Lập trình căn bản</td>
              <td>3</td>
              <td>80</td>
              <td>Học trước (a)</td>
              <td>-</td>
            </tr>

            <tr>
              <td>2</td>
              <td>HP002</td>
              <td>Lập trình nâng cao</td>
              <td>3</td>
              <td>80</td>
              <td>Tiên quyết (b)</td>
              <td>-</td>
            </tr>
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
            <tr>
              <td>1</td>
              <td>Lịch học mẫu</td>
              <td>Nhóm A</td>
              <td>Phòng 101</td>
              <td>Dãy nhà A</td>
              <td>Cơ sở 1</td>
              <td>Nguyễn Văn A</td>
              <td>Thứ 2, Tiết 1-3</td>
            </tr>

            <tr>
              <td>2</td>
              <td>Lịch học mẫu 2</td>
              <td>Nhóm B</td>
              <td>Phòng 102</td>
              <td>Dãy nhà B</td>
              <td>Cơ sở 2</td>
              <td>Trần Thị B</td>
              <td>Thứ 3, Tiết 4-6</td>
            </tr>
          </tbody>
        </table>
      </div>

      <button className="btn-register-course">Đăng ký môn học</button>

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
            <tr>
              <td>
                <div className="dropdown">
                  <button className="dropbtn">⋮</button>
                  <div className="dropdown-content">
                    <button>Hủy đăng ký</button>
                    <button>Xem</button>
                  </div>
                </div>
              </td>
              <td>1</td>
              <td>LHP001</td>
              <td>Lập trình căn bản</td>
              <td>Nhóm 1</td>
              <td>3</td>
              <td>1</td>
              <td>1,500,000 VND</td>
              <td>31/05/2024</td>
              <td>✓</td>
              <td>Đã đăng ký</td>
            </tr>
            <tr>
              <td>
                <div className="dropdown">
                  <button className="dropbtn">⋮</button>
                  <div className="dropdown-content">
                    <button>Hủy đăng ký</button>
                    <button>Xem</button>
                  </div>
                </div>
              </td>
              <td>2</td>
              <td>LHP002</td>
              <td>Cấu trúc dữ liệu</td>
              <td>Nhóm 2</td>
              <td>3</td>
              <td>2</td>
              <td>1,500,000 VND</td>
              <td>31/05/2024</td>
              <td>✗</td>
              <td>Chưa đóng</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Registration;