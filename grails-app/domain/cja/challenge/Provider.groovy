package cja.challenge

import javax.persistence.Id

class Provider {

    @Id
    Integer id

    String description

    String name

    Boolean isActive

    Date dateCreated

    String createdBy

    Date dateModified

    String modifiedBy

    static constraints = {
        dateCreated nullable: false
        createdBy nullable: false
    }

    static mapping = {
        id generator: 'sequence', params: [sequence:"seq_provider"]
    }
}
