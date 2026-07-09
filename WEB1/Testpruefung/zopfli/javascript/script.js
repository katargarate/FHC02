
function loadUsers() {
    // fetch jason users list from api
    fetch('https://dummyjson.com/users', {
        method: 'GET',
        headers: {
            'Accept': 'application/json'
        }
    })

        .then(response => {
            // HTTP-Status prüfen
            if (!response.ok) {
                throw new Error(`HTTP ${response.status}: ${response.statusText}`);
            }
            // response in json umwandeln
            return response.json();
        })

        .then(data => {
            const userList = document.getElementById("user-list");

            // Users in die ul einfügen
            for (const user of data.users) {

                // li-Element erstellen
                const li = document.createElement("li");

                // User first + last name in das li-Element einfügen
                const firstName = user.firstName;
                const lastName = user.lastName;

                li.innerHTML = firstName + " " + lastName;

                // li-Element in die ul einfügen
                userList.appendChild(li);
            }
        })

        .catch(error => {
            console.error("Fehler beim Laden der Users: ", error);
            console.error("Fehlermeldung: ", error.message);
            console.error("Fehlercode: ", error.code);

            const errorMessage = document.getElementById("errorMessage");
            errorMessage.innerHTML = "Fehler beim Laden der Users: " + "<strong>" + error.message + "</strong>" + "(Fehlercode: " + error.code + ")"
        
        });
}


loadUsers();