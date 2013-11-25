<%@ page import="grailsblog.SecUser" %>
<div class="form-group">
    <label for="firstname">Firstname <span class="required-indicator">*</span></label>
    <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter firstname" value="${secUserInstance?.firstname}" required="">
</div>

<div class="form-group">
    <label for="lastname">Lastname <span class="required-indicator">*</span></label>
    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter lastname" value="${secUserInstance?.lastname}" required="">
</div>

<div class="form-group">
    <label for="email">Email <span class="required-indicator">*</span></label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email address" value="${secUserInstance?.email}" required="">
</div>

<g:if test="${secUserInstance.id}">
    <div class="form-group">
        <label for="enabled">
            Is Enabled
            <g:checkBox name="enabled" value="${secUserInstance?.enabled}" />
        </label>
    </div>

    <div  class="form-group">
        <label for="changepass">
            Change Password
            <input id="changepass" type="checkbox">
        </label>
    </div>

    <div id="passwordFormGroup" class="form-group" style="display:none;">
        <label for="password">Password <span class="required-indicator">*</span></label>
        <input type="password" class="form-control" id="password" name="changepass" placeholder="Enter the password" value="">
    </div>
</g:if>
<g:else>
    <div class="form-group">
        <label for="password">Password <span class="required-indicator">*</span></label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" value="" required="">
    </div>
</g:else>

<div class="form-group">
    <g:if test="${secUserInstance.id}">
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Update user
        </button>
        or
        <a href="${ createLink(controller: 'secUser', action: 'delete', id: secUserInstance.id) }" class="btn btn-danger" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
            <i class="fa fa-trash-o"></i> Delete user
        </a>
    </g:if>
    <g:else>
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Create user
        </button>
    </g:else>
    or
    <a href="${ createLink(controller: 'secUser', action: 'index') }">Cancel</a>
</div>


<g:if test="${secUserInstance.id}">
    <script type="text/javascript">
        jQuery(document).ready(function() {
            jQuery('#changepass').change(function() {
                if (jQuery(this).is(':checked')) {
                    jQuery('#passwordFormGroup').show();
                    jQuery('#password').attr('name', 'password');
                    jQuery('#password').attr('required', 'required');
                } else {
                    jQuery('#passwordFormGroup').hide();
                    jQuery('#password').attr('name', 'changepass');
                    jQuery('#password').removeAttr('required');
                }
            });
        });
    </script>
</g:if>
