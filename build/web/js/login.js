$(document).ready(function () {

    ;

    $('#formLogin').submit((e) => {
        e.preventDefault();

        const usuario = $("#username").val();
        const password = $("#password").val();
        const empresa = $("#idEmpresa").val();
       
        if (usuario === "" || password === "" ||  empresa === "0") {
            alert("Todos los datos son obrigatorios");
        } else {
            $.ajax({
                url: "./Login",
                type: "POST",
                data: {username: usuario,
                       password: password,
                       empresa: empresa},
                       dataType: "json",
                success: function (data) {
                    console.log(data,"por aca")
                    if (data.isValid) {
                        $("#app").load("./view/dashboard.jsp");
                    } else {
                        alert("Datos no validos");
                    }
                }
            });
        }
    });
}
);