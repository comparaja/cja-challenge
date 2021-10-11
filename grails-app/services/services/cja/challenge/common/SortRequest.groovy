package services.cja.challenge.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class SortRequest {

    @JsonProperty
    String direction

    @JsonProperty
    String fieldSort
}
