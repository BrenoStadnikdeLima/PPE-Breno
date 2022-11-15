package com.br.times.controller;

import com.br.times.model.Time;
import com.br.times.service.TimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("time")
@CrossOrigin("*")
public class TimeController {
    @Autowired
    TimeServiceImpl timeService;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Time> create(@RequestBody Time time)
        throws URISyntaxException {
            Time createTime = timeService.create(time);
            if (createTime == null) {
                return ResponseEntity.notFound().build();
            }
            else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createTime.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(createTime);
        }
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Time>> findAll() {
        List<Time> todosOsTimes = timeService.findAll();
        if (todosOsTimes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(todosOsTimes);
        }
    }

   @PutMapping(value = "/{id}", produces = "application/json")
   public ResponseEntity<Time> update(@RequestBody Time time, @PathVariable Long id) {
       Time updatedTime = timeService.update(id, time);
       if (updatedTime == null) {
           return ResponseEntity.notFound().build();
       } else {
           return ResponseEntity.ok(updatedTime);
       }
   }
    
    @DeleteMapping(value = "/{id}", produces = "application/json")
    private ResponseEntity<Object> delete(@PathVariable Long id) {
        if (timeService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Optional<Time>> findById(@PathVariable Long id) {
        Optional<Time> foundBlog = timeService.findById(id);
        if (foundBlog.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundBlog);
        }
    }
}
