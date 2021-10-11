package services.productService

import grails.testing.services.ServiceUnitTest
import services.cja.challenge.product.ProductService
import spock.lang.Specification

class ProductServiceSpec extends Specification implements ServiceUnitTest<ProductService>{

    void "test no params is sent to backend service"() {
        setup:
        GroovySpy(ProductService, global: true)
        def productService = new ProductService()
        when:
        productService.list(null)

        then:
        thrown Exception
    }
}
