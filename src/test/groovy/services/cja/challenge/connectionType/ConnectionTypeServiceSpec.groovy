package services.cja.challenge.connectionType

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ConnectionTypeServiceSpec extends Specification implements ServiceUnitTest<ConnectionTypeService>{

    void "test no params is sent to backend service"() {
        setup:
        GroovySpy(ConnectionTypeService, global: true)
        def connectionTypeService = new ConnectionTypeService()
        when:
        connectionTypeService.list(null)

        then:
        thrown Exception
    }
}
