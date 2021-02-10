/* global Swal */

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
                .then((result) => {
                    if (result.value) {
                        $.post("Requisicion",
                                cargarRequisicion(),
                                (data) => {
                            if (data.isValid) {

                                Swal.fire({
                                    position: 'top-end',
                                    icon: 'success',
                                    title: data.message,
                                    showConfirmButton: false,
                                    timer: 1500
                                })

                                deshabilitarControles();
                                desBotonesRequisicion();
                                desBotonesRequisicionDetalle();
                                $("#numRequicion").val(data.data.num_requisicion);
                                $("#estado").val(data.data.estado_requisicion);
                                $("#editarRequisicion").removeAttr("disabled");
                                $("#cancelarRequisicionDetalle").removeAttr("disabled");
                                $("#salvarRequisicionDetalle").removeAttr("disabled");
                                $("#agregar").removeAttr("disabled");
                            }
                        }
                        );
                    }
                });
    });

    $("#agregar").click(() => {


        const row = "<tr id='row-" +  + "'><td class='text-center'>\n\
                         <button type='button' class='btn-sm btn-danger' id='quitar' onclick='deleteRow(" + count + ");'>\n\
                                     <i class='fas fa-trash-alt'></i></button></td>\n\
                         <td><input type='text' class='form-control form-control-sm' id='consultarItem' /></td>\n\
                         <td><input type='text' class='form-control form-control-sm' disabled/></td>\n\
                         <td><input type='number' class='form-control form-control-sm' /></td>\n\
                         <td><input type='text' class='form-control form-control-sm' disabled/></td>\n\
                         <td><input type='number' class='form-control form-control-sm' /></td>\n\
                         <td><input type='checkbox' class='form-control' /></td></tr>";
        


        $("#row").append(row);


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
        $("#prev").removeAttr("disabled");
        $("#next").removeAttr("disabled");
    }

    function deshabilitarControles() {
        $("#centroC").attr("disabled", "false");
        $("#idclasificacion").attr("disabled", "false");
        $("#numRequicion").attr("disabled", "false");
        $("#fechaRequicion").attr("disabled", "false");
        $("#idTipo").attr("disabled", "false");
        $("#observacion").attr("disabled", "false");
        $("#numInterno").attr("disabled", "false");
    }

    function habilitarControles() {
        $("#centroC").removeAttr("disabled");
        $("#idclasificacion").removeAttr("disabled");
        $("#fechaRequicion").removeAttr("disabled");
        $("#idTipo").removeAttr("disabled");
        $("#observacion").removeAttr("disabled");
        $("#numInterno").removeAttr("disabled");
    }

    function desBotonesRequisicion() {
        $("#nuevoRequisicion").attr("disabled", "false");
        $("#cancelarRequisicion").attr("disabled", "false");
        $("#salvarRequisicion").attr("disabled", "false");
        $("#editarRequisicion").attr("disabled", "false");
        $("#prevData").attr("disabled", "false");
        $("#nextData").attr("disabled", "false");
        $("#prev").attr("disabled", "false");
        $("#next").attr("disabled", "false");
    }

    function desBotonesRequisicionDetalle() {
        $("#editarRequisicionDetalle").attr("disabled", "false");
        $("#salvarRequisicionDetalle").attr("disabled", "false");
        $("#cancelarRequisicionDetalle").attr("disabled", "false");
        $("#agregar").attr("disabled", "false");
    }

    function cargarRequisicion() {
        let json = JSON.parse(localStorage.getItem("login"));

        return {idEmpresa: json.idEmpresa,
            centroCosto: $("#centroC").val(),
            clasificacion: $("#idclasificacion").val(),
            fechaRequicion: $("#fechaRequicion").val(),
            tipo: $("#idTipo").val() === 1 ? "O" : "U",
            observacion: $("#observacion").val(),
            numInterno: $("#numInterno").val(),
            user: json.user
        };
    }

});


