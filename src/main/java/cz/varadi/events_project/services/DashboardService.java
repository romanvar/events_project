package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.EventDto;

import java.util.List;

public interface DashboardService {
    public List<EventDto> getMyEvents(String name);
}
