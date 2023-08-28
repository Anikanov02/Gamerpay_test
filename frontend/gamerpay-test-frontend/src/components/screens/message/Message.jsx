import React, { useState } from "react";
import styles from "./Message.module.css";

const Message = () => {
  const [inputValue, setInputValue] = useState("");
  const [infoMessage, setInfoMessage] = useState("");

  const handleSendClick = async () => {
    try {
      const response = await fetch("http://localhost:9090/api/v1/messages/post", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ content: inputValue }),
      });

      const jsonResponse = await response.json();
      if (jsonResponse.message && jsonResponse.message.trim() !== "") {
        setInfoMessage(jsonResponse.message);
      } else if (response.ok) {
        setInfoMessage("Message sent successfully");
      } else {
        setInfoMessage("Failed to send message");
      }
    } catch (error) {
        setInfoMessage("An error occurred:", error);
    }
  };

  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  return (
    <div className={styles.container}>
      <h3>Enter Message</h3>
      <label id="infoLabel">{infoMessage}</label>
      <input
        placeholder="Enter text"
        value={inputValue}
        onChange={handleInputChange}
      />
      <button onClick={handleSendClick}>Send</button>
    </div>
  );
};

export default Message;
