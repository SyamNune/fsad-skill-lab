import React, { useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    if (!localStorage.getItem("userId")) {
      navigate("/login");
    }
  }, []);

  return (
    <div>
      <h2>Home</h2>
      <Link to="/profile">Profile</Link>
      <button onClick={() => {
        localStorage.clear();
        navigate("/login");
      }}>Logout</button>
    </div>
  );
}
export default Home;