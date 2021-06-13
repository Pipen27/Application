package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

    private Integer votes;
    private AttachmentsByType attachments;
    private Trello trello;
    private Integer board;
    private Integer card;

    @JsonProperty("trello")
    @SuppressWarnings("unchecked")
    private void trelloDeserializer (Map<String, Object> trello) {
        this.board = (Integer) trello.get(board);
        this.card = (Integer) trello.get(card);
    }

    @JsonProperty("attachmentsByType")
    @SuppressWarnings("unchecked")
    private void attachmentsByTypeDeserializer (Map<String, Object> attachments) {
        this.trello = (Trello) attachments.get(trello);
    }


    @JsonProperty("badges")
    @SuppressWarnings("unchecked")
    private void badgesDeserializer (Map<String, Object> badges) {
        this.votes = (Integer) badges.get(votes);
        this.attachments = (AttachmentsByType) badges.get(attachments);
    }



}
