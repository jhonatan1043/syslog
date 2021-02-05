window.onbeforeunload = confirmExit;

function confirmExit() {
    return "Ha intentado salir de esta pagina, ¿Seguro que desea salir de esta pagina? ";
}

$(document).ready(() => {

    $("#formRequisicion").click(() => {
        $("#contenedor").load("./view/requisicion.jsp");
    });
    
});




