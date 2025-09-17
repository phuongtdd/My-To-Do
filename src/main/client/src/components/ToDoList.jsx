import React, { useState } from "react";
import Task from "./Task";

function ToDoList() {
    const [tasks, setTasks] = useState([]);
    const [newTask, setNewTask] = useState("");
    const [editTask, setEditTask] = useState("");

    const STATUS = {
        DONE: 1,
        PENDING: 0,
    };

    const handleInputTask = (event) => {
        setNewTask(event.target.value);
    };

    const addTask = () => {
        console.log(editTask)
        console.log(newTask)
        if (editTask) {
            setTasks(prevTasks => prevTasks.map(
                task => {
                    if(task.id === editTask.id){
                        task.name = newTask
                    }
                    return task;
                }
            ))
            setNewTask("");
            setEditTask("");
        } else {
            if (newTask.trim() !== "") {
                setTasks((t) => [
                    ...t,
                    {
                        id: Math.floor(Math.random() * 100000),
                        name: newTask,
                        status: STATUS.PENDING,
                    },
                ]);
                setNewTask("");
            }
        }
    };

    const deleteTask = (index) => {
        const updatedTasks = tasks.filter((value, i) => {
            return i !== index;
        });
        setTasks(updatedTasks);
    };

    const handleUpdateStatus = (e, id) => {
        const newStatus = e.target.checked ? STATUS.DONE : STATUS.PENDING;
        setTasks((prevTasks) =>
            prevTasks.map((task) => {
                if (task.id === id) {
                    task.status = newStatus;
                }
                return task;
            })
        );
    };

    const handleEditTask = (id) => {
        const editTask = tasks.find((task) => task.id === id);
        setEditTask(editTask);
        setNewTask(editTask.name);
        console.log(editTask);
    };

    return (
        <>
            <div className="to-do-list">
                <h1>To Do List</h1>
                <div>
                    <input
                        type="text"
                        placeholder="Input your task..."
                        value={newTask}
                        onChange={handleInputTask}
                    />
                </div>
                <button onClick={() => addTask()}>{editTask ? 'Update Task' : 'Add Task'}</button>
                <div>
                    {tasks.map((task, index) => (
                        <Task
                            key={index}
                            task={task}
                            deleteTask={() => deleteTask(index)}
                            onChangeStatus={handleUpdateStatus}
                            onEditTask={() => handleEditTask(task.id)}
                        />
                    ))}
                </div>
            </div>
        </>
    );
}

export default ToDoList;
