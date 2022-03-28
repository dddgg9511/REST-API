package com.example.restapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors){
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0){
            errors.rejectValue("basePrice", "wrongValue", "bestPrice is wrong");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is wrong");
        }

        if(eventDto.getEndEventDateTime().isBefore(eventDto.getBeginEventDateTime()) ||
        eventDto.getEndEventDateTime().isBefore(eventDto.getCloseEnrollemntDateTime()) ||
        eventDto.getEndEventDateTime().isBefore(eventDto.getBeginEnrollmentDateTime())){
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong");
        }

        //Todo BeginEventDateTime
        //Todo CloseEnrollmentDateTime
        if(eventDto.getCloseEnrollemntDateTime().isBefore(eventDto.getBeginEnrollmentDateTime())){
            errors.rejectValue("closeEnrollmentDateTime", "wrongValue", "closeEnrollmentDateTime is wrong");
        }
    }
}
