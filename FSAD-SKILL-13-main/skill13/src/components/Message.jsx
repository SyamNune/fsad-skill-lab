import { useEffect, useState } from "react";
import { getMessage } from "../services/api";

function Message() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    getMessage().then(data => setMessage(data));
  }, []);

  return (
    <div>
      <h2>{message}</h2>
    </div>
  );
}

export default Message;