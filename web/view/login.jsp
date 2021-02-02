<%@page import="Models.Empresa"%>
<%@page import="Dao.DaoEmpresa"%>
<%@page import="java.util.ArrayList;"%>

<div>  
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
                                    <input id="username" name="username" type="text" class="form-control" placeholder="SysLog">
                                </div>

                                <div id="password-field" class="field-wrapper input mb-2">
                                    <label for="password">PASSWORD</label>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-lock"><rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect><path d="M7 11V7a5 5 0 0 1 10 0v4"></path></svg>
                                    <input id="password" name="password" type="password" class="form-control" placeholder="Password">
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
                                            DaoEmpresa daoEmpresa = new DaoEmpresa();
                                            ArrayList<Empresa> listBusiness = daoEmpresa.listBusiness();
                                            for (Empresa empresa : listBusiness) {
                                        %>
                                        <option value="<%= empresa.getIdBusiness()%>">
                                            <%= empresa.getBusiness()%></option>
                                            <%};%>
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
</div> 
<script src="js/login.js"></script>

