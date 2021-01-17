<%@page import="java.util.ArrayList;"%>
<%@page import="Models.Business;"%>
<%@page import="Dao.DaoBusiness;"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
        <title>SISlogApp | Sistema Administrativo y Gestion Logistica</title>
        <link rel="icon" type="image/x-icon" href="VENDOR/assets/img/favicon.png"/>
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700" rel="stylesheet">
        <link href="VENDOR/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="VENDOR/assets/css/plugins.css" rel="stylesheet" type="text/css" />
        <link href="VENDOR/assets/css/authentication/form-2.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <link rel="stylesheet" type="text/css" href="VENDOR/assets/css/forms/theme-checkbox-radio.css">
        <link rel="stylesheet" type="text/css" href="VENDOR/assets/css/forms/switches.css">
    </head>
    <body class="form">
        <div class="form-container outer">
            <div class="form-form">
                <div class="form-form-wrap">
                    <div class="form-container">
                        <div class="form-content">
                            <h1 class="">SISlog App</h1>
                            <p class="">Sistema Administracion  y Gestion Logistica</p>
                            <form class="text-left" action="Login" method="POST" id="formLogin">
                                <div class="form">
                                    <div id="username-field" class="field-wrapper input">
                                        <label for="username">USUARIO</label>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-user"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg>
                                        <input id="username" name="username" type="text" class="form-control" placeholder="SysLog" required>
                                    </div>

                                    <div id="password-field" class="field-wrapper input mb-2">
                                        <label for="password">PASSWORD</label>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-lock"><rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect><path d="M7 11V7a5 5 0 0 1 10 0v4"></path></svg>
                                        <input id="password" name="password" type="password" class="form-control" placeholder="Password" required>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" id="toggle-password" class="feather feather-eye"><path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path><circle cx="12" cy="12" r="3"></circle></svg>
                                    </div>
                                    <div class="field-wrapper input" >
                                        <label for="idEmpresa">EMPRESA</label>
                                        <select class="form-control"
                                                id="idEmpresa"
                                                name="idEmpresa"
                                                >
                                            <option selected="0" value="0">-- Seleccione --</option>
                                            <%
                                                DaoBusiness daoBusiness = new DaoBusiness();
                                                ArrayList<Business> listBusiness = daoBusiness.listBusiness();
                                               for(Business business : listBusiness ){             
                                             %>
                                             <option value="<%= business.getIdBusiness() %>">
                                                 <%= business.getBusiness() %></option>
                                            <%}; %>
                                        </select>
                                    </div>
                                    <br>
                                    <div class="d-sm-flex justify-content-between">
                                        <div class="field-wrapper">
                                            <button type="submit" class="btn btn-primary">Entrar</button>
                                        </div>
                                    </div>
                                    </br>
                                    </br>                        
                                </div>
                            </form>
                        </div>                    
                    </div>
                </div>
            </div>
        </div>
        <!-- BEGIN GLOBAL MANDATORY SCRIPTS -->
        <script src="VENDOR/assets/js/libs/jquery-3.1.1.min.js"></script>
        <script src="VENDOR/bootstrap/js/popper.min.js"></script>
        <script src="VENDOR/bootstrap/js/bootstrap.min.js"></script>
        <!-- END GLOBAL MANDATORY SCRIPTS -->
        <script src="VENDOR/assets/js/authentication/form-2.js"></script>
        <<script src="js/login.js"></script>
    </body>

</html>