package cja.challenge

import javax.persistence.Id

class ConnectionType {

    @Id
    Integer id

    String description

    Boolean isActive

    Date dateCreated

    String createdBy

    Date dateModified

    String modifiedBy

    static constraints = {
        description nullable: false
        dateCreated nullable: false
        createdBy nullable: false
    }

    static mapping = {
        id generator: 'sequence', params: [sequence:"seq_connection_type"]
    }
}
