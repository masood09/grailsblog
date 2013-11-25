<%@ page import="grailsblog.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Categories</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Categories</h1>

                <ol class="breadcrumb">
                    <li class="active">
                        <i class="fa fa-list-ul"></i> Categories
                    </li>
                </ol>

                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>

                <p>
                    <a href="${ createLink(action: 'create') }" class="btn btn-primary">
                        <i class="fa fa-plus"></i> Create a new category
                    </a>
                </p>

                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                            <tr>
                                <th>Category Name <i class="fa fa-sort"></i></th>
                                <th>Slug <i class="fa fa-sort"></i></th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${categoryInstanceList}" status="i" var="categoryInstance">
                                <tr>
                                    <td>
                                        <g:link action="edit" id="${categoryInstance.id}">
                                            ${categoryInstance.name}
                                        </g:link>
                                    </td>
                                    <td>
                                        ${categoryInstance.slug}
                                    </td>
                                </tr>
                            </g:each>
                            <g:unless test="${categoryInstanceList}">
                                <tr>
                                    <td colspan="2">
                                        <p class="noRecord">No Categories Found!</p>
                                    </td>
                                </tr>
                            </g:unless>
                        </tbody>
                    </table>
                </div>

                <div class="pagination">
                    <g:paginate total="${categoryInstanceCount ?: 0}" />
                </div>
            </div>
        </div>
    </body>
</html>
