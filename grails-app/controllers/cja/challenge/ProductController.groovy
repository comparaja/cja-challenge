package cja.challenge

import grails.converters.JSON
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ProductController {

    def productService
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    static allowedMethods = [list: "GET"]

    def list() {
        response.setContentType("application/json")
        try {
            response.status = 200
            render productService.list(params.isActive, params.providerId, params.connectionTypeId, params.sortBy, params.sortDirection) as JSON
        } catch(Exception e) {
            LOGGER.error(e.message)
            response.status = 500
            render(status: response.status, text: e.printStackTrace())
        }

    }
}
