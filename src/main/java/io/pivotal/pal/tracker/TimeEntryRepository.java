package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface TimeEntryRepository {
    @Bean
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long id);
    List<TimeEntry> list();
    TimeEntry update(long id, TimeEntry timeEntry);
    void delete(long id);
}
