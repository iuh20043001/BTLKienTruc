import { useEffect, useState } from 'react';
import '../home/home.scss';
import axios from 'axios';
import { useLocation, useNavigate } from 'react-router-dom';

const Home = () => {
  let location = useLocation();
  let navigate = useNavigate();

  

  return (
    <div className="container-home">
      <text
        style={{
          paddingLeft: '400px',
          color: 'green',
          fontSize: '30px',
          backgroundColor: '#f7afaf',
          height: '70px',
          fontWeight: 'bold',
          paddingTop: '20px',
          width: '1200px',
        }}>
        CỔNG ĐĂNG KÝ HỌC PHẦN
      </text>

      <div className="links">
        <a href="/student-info">Thông tin sinh viên</a>
        <a href="/course-registration">Đăng kí học phần</a>
        <a href="/curriculum">Chương trình khung</a>
        <a href="/academic-results">Kết quả học tập</a>
        <a href="/weekly-schedule">Lịch học theo tuần</a>
      </div>
    </div>
  );
};

export default Home;
