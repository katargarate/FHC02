// Starter-Code
const products = [
    { name: "Laptop", price: 699 },
    { name: "Handy", price: 299 },
    {name: "Kopfhörer", price: 109}
];

// HTML-Liste füllen
const productList = document.getElementById("productList");

// Dein Code hier...

for (const product of products) {
    if (product.price > 500) {
        const li = document.createElement("li");
        const productName = product.name;
        const productPrice = product.price;

        li.innerHTML = productName + " - " + productPrice + "€";
        productList.appendChild(li);
    }
}

