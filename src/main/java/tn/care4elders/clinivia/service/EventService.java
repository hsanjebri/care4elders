package tn.care4elders.clinivia.service;
import tn.care4elders.clinivia.entity.Event;
import java.util.Optional;
import java.util.List;

public interface EventService {
    Event addEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(Long eventId);

    Optional<Event> getEventById(Long eventId);

    List<Event> getAllEvents();
}
