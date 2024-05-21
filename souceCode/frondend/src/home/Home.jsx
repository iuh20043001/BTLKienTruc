import { useEffect, useState } from 'react';
import '../home/home.scss';
import { useLocation, useNavigate } from 'react-router-dom';

const Home = () => {
  let location = useLocation();
  let navigate = useNavigate();

  return (
    <div className="container-home">
      <div className="header">
        CỔNG ĐĂNG KÝ HỌC PHẦN
      </div>

      <div className="links">
        <a href="/student-info" className="link-box">Thông tin sinh viên</a>
        <a href="/course-registration" className="link-box">Đăng kí học phần</a>
        <a href="/curriculum" className="link-box">Chương trình khung</a>
        <a href="/academic-results" className="link-box">Kết quả học tập</a>
        <a href="/weekly-schedule" className="link-box">Lịch học theo tuần</a>
     
      </div>
    </div>
  );
};

export default Home;
