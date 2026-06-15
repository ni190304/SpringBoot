/* eslint-disable react-hooks/exhaustive-deps */
import { useNavigate, useParams } from "react-router-dom";
import {
  createTodoApi,
  retrieveTodoApi,
  updateTodoApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useEffect, useState } from "react";
import moment from "moment";

export default function TodoComponent() {
  const { id } = useParams();
  const todoId = Number(id);

  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");

  const authContext = useAuth();
  const username = authContext.username;

  const navigate = useNavigate();

  useEffect(() => {
    if (todoId !== -1) {
      retrieveTodos();
    }
  }, [todoId]);

  function retrieveTodos() {
    retrieveTodoApi(username, todoId)
      .then((response) => {
        setDescription(response.data.description);
        setTargetDate(response.data.targetDate);
      })
      .catch((error) => console.log(error));
  }

  function onSubmit(values) {
    const todo = {
      id: todoId,
      username,
      description: values.description,
      targetDate: values.targetDate,
      done: false,
    };

    if (todoId === -1) {
      createTodoApi(username, todo)
        .then(() => navigate("/todos"))
        .catch((error) => console.log(error));
    } else {
      updateTodoApi(username, todoId, todo)
        .then(() => navigate("/todos"))
        .catch((error) => console.log(error));
    }
  }

  function validate(values) {
    let errors = {};

    if (!values.description || values.description.length < 5) {
      errors.description = "Enter a valid description";
    }

    if (
      !values.targetDate ||
      !moment(values.targetDate).isValid()
    ) {
      errors.targetDate = "Enter a valid target date";
    }

    return errors;
  }

  return (
    <div className="container">
      <h2>Enter Todo Details</h2>

      <div className="m-5">
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          <Form>
            <ErrorMessage
              name="description"
              component="div"
              className="alert alert-warning"
            />

            <ErrorMessage
              name="targetDate"
              component="div"
              className="alert alert-warning"
            />

            <fieldset className="form-group">
              <label>Description</label>
              <Field
                type="text"
                className="form-control"
                name="description"
              />
            </fieldset>

            <fieldset className="form-group">
              <label>Target Date</label>
              <Field
                type="date"
                className="form-control"
                name="targetDate"
              />
            </fieldset>

            <button className="btn btn-success m-5">
              Submit
            </button>
          </Form>
        </Formik>
      </div>
    </div>
  );
}