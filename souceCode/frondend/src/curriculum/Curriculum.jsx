import React from 'react';
import './curriculum.scss';

const Curriculum = () => {
  return (
    <div className="curriculum-container">
      <h2>CHƯƠNG TRÌNH KHUNG</h2>
      <table className="curriculum-table">
        <thead>
          <tr style={{fontSize: 15}}>
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
          <tr>
            <td>MH001</td>
            <td>1</td>
            <td>Lập trình căn bản</td>
            <td>1</td>
            <td>HP001</td>
            <td>3</td>
            <td>30</td>
            <td>30</td>
            <td></td>
            <td><input type="checkbox" /></td>
            <td><a href="#">Xem</a></td>
          </tr>
          {/* Thêm các hàng khác tương tự */}
          
        </tbody>
      </table>
    </div>
  );
};

export default Curriculum;
