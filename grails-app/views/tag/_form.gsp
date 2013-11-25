<%@ page import="grailsblog.Tag" %>

<div class="form-group">
    <label for="name">Tag Name <span class="required-indicator">*</span></label>
    <input type="text" class="form-control" id="name" name="name" placeholder="Enter tag name" value="${tagInstance?.name}" required="">
</div>

<div class="form-group">
    <g:if test="${tagInstance.id}">
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Update tag
        </button>
        or
        <a href="${ createLink(controller: 'tag', action: 'delete', id: tagInstance.id) }" class="btn btn-danger" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
            <i class="fa fa-trash-o"></i> Delete tag
        </a>
    </g:if>
    <g:else>
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Create tag
        </button>
    </g:else>
    or
    <a href="${ createLink(controller: 'tag', action: 'index') }">Cancel</a>
</div>
