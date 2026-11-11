let taskArray = [];

function addTask() {
    let newTask = prompt("New task:");
    if (newTask !== null && newTask !== "") {
        taskArray.push(newTask);
    }
    showTasks();
}

function showTasks() {
    let list = document.getElementById("task-list");
    list.innerHTML = "";   // clear the old list so theres no repeats

    if (taskArray.length === 0) {
        list.innerHTML += "<li>No tasks yet.</li>"
        return;
    }

    // loop through the taskArray and add each task to the list
    for (let i = 0; i < taskArray.length; i++) {
        list.innerHTML += "<li>" + taskArray[i] + "</li>";
    }
}