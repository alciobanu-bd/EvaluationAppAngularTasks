<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <a href="/"><i class="fa fa-hospital-o fa-fw"></i><spring:message code="person.list.link.label"/></a>
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
                        <i class="fa fa-users fa-fw"></i> <spring:message code="person.create.page.title"/>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div>
                            <form:form action="/person/create" commandName="person" method="POST">
                                <div class="row">
                                    <div class="col-md-3">
                                        <form:label path="firstName"><spring:message code="person.label.firstName"/>:</form:label>
                                        <form:input class="form-control" path="firstName" size="20"/>
                                        <form:errors path="firstName" cssClass="error" element="div"/>
                                    </div>
                                    <div class="col-md-5">
                                        <form:label path="lastName"><spring:message code="person.label.lastName"/>:</form:label>
                                        <form:input class="form-control" path="lastName" size="20"/>
                                        <form:errors path="lastName" cssClass="error" element="div"/>
                                    </div>
                                </div>
                                <br>
                                <div>
                                    <label>Selectati medicul programarii  </label>
                                    <form:select class="form-control" path="doctor">
                                        <form:option value="NONE" label="--- Select ---" />
                                        <form:options items="${doctors}" />
                                    </form:select>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-md-6">
                                        <form:label path="appointmentDate"><spring:message code="person.label.date"/>:</form:label>
                                        <form:input class="form-control" path="appointmentDate" size="20"/>
                                        <form:errors path="appointmentDate" cssClass="error" element="div"/>
                                    </div>

                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-md-6">
                                        <form:label path="appointmentHour"><spring:message code="person.label.hour"/>:</form:label>
                                        <form:input class="form-control" path="appointmentHour" size="20"/>
                                        <form:errors path="appointmentHour" cssClass="error" element="div"/>
                                    </div>
                                </div>
                                <br>
                                <div>
                                    <input type="submit" class="btn btn-primary" value="<spring:message code="person.create.page.submit.label"/>"/>
                                </div>
                            </form:form>
                        </div>

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