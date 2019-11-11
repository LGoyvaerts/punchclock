package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.CheckOutBeforeCheckinException;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    // Get all entries
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    // Create Entry
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        Entry createdEntry = entryService.createEntry(entry);
        // If checkOut before checkIn --> createdEntry == null
        if (createdEntry != null) {
            return entry;
        }
        throw new CheckOutBeforeCheckinException();
    }

    // Update Entry
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Entry updateEntry(@Valid @RequestBody Entry entry) {
        Entry updatedEntry = entryService.updateEntry(entry);
        // If checkOut before checkIn --> updatedentry == null
        if (updatedEntry != null) {
            return updatedEntry;
        }
        throw new CheckOutBeforeCheckinException();
    }

    // Delete Entry
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@Valid @RequestBody Long id) {
        entryService.deleteEntryById(id);
    }
}
