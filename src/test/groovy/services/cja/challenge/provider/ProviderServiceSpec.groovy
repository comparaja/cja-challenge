package services.cja.challenge.provider

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ProviderServiceSpec extends Specification implements ServiceUnitTest<ProviderService>{

    void "test no params is sent to backend service"() {
        setup:
        GroovySpy(ProviderService, global: true)
        def providerService = new ProviderService()
        when:
        providerService.list(null)

        then:
        thrown Exception
    }
}
