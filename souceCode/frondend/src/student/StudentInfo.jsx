import { useEffect, useState } from "react";
import axios from "axios";
import "./studentInfo.scss";

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
            <h2>THÔNG TIN SINH VIÊN</h2>
            <div>
            <div className="details">
                        <p><b>Khóa:</b> 2020-2021</p>
                        <p><b>Bậc đào tạo: </b>Đại học</p>
                        <p><b>Ngành: </b>Kỹ thuật phần mềm</p>
                        <p><b>Khoa:</b> Công nghệ thông tin</p>
                        <p><b>Lớp:</b> Đại học Kỹ thuật phần mềm 16B - 7480103</p>
                        <p><b>Loại hình đào tạo:</b> Chính quy</p>
                        <p><b>Chuyên ngành</b> Kỹ thuật phần mềm - 7480103</p>
                        <p><b>Cơ sở:</b> Cơ sở 1 Thành phố Hồ Chí Minh</p>
                    </div>
            </div>
            
        </div>
    );
};

export default StudentInfo;
