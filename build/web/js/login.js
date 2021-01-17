$(document).ready(function () {


    $("#formLogin").submit(function (e) {
        e.preventDefault();
        
        var empresa = $("#idEmpresa").val();
        var username = $("#username").val();
        var password = $("#password").val();

        $.post($(this).attr("action"), {
            username: username,
            password: password,
            empresa: empresa
        }, function () {
            window.window.location.href = "dashboard.jsp";
        });
    });
});

