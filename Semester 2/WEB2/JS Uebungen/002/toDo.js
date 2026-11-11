let taskArray = [];

function addTask() {
    let newTask = prompt("Enter a new task:");
    
    // if user enters cancel or leaves the prompt empty
    if (newTask === null || newTask.trim() === "") {
        return;
    }

    taskArray.push(newTask);
    showTasksOnPage();
    alert("You have successfully added a new task: " + newTask);
}

function deleteTask() {
    let pos = getPositionNumber();
    
    taskArray.splice(pos, 1); // 2nd parameter means remove one item only   

    showTasksOnPage();
    alert("You have successfully deleted task " + (pos + 1));
}

function editTask() {
    let pos = getPositionNumber();
    
    // new Task prompt with the current task text as default value
    let newTask = prompt("Enter the new task text for task " + (pos + 1) + ":", taskArray[pos]);
    
    if (newTask !== null) {
        taskArray[pos] = newTask;
        showTasksOnPage();
    }

    taskArray[pos] = newTask;

    alert("You have successfully edited task " + (pos + 1) + " to: " + newTask);
}

function getPositionNumber() {
    let index = prompt("Enter a position:");

    if (index === null) {
        return -1;   // user presses cancel
    }

    if (index.trim() === "" || isNaN(index)) {
        alert("Invalid input. Please enter a valid number.");
        return getPositionNumber(); 
    }

    let pos = parseInt(index) - 1; // convert to 0-based index

    if (parseInt(pos) < 0 || parseInt(pos) >= taskArray.length) {
        alert("Invalid position. Please enter a valid position.");
        return getPositionNumber();   
    }
    
    return parseInt(pos);
}

function showAllTasks() {
    alert("All tasks:\n" + taskArray.join("\n"));
}

function showTasksOnPage() {
    let list = document.getElementById("taskList");
    list.innerHTML = "";   // clear the old list so theres no repeats

    // loop through the taskArray and add each task to the list
    for (let i = 0; i < taskArray.length; i++) {
        list.innerHTML += "<li>" + taskArray[i] + "</li>";
    }
}