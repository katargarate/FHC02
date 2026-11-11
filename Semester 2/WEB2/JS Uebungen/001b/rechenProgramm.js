function startProgram() {
    let numberArray = enterNumbers();

    // if the user presses cancel, just return and do not continue with getting the operator and calculating
    if (numberArray === null) {
        return;
    }
    
    let operator = getOperator();
    // if the user presses cancel, just return and do not continue with the calculation
    if (operator === null) {
        return;
    }

    let solution = calculate(numberArray[0], numberArray[1], operator);

    if (solution === null) {
        let errorMsg = "Error while calculating.. likely a division by 0"
        alert(errorMsg);
        console.log(errorMsg);
    } else  {
        let successMsg = `${numberArray[0]} ${operator} ${numberArray[1]} = ${solution}`
        alert(successMsg);
        console.log(successMsg);
    }
    
}

function calculate(num1, num2, operator) {
    switch (operator) {
        case "+":
            return num1 + num2;
        case "-":
            return num1 - num2;
        case "*":
            return num1 * num2;
        case "/":
            if (num2 === 0) {
                return null;
            }
            return num1 / num2;
    }         
    return null;

}              


function getOperator() {
    // evtl. statt eine Schleife zu verwenden, könnte mann rekursiv die Methode aufrufen, bis der Benutzer einen gültigen Operator eingibt. Aber eine Schleife ist wahrscheinlich einfacher zu verstehen.
    do {
        let input = prompt("Enter an operator (+, -, *, /):");

        // if the user presses cancel, just return and do not continue with the calculation
        if (input === null) {
            alert("Operation cancelled.");
            return null;
        }
        
        if (input != "+" && input != "-" && input != "*" && input != "/") {
            alert("Invalid operator. Please enter a valid operator (+, -, *, /).")
            continue;
        } else return input;
    } while (true);
}

function enterNumbers() {
    let bothNumbersSet = false;
    let numberArray = [];

    while (!bothNumbersSet) {
        let number = prompt("Enter a number:");

        // if the user presses cancel, just return and do not continue with the calculation
        if (number === null) {
            alert("Operation cancelled.");
            return null;
        }

        if (number === null || number.trim() === "" || isNaN(number)) {
            alert("Invalid input. Please enter a valid number.");
            continue;
        }

        numberArray.push(parseFloat(number));

        if (numberArray.length === 2) {
            bothNumbersSet = true;
        }
    }

    return numberArray;
}
