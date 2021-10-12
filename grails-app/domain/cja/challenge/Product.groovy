package cja.challenge

import javax.persistence.Id

class Product {

    @Id
    Integer id

    Integer providerId

    String description

    Integer connectionTypeId

    Integer numberOfChannels

    Integer internetSpeed

    Double monthlyPrice

    Date dateCreated

    String createdBy

    Date dateModified

    String modifiedBy

    Boolean isActive

    static constraints = {
        providerId nullable: false
        monthlyPrice nullable: false
        dateCreated nullable: false
        createdBy nullable: false
        isActive nullable: true
    }

    static mapping = {
        id generator: 'sequence', params: [sequence:"seq_product"]
    }

}
