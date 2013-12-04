<%@ page import="grailsblog.Tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Grailsblog - ${tagInstance.name}</title>
    </head>
    <body>
        <g:each in="${tagInstance.getPosts()}" status="i" var="postInstance">
            <article class="post_article">
                <h3 class="post_title">
                    <g:link controller="post" action="show" params="[slug: postInstance.slug]">
                        ${ postInstance.title }
                    </g:link>
                </h3>
                <h6 class="post_date">
                     Posted on <g:formatDate format="MMMMM d, yyyy" date="${ postInstance.dateCreated }" />
                </h6>

                <div class="post_content">
                    ${ raw(postInstance.content) }
                </div>

                <div class="post_meta_info">
                    <p>Posted by: ${ postInstance.author.fullname }</p>
                    <p>
                        Category:
                        <g:each in="${postInstance.getCategories()}" status="cat_i" var="postCategory">
                            <g:link controller="category" action="list" params="[slug: postCategory.slug]">${postCategory.name}</g:link>${ (postInstance.getCategories().size() != (cat_i + 1) ) ? ', ' : ''}
                        </g:each>
                    </p>
                    <p>
                        Tags:
                        <g:each in="${postInstance.getTags()}" status="tag_i" var="postTag">
                            <g:link controller="tag" action="list" params="[slug: postTag.slug]">${postTag.name}</g:link>${ (postInstance.getTags().size() != (tag_i + 1) ) ? ', ' : ''}
                        </g:each>
                    </p>
                </div>
            </article>

            <g:if test="${tagInstance.getPosts().size() != (i+1)}">
                <hr>
                <br>
            </g:if>
        </g:each>

        <g:if test="${tagInstance.getPosts() == 0}">
            <h2>No posts found for the category ${ tagInstance.name }</h2>
        </g:if>
    </body>
</html>
