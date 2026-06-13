import React, { useState } from "react";
import {useNavigate} from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LoginComponent() {
  const [username, setUsername] = useState("nayak19");
  const [password, setPassword] = useState("");

  const authContext = useAuth()

  const [showErrorMessage, setShowErrorMessage] = useState(false);

  const navigate = useNavigate();

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    setPassword(event.target.value);
  }

  function handleSubmit() {

    if (authContext.login(username, password)) {
        navigate(`/welcome/${username}`);
    } else {
        setShowErrorMessage(true);
    }

}

  return (
    <div className="Login">
      {showErrorMessage && (
        <div className="errorMessage">Authentication Failed</div>
      )}
      <div className="LoginForm">
        <div>
          <label>Username </label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>

        <div>
          <label>Password </label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>

        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}