<%@ page import="grailsblog.Post" %>
<div class="form-group">
    <label for="title">Title <span class="required-indicator">*</span></label>
    <input type="text" class="form-control" id="title" name="title" placeholder="Enter post title" value="${postInstance?.title}" required="">
</div>

<div class="form-group">
    <label for="content">Content <span class="required-indicator">*</span></label>
    <textarea class="form-control" id="content" name="content" required="required">${postInstance?.content}</textarea>
</div>

<div class="form-group">
    <g:if test="${postInstance.id}">
        <input type="hidden" name="author" value="${postInstance?.author.id}">
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Update post
        </button>
        or
        <a href="${ createLink(controller: 'post', action: 'delete', id: postInstance.id) }" class="btn btn-danger" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
            <i class="fa fa-trash-o"></i> Delete post
        </a>
    </g:if>
    <g:else>
        <input type="hidden" name="author" value="${currentUser.id}">
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-save"></i> Create post
        </button>
    </g:else>
    or
    <a href="${ createLink(controller: 'post', action: 'index') }">Cancel</a>
</div>
