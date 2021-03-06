<%@ page import="grailsblog.SecUser" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Edit user ${secUserInstance.fullname}</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Edit user ${secUserInstance.fullname}</h1>

                <ol class="breadcrumb">
                    <li>
                        <g:link class="list" action="index">
                            <i class="fa fa-user"></i> Users
                        </g:link>
                    </li>
                    <li class="active">
                        Edit user ${secUserInstance.fullname}
                    </li>
                </ol>

                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>

                <g:hasErrors bean="${secUserInstance}">
                    <g:eachError bean="${secUserInstance}" var="error">
                        <div class="alert alert-danger" <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                            <g:message error="${error}"/>
                        </div>
                    </g:eachError>
                </g:hasErrors>

                <g:form url="[resource:secUserInstance, action:'update']" method="PUT" >
                    <g:render template="form"/>
                </g:form>
            </div>
        </div>
    </body>
</html>
