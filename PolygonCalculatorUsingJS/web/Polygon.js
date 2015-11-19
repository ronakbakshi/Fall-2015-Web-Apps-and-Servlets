/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FullCalculation(){  
    var n = parseInt(document.getElementById("sides").value);
    var radius = parseFloat(document.getElementById("radius").value);
    var side = (2 * radius * Math.sin(Math.PI/n));    
    var perimeter = (n * side);
    var area = (0.25 * n * side * side / Math.tan(Math.PI/n));
    document.getElementById("sidelength").value = side.toFixed(2);
    document.getElementById("perimeter").value = perimeter.toFixed(2);
    document.getElementById("area").value = area.toFixed(2);
}

window.onload = function() {
    document.getElementById("btnCalculate").onclick = FullCalculation;
    document.getElementById("sides").focus();
    
};



