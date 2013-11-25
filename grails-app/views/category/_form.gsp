<%@ page import="grailsblog.Category" %>

<div class="form-group">
    <label for="name">Category Name <span class="required-indicator">*</span></label>
    <input type="text" class="form-control" id="name" name="name" placeholder="Enter category name" value="${categoryInstance?.name}" required="">
</div>

<div class="form-group">
    <g:if test="${categoryInstance.id}">
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Update category
        </button>
        or
        <a href="${ createLink(controller: 'category', action: 'delete', id: categoryInstance.id) }" class="btn btn-danger" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
            <i class="fa fa-trash-o"></i> Delete category
        </a>
    </g:if>
    <g:else>
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Create category
        </button>
    </g:else>
    or
    <a href="${ createLink(controller: 'category', action: 'index') }">Cancel</a>
</div>
