package services.cja.challenge.connectionType

import cja.challenge.ConnectionType
import grails.gorm.transactions.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.sql.SQLException

@Transactional
class ConnectionTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionTypeService.class);

    def list(def isActive) {
        try {
            def active = (Boolean) isActive
            return fetchFromDomain(active)
        } catch(SQLException e) {
            LOGGER.error(e.message)
        }
    }

    def fetchFromDomain(def isActive) {
        List<?> connectionTypeList = new ArrayList<>()
        ConnectionType.withNewTransaction {
            connectionTypeList = ConnectionType.createCriteria().list {
                eq("isActive", isActive)
            }
        }
        return connectionTypeList
    }
}
