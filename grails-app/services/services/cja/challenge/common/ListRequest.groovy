package services.cja.challenge.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ListRequest {

    @JsonProperty
    Integer providerId

    @JsonProperty
    Integer connectionType

    @JsonProperty
    Double monthlyPrice

    @JsonProperty
    SortRequest sortRequest


}
