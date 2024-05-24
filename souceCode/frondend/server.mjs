import express from 'express';
import cors from 'cors';
import mysql from 'mysql2/promise';

const app = express();

app.use(cors({
  origin: 'http://localhost:5173'
}));

app.use(express.json());

const pool = mysql.createPool({
  host: 'localhost',
  user: 'root',
  // password: 'your_password',
  database: 'week05',
  waitForConnections: true,
  connectionLimit: 10,
  queueLimit: 0
});

async function getClassDetails(classId) {
  try {
    const connection = await pool.getConnection();
    const [rows] = await connection.execute('SELECT * FROM class_details WHERE classId = ?', [classId]);
    connection.release();
    return rows;
  } catch (error) {
    throw new Error('Database error: ' + error.message);
  }
}

app.get('/class-registrations/:id/class-details', async (req, res) => {
  const classId = req.params.id;
  try {
    const details = await getClassDetails(classId);
    if (details.length > 0) {
      res.status(200).json(details);
    } else {
      res.status(404).send('Class not found');
    }
  } catch (error) {
    console.error('Error retrieving class details:', error);
    res.status(500).send('Internal Server Error');
  }
});

app.post('/registered-courses', (req, res) => {
  const { studentId, classId, courseId, courseName, plannedClass, credits, practiceGroup, registrationStatus } = req.body;
  if (!studentId || !classId || !courseId || !courseName || !plannedClass || !credits || !practiceGroup || !registrationStatus) {
    return res.status(400).json({ error: 'Missing required fields' });
  }
  saveToDatabase(req.body)
    .then(result => {
      res.status(201).json(result);
    })
    .catch(error => {
      console.error('Error saving to database:', error);
      res.status(500).json({ error: 'Internal Server Error' });
    });
});

function saveToDatabase(data) {
  return new Promise((resolve, reject) => {
    resolve(data);
  });
}

const PORT = 8080;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
