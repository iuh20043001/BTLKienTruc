import React from 'react';
import './academicResults.scss';

const AcademicResults = () => {
  return (
    <div className="academic-results-container">
      <h2>KẾT QUẢ HỌC TẬP</h2>
      <table className="academic-results-table">
        <thead>
          <tr>
            <th rowSpan="2">STT</th>
            <th rowSpan="2">Mã lớp học phần</th>
            <th rowSpan="2">Tên môn học/học phần</th>
            <th rowSpan="2">Số tín chỉ</th>
            <th colSpan="2">Giữa kỳ</th>
            <th colSpan="9">Thường xuyên</th>
            <th colSpan="5">Thực hành</th>
            <th rowSpan="2">Cuối kỳ</th>
            <th rowSpan="2">Điểm tổng kết</th>
            <th rowSpan="2">Thang điểm 4</th>
            <th rowSpan="2">Điểm chữ</th>
            <th rowSpan="2">Xếp loại</th>
            <th rowSpan="2">Ghi chú</th>
            <th rowSpan="2">TBQT</th>
            <th rowSpan="2">Đạt</th>
          </tr>
          <tr >
            <th style={{fontWeight:"bold"}}>1</th>
            <th style={{fontWeight:"bold"}}>Chuyên cần</th>
            {Array.from({ length: 9 }).map((_, i) => (
              <th style={{fontWeight:"bold"}} key={i}>{i + 1}</th>
            ))}
            {Array.from({ length: 5 }).map((_, i) => (
              <th style={{fontWeight:"bold"}} key={i}>{i + 1}</th>
            ))}
          </tr>
          <tr>
            <th colSpan="28" style={{paddingRight:"1960px", color:"black"}}>HỌC KÌ 1</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>ABC123</td>
            <td>Toán cao cấp</td>
            <td>3</td>
            <td>8</td>
            <td>7</td>
            {Array.from({ length: 9 }).map((_, i) => (
              <td key={i}></td>
            ))}
            {Array.from({ length: 5 }).map((_, i) => (
              <td key={i}></td>
            ))}
            <td>8</td>
            <td>8</td>
            <td>3.2</td>
            <td>B+</td>
            <td>Khá</td>
            <td></td>
            <td>8.0</td>
            <td>Đạt</td>
          </tr>
          {/* Thêm các hàng dữ liệu khác ở đây */}
        </tbody>
      </table>
    </div>
  );
};

export default AcademicResults;
