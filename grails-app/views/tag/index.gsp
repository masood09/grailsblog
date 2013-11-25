<%@ page import="grailsblog.Tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Tags</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Tags</h1>

                <ol class="breadcrumb">
                    <li class="active">
                        <i class="fa fa-list-ul"></i> Tags
                    </li>
                </ol>

                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>

                <p>
                    <a href="${ createLink(action: 'create') }" class="btn btn-primary">
                        <i class="fa fa-plus"></i> Create a new tag
                    </a>
                </p>

                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                            <tr>
                                <th>Tag Name <i class="fa fa-sort"></i></th>
                                <th>Slug <i class="fa fa-sort"></i></th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${tagInstanceList}" status="i" var="tagInstance">
                                <tr>
                                    <td>
                                        <g:link action="edit" id="${tagInstance.id}">
                                            ${tagInstance.name}
                                        </g:link>
                                    </td>
                                    <td>
                                        ${tagInstance.slug}
                                    </td>
                                </tr>
                            </g:each>
                            <g:unless test="${tagInstanceList}">
                                <tr>
                                    <td colspan="2">
                                        <p class="noRecord">No Tags Found!</p>
                                    </td>
                                </tr>
                            </g:unless>
                        </tbody>
                    </table>
                </div>

                <div class="pagination">
                    <g:paginate total="${tagInstanceCount ?: 0}" />
                </div>
            </div>
        </div>
    </body>
</html>
