<%@ page import="grailsblog.SecUser" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Users</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Users</h1>

                <ol class="breadcrumb">
                    <li class="active">
                        <i class="fa fa-user"></i> Users
                    </li>
                </ol>

                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>

                <p>
                    <a href="${ createLink(action: 'create') }" class="btn btn-primary">
                        <i class="fa fa-plus"></i> Create a new user
                    </a>
                </p>

                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>Fullname</th>
                                <th>Email</th>
                                <th>Is Active?</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${secUserInstanceList}" status="i" var="secUserInstance">
                                <tr>
                                    <td>
                                        ${fieldValue(bean: secUserInstance, field: "fullname")}
                                    </td>
                                    <td>
                                        ${fieldValue(bean: secUserInstance, field: "email")}
                                    </td>
                                    <td>
                                        <g:formatBoolean boolean="${secUserInstance.enabled}" true="Yes" false="No" />
                                    </td>
                                    <td>
                                        <g:link action="edit" id="${secUserInstance.id}">
                                            Edit
                                        </g:link>
                                    </td>
                                </tr>
                            </g:each>
                        </tbody>
                    </table>
                </div>

                <div class="pagination">
                    <g:paginate total="${secUserInstanceCount ?: 0}" />
                </div>
            </div>
        </div>
    </body>
</html>
