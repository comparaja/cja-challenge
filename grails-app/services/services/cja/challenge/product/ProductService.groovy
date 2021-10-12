package services.cja.challenge.product

import cja.challenge.Product
import grails.gorm.transactions.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.sql.SQLException

@Transactional
class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    def list(def isActive, def providerId, def connectionTypeId, def sortBy, def sortDirection) {
        try {
            return fetchFromDomain(isActive, providerId, connectionTypeId, sortBy, sortDirection)
        } catch(SQLException e) {
            LOGGER.error(e.message)
        }
    }

    def fetchFromDomain(def isActive, def providerId, def connectionTypeId, def sortBy, def sortDirection) {
        List<?> productList = new ArrayList<>()
        Product.withNewTransaction {
            productList = Product.createCriteria().list {
                if (isActive != null) {
                    or{
                        eq("isActive", (Boolean) isActive)
                        isNull("isActive")
                    }
                }
                if (providerId != null)
                    eq("providerId", Integer.parseInt(providerId))
                if (connectionTypeId != null)
                    eq("connectionTypeId", Integer.parseInt(connectionTypeId))
                if(sortBy != null && sortDirection != null)
                    order(sortBy, sortDirection != null ? sortDirection : "desc")
            }
        }
        return productList
    }
}
