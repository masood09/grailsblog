<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="blank">
        <title>Grailsblog - Login</title>
    </head>

    <body>
        <div id="login-block" class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4">
                    <h3>Login</h3>
                    <div class="login-box clearfix">
                        <div class="login-logo">
                            <a href="#">
                                <img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/>
                            </a>
                        </div>
                        <hr>
                        <div class="login-form">
                            <g:if test='${flash.message}'>
                                <div class="alert alert-error">
                                    ${flash.message}
                                </div>
                            </g:if>
                            <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                                <input type='email' class='text_' name='j_username' id='username' required="" placeholder="Enter your email address">
                                <input type='password' class='text_' name='j_password' id='password' required="" placeholder="Enter your password">
                                <button class="btn btn-red" type="submit">Login</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
