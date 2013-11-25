<%@ page import="grailsblog.Post" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin">
        <title>Grailsblog - Categories</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1>Posts</h1>

                <ol class="breadcrumb">
                    <li class="active">
                        <i class="fa fa-files-o"></i> Posts
                    </li>
                </ol>

                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>

                <p>
                    <a href="${ createLink(action: 'create') }" class="btn btn-primary">
                        <i class="fa fa-plus"></i> Create a new post
                    </a>
                </p>

                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                            <tr>
                                <th>Title <i class="fa fa-sort"></i></th>
                                <th>Author <i class="fa fa-sort"></i></th>
                                <th>Slug <i class="fa fa-sort"></i></th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${postInstanceList}" status="i" var="postInstance">
                                <tr>
                                    <td>
                                        <g:link action="edit" id="${postInstance.id}">
                                            ${postInstance.title}
                                        </g:link>
                                    </td>
                                    <td>
                                        ${postInstance.author.fullname}
                                    </td>
                                    <td>
                                        ${postInstance.slug}
                                    </td>
                                </tr>
                            </g:each>
                            <g:unless test="${postInstanceList}">
                                <tr>
                                    <td colspan="3">
                                        <p class="noRecord">No Posts Found!</p>
                                    </td>
                                </tr>
                            </g:unless>
                        </tbody>
                    </table>
                </div>

                <div class="pagination">
                    <g:paginate total="${postInstanceCount ?: 0}" />
                </div>
            </div>
        </div>
    </body>
</html>
