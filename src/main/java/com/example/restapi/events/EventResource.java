package com.example.restapi.events;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import java.util.Arrays;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class EventResource extends EntityModel<Event> {
    public EventResource(Event event, Link... links){
       super(event,(Iterable) Arrays.asList());
       add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }

}
