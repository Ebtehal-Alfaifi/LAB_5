package com.example.eventsystem.Controller;

import com.example.eventsystem.ApiResponse.Api;
import com.example.eventsystem.Model.EventModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<EventModel> events=new ArrayList<>();


    //display arry list
    @GetMapping("/display")
    public ArrayList<EventModel> getEvents() {
        return events;
    }

    //add
    @PostMapping("/add")
    public Api addEvent(@RequestBody EventModel event) {
        events.add(event);
        return new Api(" add success");
    }


    //update
    @PutMapping("/update/{index}")
    public Api updateEvent(@PathVariable int index, @RequestBody EventModel event){
        events.set(index, event);
        return new Api(" update success");
    }

    //delet
    @DeleteMapping("/delete/{index}")
    public Api deleteEvent(@PathVariable int index){
        events.remove(index);
        return new Api(" delete success");
    }




    //• Change capacity
    @PutMapping("/capacity/{id}/{capacity}")
    public Api changeCapacity(@PathVariable String id, @PathVariable int capacity) {
        for (EventModel event : events) {
            if (event.getId().equals(id)) {
                event.setCapacity(capacity);
                return new Api("Capacity updated successfully");
            }
        }
        return new Api("Event not found");
    }



//search
    @GetMapping("/search/{id}")
    public EventModel searchEvent(@PathVariable String id) {
        for (EventModel event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        throw new RuntimeException("Event not found");
    }
}




