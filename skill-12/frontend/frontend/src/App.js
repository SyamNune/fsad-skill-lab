import React, { useState } from "react";
import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";

function App() {
  const [selectedStudent, setSelectedStudent] = useState(null);

  const refresh = () => {
    window.location.reload(); // simple refresh
  };

  return (
    <div>
      <h1>Student Management System</h1>
      <AddStudent selectedStudent={selectedStudent} refresh={refresh} />
      <StudentList onEdit={setSelectedStudent} />
    </div>
  );
}

export default App;