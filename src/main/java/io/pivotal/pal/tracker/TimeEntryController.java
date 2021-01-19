package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry){

        return ResponseEntity.created(null).body(timeEntryRepository.create(timeEntry));
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(value="id") long id){
        TimeEntry result = timeEntryRepository.find(id);
        if(result == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){

        return ResponseEntity.ok().body(timeEntryRepository.list());
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable(value = "id") long id, @RequestBody TimeEntry timeEntry){
        TimeEntry result = timeEntryRepository.update(id, timeEntry);
        if(result == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") long id){
        timeEntryRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
