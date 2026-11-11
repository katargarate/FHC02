addSection();
addTaskList();
addNewTaskButton();
addImage();
changeH2TextOnHover();
addRemoveTaskButton();

let currTaskNr = 3; // aktuelle Anzahl der Aufgaben, fängt bei 3 an, da wir schon 3 Aufgaben haben


// neues <section> mit h2 und p hinzufügen
function addSection() {
    document.getElementById("container").innerHTML += `
        <section>
            <h2>Neue Sektion</h2>
            <p>Dies ist eine dynamisch hinzugefügte Sektion.</p>
        </section>
    `;
}

// Liste von AUfgaben erstellen. <ul> mit 3 dynamisch generierten <li>s.
function addTaskList() {
    document.getElementById("container").innerHTML += `
        <ul id="taskList">
            <li>Aufgabe 1</li>
            <li>Aufgabe 2</li>
            <li>Aufgabe 3</li>
        </ul>
    `;

}

// Schaltfläche, um neue Task zu erstellen (Aufgabe 4, Aufgabe 5...)
function addNewTaskButton() {
    document.getElementById("container").innerHTML += `
    <button id="newTask" onclick="addTask()">Neue Aufgabe</button>
    `
}

// Funktion, die eine neue Aufgabe hinzufügt, wenn die Schaltfläche geklickt wird
// Die neue Aufgabe wird als <li> in die bestehende <ul> eingefügt.
// Die neue Aufgabe wird automatisch nummeriert (Aufgabe 4, Aufgabe 5, ...)
function addTask() {
    const button = document.getElementById("newTask");
    const taskList = document.getElementById("taskList");
    const newTaskNumber = ++currTaskNr; // aktuelle Anzahl der Aufgaben erhöhen
    newTask.textContent = `Aufgabe ${newTaskNumber}`;
    taskList.appendChild(newTask);
}

// Bild dynamisch hinzufügen. Soll unterhalb der <ul> erscheinen. Das Bild soll eine feste Breite von 200px haben.
function addImage() {
    const taskList = document.getElementById("taskList");
    const newImage = document.createElement("img");
    newImage.src = "https://i.programmerhumor.io/2025/07/35b9d0be76ae8040db0f0e20aaf1c6e7c83d0ccbc03026a7617f1d6942c6d68b.jpeg";
    newImage.style.width = "300px";
    newImage.style.display = "block";
    newImage.style.marginTop = "20px";
    newImage.style.marginBottom = "20px";
    taskList.after(newImage); 
}


// Funktion, die den Text des <h2> ändert, wenn man mit der Maus darüber fährt.
// und wieder zurücksetzt, wenn die Maus den Bereich verlässt.
function changeH2TextOnHover() {
    const h2 = document.querySelector("h2");
    h2.addEventListener("mouseover", function() {
        this.textContent = "psssst, du hast mich gefunden!";
    });

    h2.addEventListener("mouseout", function() {
        this.textContent = "Neue Sektion";
    });
}

// Schaltfläche, die immer das erste element aus der "taskList" entfernt, wenn sie geklickt wird.
function addRemoveTaskButton() {
    document.getElementById("container").innerHTML += `
    <button id="removeTask" onclick="removeTask()">Erste Aufgabe entfernen</button>
    `
}

// Funktion, die das erste Element aus der "taskList" entfernt.
function removeTask() {
    const taskList = document.getElementById("taskList");
    if (taskList.children.length > 0) {
        taskList.removeChild(taskList.children[0]);
    } else {
        alert("Keine Listenelemente mehr vorhanden!");
    }
}

