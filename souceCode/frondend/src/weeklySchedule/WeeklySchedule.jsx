import React from 'react';
import './weeklySchedule.scss';

const WeeklySchedule = () => {
  const days = [
    { name: 'Thứ 2', date: '27/05/2024' },
    { name: 'Thứ 3', date: '28/05/2024' },
    { name: 'Thứ 4', date: '29/05/2024' },
    { name: 'Thứ 5', date: '30/05/2024' },
    { name: 'Thứ 6', date: '31/05/2024' },
    { name: 'Thứ 7', date: '01/06/2024' },
    { name: 'Chủ nhật', date: '02/06/2024' },
  ];

  const times = ['Sáng', 'Chiều', 'Tối'];

  return (
    <div className="container-weekly-schedule">
      <h2>Lịch theo tuần</h2>
      <div className="filters">
        <label><input type="radio" name="type" defaultChecked /> Tất cả</label>
        <label><input type="radio" name="type" /> Lịch học</label>
        <label><input type="radio" name="type" /> Lịch thi</label>
        <input type="date" defaultValue="2024-05-27" />
        <button>Hiện tại</button>
        <button>Trở về</button>
        <button>Tiếp</button>
      </div>
      <div className="schedule-grid">
        <div className="header-row">
          <div className="time-slot">Ca học</div>
          {days.map((day) => (
            <div key={day.date} className="day-column">
              <div className="day-header">
                <span>{day.name}</span>
                <span>{day.date}</span>
              </div>
            </div>
          ))}
        </div>
        {times.map((time) => (
          <div key={time} className="time-row">
            <div className="time-slot">{time}</div>
            {days.map((day) => (
              <div key={day.date} className="day-column">
                <div className="time-cell"></div>
              </div>
            ))}
          </div>
        ))}
      </div>
      <div className="legend">
        <div><span className="legend-color legend-class"></span> Lịch học</div>
        <div><span className="legend-color legend-online"></span> Lịch học trực tuyến</div>
        <div><span className="legend-color legend-exam"></span> Lịch thi</div>
        <div><span className="legend-color legend-suspend"></span> Lịch tạm ngưng</div>
      </div>
    </div>
  );
};

export default WeeklySchedule;
