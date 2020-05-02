<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es-MX"></fmt:setLocale>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado Clientes</h4>
                    </div>
                    <table class="table table-stiped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>nombre</th>
                                <th>telefono</th>
                                <th>saldo</th>
                                <th></th>
                            </tr>                            
                        </thead> 
                        <tbody>
                            <!--iteramos la lista de clientes-->
                        <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                <tr>
                                    <th>${status.count}</th>
                                    <th>${cliente.nombre} ${cliente.apellido}</th>
                                    <th>${cliente.telefono}</th>
                                    <th><fmt:formatNumber value="${cliente.saldo}" type="currency"/></th>
                                    <th>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                           class="btn btn-secondary"><i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                                           class="btn btn-danger"><i class="fas fa-angle-double-right"></i>Eliminar
                                        </a>                                                                        
                                    </th>
                                </tr>                                
                            </c:forEach>
                        </tbody>
                    </table>
                </div>                
            </div>  
            <!--Targetas para los totales-->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3 >Saldo Total</h3>
                        <h5 class="display-4">
                        <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h5>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>TotalClientes </h3>  
                        <h4 class="display-4"> <i class="fas fa-users"></i>${totalClientes}</h4>
                    </div>                            
                </div>
            </div>            
        </div>
    </div>
</section>
<!--Agregar Cliente Modal-->   
<%@include file="agregarClienteJSP.jsp"%>
