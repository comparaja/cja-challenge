package cja.challenge

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/api/v1/products/list"(controller: "product", action: "list")
        "/api/v1/provider/list"(controller: "provider", action: "list")
        "/api/v1/connectionType/list"(controller: "connectionType", action: "list")

    }
}
