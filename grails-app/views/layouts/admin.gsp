<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><g:layoutTitle default="Grails"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
        <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
        <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'sb-admin.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'font-awesome/css', file: 'font-awesome.min.css')}" type="text/css">

        <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css" type="text/css">

        <g:layoutHead/>
        <r:layoutResources />

        <script src="${resource(dir: 'js', file: 'jquery-1.10.2.js')}"></script>
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">GrailsBlog</a>
                </div>

                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="#">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-dashboard"></i> Posts
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-dashboard"></i> Categories
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-dashboard"></i> Tags
                            </a>
                        </li>
                        <li>
                            <g:link controller="SecUser" action="index">
                                <i class="fa fa-user"></i> Users
                            </g:link>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-dashboard"></i> Settings
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <li class="dropdown user-dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <sec:loggedInUserInfo field="username"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">
                                        <i class="fa fa-user"></i> Profile
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <g:link controller="logout" action="index">
                                        <i class="fa fa-power-off"></i> Log Out
                                    </g:link>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>

            <div id="page-wrapper">
                <g:layoutBody/>
            </div>
        </div>

        <g:javascript library="application"/>

        <script src="${resource(dir: 'js', file: 'bootstrap.js')}"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
        <script src="${resource(dir: 'js/morris', file: 'chart-data-morris.js')}"></script>
        <script src="${resource(dir: 'js/tablesorter', file: 'jquery.tablesorter.js')}"></script>
        <script src="${resource(dir: 'js/tablesorter', file: 'tables.js')}"></script>

        <r:layoutResources />
    </body>
</html>