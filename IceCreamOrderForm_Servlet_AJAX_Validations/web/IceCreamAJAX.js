/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function calculatePrice() {

    var flavor = "";
    var size = "";
    var toppingCaramel = "";
    var toppingStrawberry = "";
    var allDataEntered = true;
    var quantity = parseInt(document.getElementById("quantity").value);
    if (allDataEntered) {
        if (document.getElementById("flavor").value === "chocolate") {
            flavor = "chocolate";
        } else if (document.getElementById("flavor").value === "mint") {
            flavor = "mint";
        } else if (document.getElementById("flavor").value === "strawberry") {
            flavor = "strawberry";
        } else if (document.getElementById("flavor").value === "vanilla") {
            flavor = "vanilla";
        } else {
            allDataEntered = false;
            alert("You must select the flavor of ice cream you want.");
        }
    }
    if (allDataEntered) {
        if (document.getElementById("small").checked) {
            size = "small";
        } else if (document.getElementById("medium").checked) {
            size = "medium";
        } else if (document.getElementById("large").checked) {
            size = "large";
        } else {
            allDataEntered = false;
            alert("You must select the size of ice cream you want.");
        }
    }
    if (allDataEntered) {
        if ((quantity >= 1) && (quantity <= 10)) {
            //price = (quantity * price);
        }
        else {
            allDataEntered = false;
            alert("You must enter the number of ice creams you would like to order between 1 to 10");
        }
    }
    if (document.getElementById("caramel").checked) {
        toppingCaramel = "caramel";
    }
    if (document.getElementById("strawberry").checked) {
        toppingStrawberry = "strawberry";
    }
    if (allDataEntered) {
 
        request = new XMLHttpRequest();
        var url = "iceCreamServlet?flavor=" + flavor + "&size=" + size + "&quantity=" + quantity + "&toppingCaramel=" + toppingCaramel + "&toppingStrawberry=" + toppingStrawberry;
        request.open("GET", url, true);
        request.onreadystatechange = displayOrder;
        request.send(null);
       
    }
    else {
        document.getElementById("headerOutput").innerHTML = "";
        document.getElementById("pTotal").innerHTML = "";
        document.getElementById("random").innerHTML = "";
    }
}
function displayOrder() {
    if (request.readyState === 4 && request.status === 200) {
        var totalPrice = request.responseText.split("\n");

        document.getElementById("headerOutput").innerHTML = "Bearcat Ice Cream Order Confirmation";
        document.getElementById("pTotal").innerHTML = "The total cost is $" + totalPrice[0];
        document.getElementById("random").innerHTML = "Your order will be delivered in about " + totalPrice[1] + " minutes.";
    }
}
window.onload = function () {
    document.getElementById("order").onclick = calculatePrice;
};





