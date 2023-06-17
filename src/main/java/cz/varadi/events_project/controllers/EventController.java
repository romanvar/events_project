package cz.varadi.events_project.controllers;

import cz.varadi.events_project.services.EventService;
import cz.varadi.events_project.services.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class EventController {
    private final EventServiceImpl eventService;

    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventsListPage(Model model){
        var events = eventService.getAllEvents();
        return "events";
    }
}
