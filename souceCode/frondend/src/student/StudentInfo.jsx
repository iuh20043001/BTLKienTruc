import { useEffect, useState } from "react";
import axios from "axios";
import "./studentInfo.scss";
import hinh from "../assets/avt.jpeg";

const StudentInfo = () => {
    const [studentInfo, setStudentInfo] = useState(null);

    useEffect(() => {
        const fetchStudentInfo = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/student/info");
                setStudentInfo(response.data);
            } catch (error) {
                console.error("Error fetching student info:", error);
            }
        };
        fetchStudentInfo();
    }, []);

    return (
        <div className="container">
            <div className="header">THÔNG TIN SINH VIÊN</div>
            <div className="details">
                <div className="personal-info">
                    <img src={hinh} className="student-photo" alt="Student" />
                    <div>
                        <p><span>MSSV:</span> 20042961</p>
                        <p><span>Họ tên:</span> Đặng Thị Quyền Trân</p>
                        <p><span>Giới tính:</span> Nữ</p>
                    </div>
                </div>
                <div className="additional-info">
                    <div className="column">
                        <p><span>Trạng thái:</span> Đang học</p>
                        <p><span>Mã hồ sơ:</span> 205HB27551191</p>
                        <p><span>Ngày vào trường:</span> 21/9/2020</p>
                        <p><span>Lớp học:</span> DHKTPM16B</p>
                        <p><span>Cơ sở:</span> Cơ sở 1 (Thành phố Hồ Chí Minh)</p>
                    </div>
                    <div className="column">
                        <p><span>Bậc đào tạo:</span> Đại học</p>
                        <p><span>Loại hình đào tạo:</span> Chính quy</p>
                        <p><span>Khoa:</span> Khoa Công nghệ Thông tin</p>
                        <p><span>Ngành:</span> Kỹ thuật phần mềm</p>
                        <p><span>Chuyên ngành:</span> Kỹ thuật phần mềm - 7480103</p>
                        <p><span>Khóa học:</span> 2020 - 2021</p>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default StudentInfo;
