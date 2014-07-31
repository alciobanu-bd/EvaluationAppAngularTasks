<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="spring.data.jpa.example.title"/></title>
    <link rel="stylesheet" href="/static/css/styles.css" type="text/css"/>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">

    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="/static/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="/static/css/plugins/timeline/timeline.css" rel="stylesheet">

    <!-- SB Admin CSS - Include with every page -->
    <link href="/static/css/sb-admin.css" rel="stylesheet">
</head>

<body>

<div id="wrapper">

    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Clinica medicala Hilmi</a>
        </div>
        <!-- /.navbar-header -->
        <!-- /.navbar-top-links -->

        <div class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="/person/create"><i class="fa fa-hospital-o fa-fw"></i><spring:message code="person.create.link.label"/></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Clinica medicala Hilmi</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-11">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-users fa-fw"></i> Lista programari
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="messages">
                            <c:if test="${feedbackMessage != null}">
                                <div class="messageblock"><c:out value="${feedbackMessage}"/></div>
                            </c:if>
                            <c:if test="${errorMessage != null}">
                                <div class="errorblock"><c:out value="${errorMessage}"/></div>
                            </c:if>
                        </div>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Prenume pacient</th>
                                <th>Nume pacient</th>
                                <th>Nume doctor</th>
                                <th>Nume specializare</th>
                                <th>Data programarii</th>
                                <th>Ora programarii</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${personDtos}" var="person">
                                <tr>
                                    <td><c:out value="${person.lastName}"/></td>
                                    <td><c:out value="${person.firstName}"/></td>
                                    <td><c:out value="${person.doctorName}"/></td>
                                    <td><c:out value="${person.specialtyName}"/></td>
                                    <td><c:out value="${person.appointmentDate}"/></td>
                                    <td><c:out value="${person.appointmentHour}"/></td>
                                    <td><a href="/person/edit/<c:out value="${person.id}"/>"><spring:message code="person.edit.link.label"/></a></td>
                                    <td><a href="/person/delete/<c:out value="${person.id}"/>"><spring:message code="person.delete.link.label"/></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>

</div>
</body>
</html>