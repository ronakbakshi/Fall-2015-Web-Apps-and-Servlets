/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
           
   $('#order').click(function(){
   SMALL_PRICE = 6.00;
   MEDIUM_PRICE = 9.00;
   LARGE_PRICE = 11.00;
   CHOCOLATE = 1.00;
   MINT = 1.25;
   STRAWBERRY = 1.50;
   VANILLA = 1.50;
   CARAMEL = 0.50;
   STRAWBERRYSF = 0.70;
   MAX = 25;
   MIN = 45;
   var price = 0.00;
   var allDataEntered = true;
   var randomtime = Math.round(Math.random() * (MAX - MIN + 1)) + MIN; 
   var quantity = parseInt($("#quantity").val());
   
   if(allDataEntered){
        if ($("#flavor").val() === "chocolate") {
            price += CHOCOLATE;
        } else if ($("#flavor").val() === "mint") {
            price += MINT;
        }else if ($("#flavor").val() === "strawberry") {
            price += STRAWBERRY; 
        }else if ($("#flavor").val() === "vanilla") {
            price += VANILLA; 
        }else {
            allDataEntered = false;
            alert("You must select the flavor of ice cream you want.");
        }
    }
    if(allDataEntered){
        if ($(":radio[name=size]:checked").val() === "small") {
            price += SMALL_PRICE;
        } else if ($(":radio[name=size]:checked").val() === "medium") {
            price += MEDIUM_PRICE;
        } else if ($(":radio[name=size]:checked").val() === "large") {
            price += LARGE_PRICE;
        } else {
            allDataEntered = false;
            alert("You must select the size of ice cream you want.");
        }
    }
    if(allDataEntered){
        if(( quantity >= 1)&&( quantity <= 10)){
            price = ( quantity * price );
        }
        else{
            allDataEntered = false;
            alert("You must enter the number of ice creams you would like to order between 1 to 10");
        }
    }
   if ($(":checkbox[id=caramel]:checked").val() === "caramel") {
        price = price + (quantity * CARAMEL);
   }
   
   if ($(":checkbox[id=strawberry]:checked").val() === "strawberry") {
        price = price + ( quantity * STRAWBERRYSF);
   }
   if (allDataEntered) {
      $("#price").html("The total cost is $" + price.toFixed(2)); 
      $("#random").html("Your order will be delivered in about " + randomtime +" minutes");
      
        if ($("#flavor").val() === "chocolate") {
            $("#main").css('background-color','grey');
            $("#mint").css('display','none');
            $("#straw").css('display','none');
            $("#vanilla").css('display','none');
            $("#choco").slideDown("slow");          
        } else if ($("#flavor").val() === "mint") {
           $("#main").css('background-color','sienna');
           $("#choco").css('display','none');
           $("#straw").css('display','none');
           $("#vanilla").css('display','none');
           $("#mint").slideDown("slow");
        }else if ($("#flavor").val() === "strawberry") {
           $("#main").css('background-color','pink');
           $("#mint").css('display','none');
           $("#choco").css('display','none');
           $("#vanilla").css('display','none');
           $("#straw").slideDown("slow");
        }else if ($("#flavor").val() === "vanilla") {
           $("#main").css('background-color','cornsilk');
           $("#mint").css('display','none');
           $("#straw").css('display','none');
           $("#choco").css('display','none');
           $("#vanilla").slideDown("slow");
        }    
        
   }
   else{
      $("#price").html("");
      $("#random").html("");
      $("#mint").css('display','none');
      $("#straw").css('display','none');
      $("#choco").css('display','none');
      $("#vanilla").css('display','none');
   }
});
}
);
