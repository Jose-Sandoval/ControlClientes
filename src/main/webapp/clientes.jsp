<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <!--FontAwesome-->
        <script src="https://kit.fontawesome.com/0725d80fe5.js" crossorigin="anonymous"></script>

        <title>Control de Clientes</title>
    </head>
    <body>

        <!-- Inclucion del Cebecero -->
        <%@include file="/WEB-INF/paginas/comunes/cabecero.jsp" %> 
        <%--<jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"></jsp:include>--%>

        <!-- Inclucion de una boton de navegacion -->
        <%@include file="/WEB-INF/paginas/comunes/botonesNavegaciom.jsp" %>

        <!-- Inclucion de jsp de listadoClientes -->
        <%@include file="/WEB-INF/paginas/cliente/listadoClientes.jsp" %>         

        <!-- Pie de pagina -->        
        <%@include file="/WEB-INF/paginas/comunes/piePagina.jsp" %>
        
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
