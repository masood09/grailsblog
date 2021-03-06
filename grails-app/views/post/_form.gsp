<%@ page import="grailsblog.Post" %>
<div class="form-group">
    <label for="title">Title <span class="required-indicator">*</span></label>
    <input type="text" class="form-control" id="title" name="title" placeholder="Enter post title" value="${postInstance?.title}" required="">
</div>

<hr>

<div class="form-group">
    <label for="categories">Categories</label>
    <select id="categories" name="categories" multiple data-placeholder="Choose categories" class="chosen-select form-control chosen-create-entry">
        <g:each in="${categories}" status="i" var="category">
        <g:if test="${postInstance.id}">
            <option value="${category.name}" <g:if test="${postInstance.categories.contains(category)}">selected="selected"</g:if>>${category.name}</option>
        </g:if>
        <g:else>
            <option value="${category.name}">${category.name}</option>
        </g:else>
        </g:each>
    </select>
</div>

<div class="form-group">
    <label for="tags">Tags</label>
    <select id="tags" name="tags" multiple data-placeholder="Choose tags" class="chosen-select form-control chosen-create-entry">
        <g:each in="${tags}" status="i" var="tag">
        <g:if test="${postInstance.id}">
            <option value="${tag.name}" <g:if test="${postInstance.tags.contains(tag)}">selected="selected"</g:if>>${tag.name}</option>
        </g:if>
        <g:else>
            <option value="${tag.name}">${tag.name}</option>
        </g:else>
        </g:each>
    </select>
</div>

<hr>
<textarea id="content" name="content" class="tinymce-editor">${postInstance?.content}</textarea>
<hr>

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

<script type="text/javascript">
    jQuery("#categories").chosen({no_results_text: "Hit ENTER to create a new category:"});
    jQuery("#tags").chosen({no_results_text: "Hit ENTER to create a new tag:"});

    tinymce.init({
        selector: "textarea.tinymce-editor",
        height: 400,
        encoding: "raw",
        plugins: [
            "advlist autolink lists link image charmap print preview anchor",
            "searchreplace visualblocks code fullscreen",
            "insertdatetime media table contextmenu paste"
        ],
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
    });
</script>
