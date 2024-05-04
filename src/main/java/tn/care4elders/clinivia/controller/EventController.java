package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import tn.care4elders.clinivia.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.service.EventService;
import tn.care4elders.clinivia.entity.Event;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/events")

public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/Add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event addedEvent = eventService.addEvent(event);
        return new ResponseEntity<>(addedEvent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{IdEvent}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long IdEvent) {
        eventService.deleteEvent(IdEvent);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("get/{IdEvent}")
    public ResponseEntity<Event> getEventById(@PathVariable Long IdEvent) {
        Optional<Event> event = eventService.getEventById(IdEvent);
        return event.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
