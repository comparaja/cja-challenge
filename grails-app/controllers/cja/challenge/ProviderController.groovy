package cja.challenge

import grails.converters.JSON
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ProviderController {

    def providerService
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);
    static allowedMethods = [list: "GET"]

    def list() {
        response.setContentType("application/json")
        try {
            response.status = 200
            render providerService.list(params.isActive) as JSON
        } catch(Exception e) {
            LOGGER.error(e.message)
            response.status = 500
            render(status: response.status, text: e.printStackTrace())
        }
    }
}
