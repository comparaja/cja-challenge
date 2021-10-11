package services.cja.challenge.product

import cja.challenge.Product
import grails.gorm.transactions.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.sql.SQLException

@Transactional
class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    def list(def request) {
        if(request == null)
            throw new IllegalArgumentException("no request found!")
        try {
            return fetchFromDomain(request)
        } catch(SQLException e) {
            LOGGER.error(e.message)
        }
    }

    def fetchFromDomain(def request) {
        List<?> productList = new ArrayList<>()
        Product.withNewTransaction {
            productList = Product.createCriteria().list {
                if (request.isActive)
                    eq("isActive", request.isActive)
                if (request.providerId)
                    eq("providerId", request.providerId)
                if (request.connectionTypeId)
                    eq("connectionTypeId", request.connectionTypeId)
                if(request.sort != null && request.sort.fieldSort != null)
                    order(request.sort.fieldSort, request.sort.direction != null ? request.sort.direction : "desc")
            }
        }
        return productList
    }
}
