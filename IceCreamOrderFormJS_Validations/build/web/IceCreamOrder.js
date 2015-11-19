/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function calculatePrice() {
   // Price List
   SMALL_PRICE = 6.00;
   MEDIUM_PRICE = 9.00;
   LARGE_PRICE = 11.00;
   CHOCOLATE = 1.00;
   MINT = 1.25;
   STRAWBERRY = 1.50;
   VANILLA = 1.50;
   CARAMEL = 0.50;
   SFSTRAWBERRY = 0.70;
   MAX = 25;
   MIN = 45;
   var price = 0.00;
   var allDataEntered = true;
   var randomtime = Math.round(Math.random() * (MAX - MIN + 1)) + MIN; 
   var quantity = parseInt(document.getElementById("quantity").value);
   if(allDataEntered){
        if (document.getElementById("flavor").value === "chocolate") {
            price += CHOCOLATE;
        } else if (document.getElementById("flavor").value === "mint") {
            price += MINT;
        }else if (document.getElementById("flavor").value === "strawberry") {
            price += STRAWBERRY; 
        }else if (document.getElementById("flavor").value === "vanilla") {
            price += VANILLA; 
        }else {
            allDataEntered = false;
            alert("You must select the flavor of ice cream you want.");
        }
    }
    if(allDataEntered){
        if (document.getElementById("small").checked) {
            price += SMALL_PRICE;
        } else if (document.getElementById("medium").checked) {
            price += MEDIUM_PRICE;
        } else if (document.getElementById("large").checked) {
            price += LARGE_PRICE;
        } else {
            allDataEntered = false;
            alert("You must select the size of ice cream you want.");
        }
    }
    if(allDataEntered){
        if((quantity>=1)&&(quantity<=10)){
            price = (quantity*price);
        }
        else{
            allDataEntered = false;
            alert("You must enter the number of ice creams you would like to order between 1 to 10");
        }
    }
   if (document.getElementById("caramel").checked) {
      price += (quantity*CARAMEL);
   }
   if (document.getElementById("strawberry").checked) {
      price += (quantity * SFSTRAWBERRY);
   }
   if (allDataEntered) {     
      document.getElementById("price").innerHTML = "The total cost is $" + price.toFixed(2);
      document.getElementById("random").innerHTML= "Your order will be delivered in about "+randomtime +" minutes";
   }
   else{
      document.getElementById("price").innerHTML = "";
      document.getElementById("random").innerHTML= ""; 
   }
}
window.onload = function() {
    document.getElementById("order").onclick = calculatePrice;
}



