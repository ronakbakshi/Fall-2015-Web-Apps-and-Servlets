function getplanetsFromServer() {
    $.getJSON("PlanetServlet?distance=" + $("#distID").val()+"&diameter="+$("#diameterID").val()+"&gravity="+$("#gravityID").val(), displayPlanet);
}

function displayPlanet(data) {
    $("#planetList").empty();
    $.each(data.planetList,
            function() {
                $("#planetList").append(
                        "<tr>"
                        + "<td>" + this.name + "</td>"
                        + "<td>" + this.averageDistanceFromSun + "</td>"
                        + "<td>" + this.periodOfRevolution + "</td>"
                        + "<td>" + this.diameter + "</td>"
                        + "<td>" + this.mass + "</td>"
                        + "<td>" + this.gravity + "</td>"
                        + "</tr>");
            });
}

$(document).ready(
        function() {
            $("#getPlanets").click(getplanetsFromServer);
        }
);