package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Trello {

    @JsonProperty("board")
    private Integer board;

    @JsonProperty("card")
    private Integer card;
}
