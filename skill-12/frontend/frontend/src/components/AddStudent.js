import React, { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ selectedStudent, refresh }) {
  const [student, setStudent] = useState({
    name: "", email: "", course: ""
  });

  useEffect(() => {
    if (selectedStudent) setStudent(selectedStudent);
  }, [selectedStudent]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (student.id) {
      axios.put(`http://localhost:8080/students/${student.id}`, student)
        .then(refresh);
    } else {
      axios.post("http://localhost:8080/students", student)
        .then(refresh);
    }

    setStudent({ name: "", email: "", course: "" });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" value={student.name} onChange={handleChange} placeholder="Name" />
      <input name="email" value={student.email} onChange={handleChange} placeholder="Email" />
      <input name="course" value={student.course} onChange={handleChange} placeholder="Course" />
      <button type="submit">{student.id ? "Update" : "Add"} Student</button>
    </form>
  );
}

export default AddStudent;