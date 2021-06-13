package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Badges {

//    @JsonProperty
    protected Integer votes;

//    @JsonProperty
    private AttachmentsByType attachments;
}
