$(document).ready(() => {

    init();

//--------------------------------------------------------------eventos de los botones requisiciones -------------
    $("#nuevoRequisicion").click(() => {
        habilitarControles();
        desBotonesRequisicion();
        $("#cancelarRequisicion").removeAttr("disabled");
        $("#salvarRequisicion").removeAttr("disabled");
    });

    $("#cancelarRequisicion").click(() => {
        deshabilitarControles();
        desBotonesRequisicion();
        $("#nuevoRequisicion").removeAttr("disabled");
    });

    $("#salvarRequisicion").click(() => {
        Swal.fire({
            title: "SisLog",
            text: "¿Desea Guardar?",
            icon: 'info',
            showCancelButton: true,
            confirmButtonText: "Sí",
            cancelButtonText: "No",
        })
                .then(() => {
                    $.post("/requisicion",
                            cargarRequisicion(),
                            (data) => {
                        if (data.isValid) {
                            deshabilitarControles();
                            desBotonesRequisicion();
                            desBotonesRequisicionDetalle();
                            $("#cancelarRequisicionDetalle").removeAttr("disabled");
                            $("#salvarRequisicionDetalle").removeAttr("disabled");
                        }
                    }
                    );
                });
    });
//--------------------------------------------------------------eventos de los botones requisiciones detalle -------------
    $("#cancelarRequisicionDetalle").click(() => {
        desBotonesRequisicionDetalle();
        $("#nuevoRequisicion").removeAttr("disabled");
    });

    $("#salvarRequisicionDetalle").click(() => {
        desBotonesRequisicionDetalle();
        $("#nuevoRequisicion").removeAttr("disabled");
    });
//--------------------------------------------------------------funciones y metodos -------------
    function init() {
        deshabilitarControles();
        desBotonesRequisicion();
        desBotonesRequisicionDetalle();
        $("#nuevoRequisicion").removeAttr("disabled");
    }

    function deshabilitarControles() {
        $("#centroC").attr("disabled", "false");
        $("#idclasificacion").attr("disabled", "false");
        $("#numRequicion").attr("disabled", "false");
        $("#fechaRequicion").attr("disabled", "false");
        $("#idTipo").attr("disabled", "false");
        $("#observacion").attr("disabled", "false");
    }

    function habilitarControles() {
        $("#centroC").removeAttr("disabled");
        $("#idclasificacion").removeAttr("disabled");
        $("#numRequicion").removeAttr("disabled");
        $("#fechaRequicion").removeAttr("disabled");
        $("#idTipo").removeAttr("disabled");
        $("#observacion").removeAttr("disabled");
    }

    function desBotonesRequisicion() {
        $("#nuevoRequisicion").attr("disabled", "false");
        $("#cancelarRequisicion").attr("disabled", "false");
        $("#salvarRequisicion").attr("disabled", "false");
        $("#editarRequisicion").attr("disabled", "false");
    }

    function desBotonesRequisicionDetalle() {
        $("#editarRequisicionDetalle").attr("disabled", "false");
        $("#salvarRequisicionDetalle").attr("disabled", "false");
        $("#cancelarRequisicionDetalle").attr("disabled", "false");
    }

    function cargarRequisicion() {
        return {idEmpresa: 0,
            centroCosto: $("#centroC").val(),
            clasificacion: $("#idclasificacion").val(),
            fechaRequicion: $("#fechaRequicion").val(),
            tipo: $("#idTipo").val(),
            observacion: $("#observacion").val(),
            idUser: "user"
        };

    }

});


