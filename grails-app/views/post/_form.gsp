<%@ page import="grailsblog.Post" %>
<div class="form-group">
    <label for="title">Title <span class="required-indicator">*</span></label>
    <input type="text" class="form-control" id="title" name="title" placeholder="Enter post title" value="${postInstance?.title}" required="">
</div>

<div class="form-group">
    <label for="content">Content <span class="required-indicator">*</span></label>
    <textarea class="form-control hide" id="content" name="content" required="required">${postInstance?.content}</textarea>

    <div id="epiceditor"></div>
</div>

<div class="form-group">
    <label for="categories">Categories</label>
    <select id="categories" name="categories" multiple data-placeholder="Choose categories" class="chosen-select form-control">
        <g:each in="${categories}" status="i" var="category">
        <g:if test="${postInstance.id}">
            <option value="${category.id}" <g:if test="${postInstance.categories.contains(category)}">selected="selected"</g:if>>${category.name}</option>
        </g:if>
        <g:else>
            <option value="${category.id}">${category.name}</option>
        </g:else>
        </g:each>
    </select>
</div>

<div class="form-group">
    <label for="tags">Tags</label>
    <select id="tags" name="tags" multiple data-placeholder="Choose tags" class="chosen-select form-control">
        <g:each in="${tags}" status="i" var="tag">
        <g:if test="${postInstance.id}">
            <option value="${tag.id}" <g:if test="${postInstance.tags.contains(tag)}">selected="selected"</g:if>>${tag.name}</option>
        </g:if>
        <g:else>
            <option value="${tag.id}">${tag.name}</option>
        </g:else>
        </g:each>
    </select>
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

<script type="text/javascript">
    var opts = {
        container: 'epiceditor',
        textarea: 'content',
        basePath: "${resource(dir: 'css/epiceditor')}",
        clientSideStorage: false,
        useNativeFullscreen: true,
        file: {
            name: 'epiceditor',
            defaultContent: '',
            autoSave: 100
        },
        theme: {
            base: '/themes/base/epiceditor.css',
            preview: '/themes/preview/github.css',
            editor: '/themes/editor/epic-dark.css'
        },
        button: {
            preview: true,
            fullscreen: true,
            bar: "auto"
        },
        focusOnLoad: false,
        shortcut: {
            modifier: 18,
            fullscreen: 70,
            preview: 80
        },
        string: {
            togglePreview: 'Toggle Preview Mode',
            toggleEdit: 'Toggle Edit Mode',
            toggleFullscreen: 'Enter Fullscreen'
        },
        autogrow: {
            minHeight: 200
        }
    }

    var editor = new EpicEditor(opts).load();
    jQuery(".chosen-select").chosen();
</script>
