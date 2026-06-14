import { useState } from "react";
import { useParams, Link } from "react-router-dom";
import {retrieveHelloWorldPathVariable} from './api/HelloWorldApiService';
import { useAuth } from "./security/AuthContext";


export default function WelcomeComponent() {

  const [message, setMessage] = useState(null)

  const authContext = useAuth();

  const username = authContext.username;

  function callHelloWorld() {
    // console.log("called");

      retrieveHelloWorldPathVariable('Nihaal')
      .then((response) => successfulResponse(response))
      .catch((error) => errorResponse(error))
      .finally(() => console.log("cleanup"));
  }

  function successfulResponse(response) {
    // console.log(response);
    setMessage(response.data.message);
  }

  function errorResponse(error) {
    // console.log(error);
  }

  return (
    <div className="WelcomeComponent">
      <h2 className="Welcome">Welcome {username}</h2>
      <div>
        Manage your todos - <Link to="/todos">Go here</Link>
      </div>
      <div>
        <button className="btn btn-success m-5" onClick={callHelloWorld}>
          Call Hello World
        </button>
      </div>
      <div className="text-info">
      {message}
      </div>
    </div>
  );
}
