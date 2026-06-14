import { useEffect, useState } from "react";
import {
  deleteTodoApi,
  retrieveAllTodosForUsernameApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {
  // const today = new Date();

  // const targetDate = new Date(
  //   today.getFullYear() + 12,
  //   today.getMonth(),
  //   today.getDay(),
  // );

  const authContext = useAuth();

  const username = authContext.username;

  const [todos, setTodos] = useState([]);

  const [message, setMessage] = useState(null);

  const navigate = useNavigate();

  // const todos = [
  // { id: 1, description: "Learn AWS", done: false, targetDate: targetDate },
  // { id: 2, description: "Learn GCP", done: false, targetDate: targetDate },
  // { id: 3, description: "Learn Azure", done: false, targetDate: targetDate },
  // ];

  useEffect(() => {
    refreshTodos();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  function refreshTodos() {
    console.log("Username:", username);
    retrieveAllTodosForUsernameApi(username)
      .then((response) => {
        // console.log(response)
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  }

  function deleteTodo(id) {
    console.log("clicked", id);
    deleteTodoApi(username, id)
      .then(() => {
        setMessage(`Delete of todo with ${id} success`);
        refreshTodos();
      })
      .catch((error) => console.log(error));
  }

  function updateTodo(id) {
    console.log("clicked", id);
    navigate(`/todo/${id}`)
  }

  return (
    <div className="container">
      <h2>Things You Want To Do!</h2>
      {message && <div className="alert alert-warning">{message}</div>}
      <div>
        <table className="table">
          <thead>
            <tr>
              <td>Description</td>
              <td>Is Done?</td>
              <td>Target Date</td>
              <td></td>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toString()}</td>
                <td>
                  {" "}
                  <button
                    className="btn btn-warning"
                    onClick={() => deleteTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>

                <td>
                  {" "}
                  <button
                    className="btn btn-success"
                    onClick={() => updateTodo(todo.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
