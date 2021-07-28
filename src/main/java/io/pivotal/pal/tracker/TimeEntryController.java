package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
    return new ResponseEntity<>(timeEntryRepository.create(timeEntryToCreate),HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        return new ResponseEntity<>(timeEntryRepository.find(timeEntryId),HttpStatus.OK);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PostMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> update(long timeEntryId, TimeEntry timeEntryToUpdate) {
        return new ResponseEntity<>(timeEntryRepository.update(timeEntryId,timeEntryToUpdate),HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<Void> delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
