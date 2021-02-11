<%@page import="Models.ClasificacionRequisicion"%>
<%@page import="Dao.DaoClasificacionRequisicion"%>
<%@page import="Models.CentroCosto"%>
<%@page import="Dao.DaoCentroCosto"%>
<%@page import="java.util.ArrayList;"%>

<div class="card m-5">

    <div class="card-header text-center"><h4>Requisiciones</h4></div>

    <div class="card-body">   
        <div class="card p-2">
            <div class="row">
                <div class="col-xl-3 col-xs-12">
                    <label for="centroC">Centro de Costo</label>
                    <select class="form-control form-control-sm"
                            id="centroC"
                            name="centroC"
                            >
                        <option selected="0" value="0">-- Seleccione --</option>
                        <%

                            DaoCentroCosto daoCentroCosto = new DaoCentroCosto();
                            ArrayList<CentroCosto> listCentroCosto = daoCentroCosto.listCentroCosto();

                            for (CentroCosto centroCosto : listCentroCosto) {
                        %>
                        <option value="<%= centroCosto.getCod_cc()%>">
                            <%= centroCosto.getNom_cc()%></option>
                            <%};%>
                    </select>
                </div>
                <div class="col-xl-3 col-xs-12">
                    <label for="idclasificacion">Clasif. de Requisición</label>
                    <select class="form-control form-control-sm"
                            id="idclasificacion"
                            name="idclasificacion"
                            >
                        <option selected="0" value="0">-- Seleccione --</option>
                        <%
                            DaoClasificacionRequisicion daoClasificacionRequisicion = new DaoClasificacionRequisicion();
                            ArrayList<ClasificacionRequisicion> listClasificacionRequisicion = daoClasificacionRequisicion.listClasificacionRequisicion();
                            for (ClasificacionRequisicion clasificacionRequisicion : listClasificacionRequisicion) {
                        %>
                        <option value="<%= clasificacionRequisicion.getClasificacion()%>">
                            <%= clasificacionRequisicion.getNom_clasificacion()%></option>
                            <%};%>
                    </select>
                </div>
                <div class="col-xl-3 col-xs-12">
                    <label for="numRequicion">Num. Requisición</label>
                    <input id="numRequicion" name="numRequicion" type="text" class="form-control form-control-sm" disabled>
                </div>
                <div class="col-xl-3 col-xs-12">
                    <label for="estado">Estado</label>
                    <input id="estado" name="estado" type="text" class="form-control form-control-sm" disabled>
                </div>
                <div class="col-xl-4 col-xs-12">
                    <label for="fechaRequicion">Fecha</label>
                    <input id="fechaRequicion" name="fechaRequicion" type="date" class="form-control form-control-sm">
                </div>
                <div class="col-xl-4 col-xs-12">
                    <label for="idTipo">tipo de Requisición</label>
                    <select class="form-control form-control-sm"
                            id="idTipo"
                            name="idTipo"
                            >
                        <option selected="0" value="0">-- Seleccione --</option>
                        <option value="1">Ordinario</option>
                        <option value="2">Urgente</option>
                    </select>
                </div>
                <div class="col-xl-4 col-xs-12">
                    <label for="numInterno">Solicitud de Materiales</label>
                    <input id="numInterno" name="numInterno" type="text" class="form-control form-control-sm">
                </div>
                <div class="col-12">
                    <label >Obsevación</label>
                    <textarea rows="2" cols="30" class="form-control" id="observacion"></textarea>
                </div>
            </div>
            <div class="card-footer d-flex justify-content-between align-items-center" >
                <div>
                    <button type="button" class="btn btn-primary" id="nuevoRequisicion">
                        <i class="fas fa-file"></i>
                    </button>-
                    <button type="button" class="btn btn-danger" id="cancelarRequisicion">
                        <i class="fas fa-ban"></i>
                    </button>
                    <button type="button" class="btn btn-secondary" id="editarRequisicion">
                        <i class="fas fa-edit"></i>
                    </button>
                    <button type="button" class="btn btn-success" id="salvarRequisicion">
                        <i class="fas fa-save"></i>
                    </button>
                </div>
                <div class="form-inline">
                    <button type="button" class="btn btn-secondary" id="prevData">
                        <i class="fas fa-backward"></i>
                    </button>
                    <input type="text" class="form-control form-control-sm ml-2 mr-2" id="num" disabled=""/>
                    <button type="button" class="btn btn-secondary" id="nextData">
                        <i class="fas fa-forward"></i>
                    </button>
                </div>
            </div>
        </div>
        <div class="card p-2 mt-2">
            <div class="float-left">
                <button type="button" class="btn btn-primary" id="agregar">
                    <i class="fas fa-plus-square"></i>
                </button>
            </div>
            <hr>
            <div class="table table-responsive">
                <table class="table table-bordered table-sm" id="table">
                    <thead>
                    <th class="text-center">Quitar</th>
                    <th class="text-center">Codigo</th>
                    <th width="200" class="text-center">Descripción</th>
                    <th class="text-center">Cantidad</th>
                    <th class="text-center">U.</th>
                    <th class="text-center">Aprobadas</th>
                    <th class="text-center">Estado</th>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
            <div class="card-footer">
                    <button type="button" class="btn btn-danger" id="cancelarRequisicionDetalle">
                        <i class="fas fa-ban"></i>
                    </button>
                    <button type="button" class="btn btn-secondary" id="editarRequisicionDetalle">
                        <i class="fas fa-edit"></i>
                    </button>
                    <button type="button" class="btn btn-success" id="salvarRequisicionDetalle">
                        <i class="fas fa-save"></i>
                    </button>
            </div>
        </div>
        <div class="card-footer">
            <div class="float-right">
            <div class="form-inline ">
                <button type="button" class="btn btn-secondary" id="prev">
                    <i class="fas fa-backward"></i>
                </button>
                <input type="text" class="form-control form-control-sm ml-2 mr-2" id="numDetalle" disabled=""/>
                <button type="button" class="btn btn-secondary" id="next">
                    <i class="fas fa-forward"></i>
                </button>
            </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="js/requisicion.js"></script>




