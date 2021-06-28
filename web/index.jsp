<%
    if (session.getAttribute("login") != "OK") {
        if (session.getAttribute("login") != "OKI") {
            response.sendRedirect("login.jsp");
        }
    }
%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    System.out.println("Hora actual: " + dateFormat.format(date));
%>
<jsp:include page="inicio.jsp" />
<section class="bg-light py-3">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-8">
                <h1 class="font-weight-bold mb-0">Control de ingresos y gastos</h1>                            
            </div>
        </div>
    </div>
</section>
<section class="bg-mix py-3">
    <div class="container">
        <div class="card rounded-0">
            <div class="card-body">
                <div class="row">
                    <div class="col-lg-3 col-md-6 d-flex stat my-3">
                        <div class="mx-auto">
                            <h6 class="text-muted">Total de Ingresos</h6>
                            <h3 class="font-weight-bold">${totalingresos}</h3>                                        
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 d-flex stat my-3">
                        <div class="mx-auto">
                            <h6 class="text-muted">Total de Egresos</h6>
                            <h3 class="font-weight-bold">${totalegresos}</h3>
                            <h6 class="text-success"><i class="icon ion-md-arrow-dropup-circle"></i> 25.50%</h6>
                        </div>
                    </div>                                
                    <div class="col-lg-3 col-md-6 d-flex my-3">
                        <div class="mx-auto">
                            <h6 class="text-muted">Hora</h6>
                            <h3 class="font-weight-bold"><%= dateFormat.format(date)%></h3>    
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 d-flex stat my-3">
                        <div class="mx-auto">
                            <h6 class="text-muted"></h6>
                            <h3 class="font-weight-bold"></h3>
                        </div>
                    </div>    
                </div>
            </div>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 my-3">
                <div class="card rounded-0">
                    <div class="card-header bg-light">
                        <h6 class="font-weight-bold mb-0">Sistema de control de ingresos y egresos</h6>
                    </div>
                    <div class="card-body">
                        <canvas id="myChart" width="300" height="150"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</section>
</div>
</div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js" integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI=" crossorigin="anonymous"></script>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Ingresos', 'Egresos'],
            datasets: [{
                    label: ' ',
                    data: [${totalingresos}, ${totalegresos}],
                    backgroundColor: [
                        '#111B54',
                        '#12C9E5',
                    ],
                    maxBarThickness: 30,
                    maxBarLength: 2
                }]
        }
    });
</script>
</body>

</html>