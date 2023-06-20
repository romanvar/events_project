package cz.varadi.events_project.controllers;

import cz.varadi.events_project.services.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EventController {
    private final EventServiceImpl eventService;

    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventsListPage(Model model) {
        var events = eventService.getAllEvents();
        model.addAttribute("eventsTempl", events);
        return "events";
    }
}
