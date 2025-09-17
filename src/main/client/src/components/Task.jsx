import React from "react";
import "./task.css";
function Task({ task, deleteTask, onChangeStatus, onEditTask }) {
    return (
        <>
            <div>
        <span className={task.status === 1 ? "done" : ""}>
          <input
              type="checkbox"
              onClick={(e) => onChangeStatus(e, task.id)}
          ></input>
            {/* <a>{task.id}</a> */}
            {task.name}
        </span>
                <button onClick={deleteTask}>Delete</button>
                <button onClick={onEditTask}>Edit</button>
            </div>
        </>
    );
}

export default Task;
