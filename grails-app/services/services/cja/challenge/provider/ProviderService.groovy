package services.cja.challenge.provider

import cja.challenge.Provider
import grails.gorm.transactions.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.sql.SQLException

@Transactional
class ProviderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderService.class);

    def list(def isActive) {
        try {
           return fetchFromDomain(isActive)
        } catch(SQLException e) {
            LOGGER.error(e.message)
        }
    }

    def fetchFromDomain(def isActive) {
        List<?> providerList = new ArrayList<>()
        Provider.withNewTransaction {
            providerList = Provider.createCriteria().list {
                eq("isActive", isActive)
            }
        }
        return providerList
    }
}
