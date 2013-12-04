<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><g:layoutTitle default="Grailsblog"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
        <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
        <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

        <link rel="stylesheet" href="${resource(dir: 'css', file: 'normalize.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'foundation.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'frontend.css')}" type="text/css">

        <script src="${resource(dir: 'js', file: 'modernizr.js')}"></script>

        <!--[if lt IE 9]>
            <script src="${resource(dir: 'js', file: 'html5shiv.js')}"></script>
        <![endif]-->

        <script src="${resource(dir: 'js', file: 'jquery-1.10.2.min.js')}"></script>

        <g:layoutHead/>
        <r:layoutResources />
    </head>
    <body>
        <div class="row">
            <div class="large-12 columns">
                <h1 class="title">
                    <g:link controller="post" action="list">
                        GrailsBlog
                    </g:link>
                    <small>An awesome blog written using Grails framework</small></h1>
                <hr>
            </div>
        </div>

        <div class="row">
            <div class="large-9 columns">
                <g:layoutBody/>
            </div>

            <aside class="large-3 columns">
                <h5>Categories</h5>
                <ul class="side-nav">
                    <g:each in="${categories}" status="cat_i" var="category">
                        <g:if test="${ category.getPosts().size() > 0 }">
                            <li>
                                <g:link controller="category" action="list" params="[slug: category.slug]">
                                    ${category.name} (${ category.getPosts().size() })
                                </g:link>
                            </li>
                        </g:if>
                    </g:each>
                </ul>

                <hr>

                <h5>Tags</h5>
                <ul class="side-nav">
                    <g:each in="${tags}" status="tag_i" var="tag">
                        <g:if test="${ tag.getPosts().size() > 0 }">
                            <li>
                                <g:link controller="tag" action="list" params="[slug: tag.slug]">
                                    ${tag.name} (${ tag.getPosts().size() })
                                </g:link>
                            </li>
                        </g:if>
                    </g:each>
                </ul>
            </aside>
        </div>

        <footer class="row">
            <div class="large-12 columns">
                <hr>

                <p>&copy; Copyright 2013 Masood Ahmed. All rights reserved.</p>
            </div>
        </footer>

        <g:javascript library="application"/>

        <script src="${resource(dir: 'js', file: 'foundation.min.js')}"></script>

        <script type="text/javascript">
            $(document).foundation();
        </script>

        <r:layoutResources />
    </body>
</html>
