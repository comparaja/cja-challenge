package cja.challenge

import grails.converters.JSON
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import services.cja.challenge.common.ListRequest

class ProductController {

    def productService
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    def list(ListRequest listRequest) {
        response.setContentType("application/json")
        try {
            response.status = 200
            render productService.fetchFromDomain(listRequest) as JSON
        } catch(Exception e) {
            LOGGER.error(e.message)
            response.status = 500
            render(status: response.status, text: e.printStackTrace())
        }

    }
}
