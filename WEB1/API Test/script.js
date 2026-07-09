
function loadProducts() {
    // fetch jason product list from api
    fetch('https://dummyjson.com/products', {
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
            const productList = document.getElementById("productList");

            // Produkte in die ul einfügen
            for (const product of data.products) {

                // li-Element erstellen
                const li = document.createElement("li");

                // Produktname und Preis in das li-Element einfügen
                const productName = product.title;
                const productPrice = product.price;

                // Produktname und Preis in das li-Element einfügen
                li.innerHTML = productName + " - " + productPrice + "€";

                // Bei Produkte mit Preise über 500, Textfarbe auf rot setzen
                if (product.price > 500) {
                    li.style.color = "red"
                }

                // li-Element in die ul einfügen
                productList.appendChild(li);
            }
        })

        .catch(error => {
            console.error("Fehler beim Laden der Produkte: ", error);
            console.error("Fehlermeldung: ", error.message);
            console.error("Fehlercode: ", error.code);

            const errorMessage = document.getElementById("errorMessage");
            errorMessage.innerHTML = "Fehler beim Laden der Produkte: " + "<strong>" + error.message + "</strong>" + "(Fehlercode: " + error.code + ")"
        
        });
}


loadProducts();