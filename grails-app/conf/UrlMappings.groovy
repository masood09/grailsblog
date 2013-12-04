class UrlMappings {

    static mappings = {
        "/admin/users"(controller: "SecUser", action: "index")
        "/admin/users"(resources: "secUser", excludes: ["index", "show"])
        "/admin/category"(controller: "category", action: "index")
        "/admin/category"(resources: "category", excludes: ["index", "show"])
        "/admin/tags"(controller: "tag", action: "index")
        "/admin/tags"(resources: "tag", excludes: ["index", "show"])
        "/admin/posts"(controller: "post", action: "index")
        "/admin/posts"(resources: "post", excludes: ["index", "show"])

        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "post", action: "list")
        "/posts"(controller: "post", action: "list")
        "/posts/$slug"(controller: "post", action: "show")

        "/category/$slug"(controller: "category", action: "list")
        "/tag/$slug"(controller: "tag", action: "list")

        "500"(view:'/error')
        "/admin"(controller: "post", action: "index")
    }
}
