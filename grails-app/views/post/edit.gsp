<%@ page import="grailsblog.Post" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Edit post ${postInstance.title}</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Edit user ${postInstance.title}</h1>

                <ol class="breadcrumb">
                    <li>
                        <g:link class="list" action="index">
                            <i class="fa fa-files-o"></i> Posts
                        </g:link>
                    </li>
                    <li class="active">
                        Edit user ${postInstance.title}
                    </li>
                </ol>

                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>

                <g:hasErrors bean="${postInstance}">
                    <g:eachError bean="${postInstance}" var="error">
                        <div class="alert alert-danger" <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                            <g:message error="${error}"/>
                        </div>
                    </g:eachError>
                </g:hasErrors>

                <g:form url="[resource:postInstance, action:'update']" method="PUT" >
                    <g:render template="form"/>
                </g:form>
            </div>
        </div>
    </body>
</html>