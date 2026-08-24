function loadRecipes () {
    // fetch json recipe list from api
    fetch('https://dummyjson.com/recipes', {
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
            const recipeList = document.getElementById("list");

            // Rezepte in die ul einfügen
            for (const recipe of data.recipes) {

                // li-Element erstellen
                const li = document.createElement("li");

                // Rezept Name und Cuisine auslesen
                const recipeName = recipe.name;
                const recipeCuisine = recipe.cuisine;

                // Rezept Name und Cuisine in das li-Element einfügen
                li.innerHTML = recipeName + " - " + recipeCuisine;

                // li-Element in die ul einfügen
                recipeList.appendChild(li);
            }
        })

        .catch(error => {
            console.error("Fehler beim Laden der Rezepte: ", error);
            console.error("Fehlermeldung: ", error.message);

            const errorMessage = document.getElementById("errorMessage");
            errorMessage.innerHTML = "Fehler beim Laden der Rezepte: " + "<strong>" + error.message + "</strong>";
        });
}

loadRecipes();