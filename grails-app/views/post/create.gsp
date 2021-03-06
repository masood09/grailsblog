<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Create a new post</title>

        <link rel="stylesheet" href="${resource(dir: 'css', file: 'chosen.css')}" type="text/css">

        <script type="text/javascript" src="${resource(dir: 'js/tinymce/', file: 'tinymce.min.js')}"></script>
        <script src="${resource(dir: 'js', file: 'chosen.jquery.js')}"></script>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Create a new post</h1>

                <ol class="breadcrumb">
                    <li>
                        <g:link class="list" action="index">
                            <i class="fa fa-files-o"></i> Posts
                        </g:link>
                    </li>
                    <li class="active">
                        Create a new post
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

                <g:form url="[resource:postInstance, action:'save']" >
                    <g:render template="form"/>
                </g:form>
            </div>
        </div>
    </body>
</html>
