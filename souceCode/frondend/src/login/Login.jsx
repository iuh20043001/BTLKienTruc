import { useState } from 'react';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import './login.scss';

const Login = () => {
  const [studentId, setStudentId] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleClickLogin = async () => {
    try {
      const datas = await axios.post(
        'http://localhost:8080/api/accounts/login',
        {
          studentId: studentId,
          password: password,
        }
      );

      if (datas.data.role === 'user') {
        const dataGetCust = await axios.get(
          `http://localhost:8080/api/customers/CustomerByEmail/${studentId}`
        );
        navigate('/home', {
          state: {
            customer: {
              ...dataGetCust.data,
              password: password,
              accountId: datas.data.accountId,
            },
          },
        });
      } else if (datas.data.role === 'admin') {
        navigate('/dashboard');
      } else {
        toast.error('🦄 Mã Sinh Viên Hoặc Password Không Đúng!', {
          position: 'top-right',
          autoClose: 5000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          theme: 'light',
        });
      }
    } catch (error) {
      toast.error('🚨 Something went wrong. Please try again later.', {
        position: 'top-right',
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: 'light',
      });
    }
  };

  return (
    <div className="container-login">
      <h2 className="text-login">ĐĂNG NHẬP</h2>
      <div className="form-group">
        <label htmlFor="student-id">Mã Sinh Viên:</label>
        <input
          type="text"
          id="student-id"
          className="form-control"
          placeholder="Nhập mã sinh viên của bạn"
          value={studentId}
          onChange={(e) => setStudentId(e.target.value)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="password">Mật khẩu:</label>
        <input
          type="password"
          id="password"
          className="form-control"
          placeholder="Nhập mật khẩu của bạn"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <div className="ac">
        <button
          style={{ marginTop: '10px', marginLeft: '30px' }}
          className="btn btn-primary"
          onClick={() => navigate('/home')}>
          Đăng nhập
        </button>
      </div>
    </div>
  );
};

export default Login;
