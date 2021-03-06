package cja.challenge

import grails.converters.JSON
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ConnectionTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionTypeController.class);
    static allowedMethods = [list: "GET"]

    def connectionTypeService
    def list() {
        response.setContentType("application/json")
        try {
            response.status = 200
            render connectionTypeService.list(params.isActive) as JSON
        } catch(Exception e) {
            LOGGER.error(e.message)
            response.status = 500
            render(status: response.status, text: e.message)
        }
    }
}
