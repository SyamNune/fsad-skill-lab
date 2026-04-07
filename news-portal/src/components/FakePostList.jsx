import { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [userId, setUserId] = useState("");

  const fetchPosts = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => {
        setPosts(res.data.posts);
        setFiltered(res.data.posts);
      });
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  const handleFilter = (e) => {
    const value = e.target.value;
    setUserId(value);

    if (value === "") {
      setFiltered(posts);
    } else {
      setFiltered(posts.filter(p => p.userId == value));
    }
  };

  return (
    <div>
      <h2>Fake API Posts</h2>

      <button onClick={fetchPosts}>Refresh</button>

      <br /><br />

      <select onChange={handleFilter} value={userId}>
        <option value="">All Users</option>
        {[...new Set(posts.map(p => p.userId))].map(id => (
          <option key={id} value={id}>{id}</option>
        ))}
      </select>

      {filtered.map(post => (
        <div key={post.id} className="card">
          <h4>{post.title}</h4>
          <p>{post.body}</p>
        </div>
      ))}
    </div>
  );
}

export default FakePostList;