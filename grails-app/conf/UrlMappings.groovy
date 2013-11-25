class UrlMappings {

    static mappings = {
        "/admin/users"(controller: "SecUser", action: "index")
        "/admin/users"(resources: 'secUser', excludes: ['show'])

        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
