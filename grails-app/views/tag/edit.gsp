<%@ page import="grailsblog.Tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Edit tag ${tagInstance.name}</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Edit tag ${tagInstance.name}</h1>

                <ol class="breadcrumb">
                    <li>
                        <g:link class="list" action="index">
                            <i class="fa fa-list-ul"></i> Categories
                        </g:link>
                    </li>
                    <li class="active">
                        Edit user ${tagInstance.name}
                    </li>
                </ol>

                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>

                <g:hasErrors bean="${tagInstance}">
                    <g:eachError bean="${tagInstance}" var="error">
                        <div class="alert alert-danger" <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                            <g:message error="${error}"/>
                        </div>
                    </g:eachError>
                </g:hasErrors>

                <g:form url="[resource:tagInstance, action:'update']" method="PUT" >
                    <g:render template="form"/>
                </g:form>
            </div>
        </div>
    </body>
</html>
