import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  deleteTodoApi,
  retrieveAllTodosForUsernameApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";

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
    retrieveAllTodosForUsernameApi(username)
      .then((response) => {
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
    navigate(`/todo/${id}`);
  }

  function addNewTodo() {
    navigate(`/todo/-1`);
  }

  return (
    <div className="container">
      <h1>
        <b>Things You Want To Do!</b>
      </h1>
      {message && <div className="alert alert-warning">{message}</div>}
      <div>
        <table className="table m-5">
          <thead>
            <tr>
              <td>
                <b> Description</b>
              </td>
              <td>
                <b>Is Done?</b>
              </td>
              <td>
                <b>Target Date</b>
              </td>
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
        <div>
          <button className="btn btn-success m-5 " onClick={addNewTodo}>
            Add new Task
          </button>
        </div>
      </div>
    </div>
  );
}
