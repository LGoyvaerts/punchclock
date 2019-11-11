package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    private EntryRepository entryRepository;

    // Constructor for Injection
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        if (!entry.getCheckOut().isBefore(entry.getCheckIn())) {
            return entryRepository.saveAndFlush(entry);
        }
        return null;
    }

    public Entry updateEntry(Entry entry) {
        Optional<Entry> entryToEdit = entryRepository.findById(entry.getId());
        Entry newEntry;
        if (entryToEdit.isPresent()) {
            newEntry = entryToEdit.get();
            newEntry.setId(entry.getId());
            newEntry.setCheckIn(entry.getCheckIn());
            newEntry.setCheckOut(entry.getCheckOut());
            return entryRepository.saveAndFlush(newEntry);
        }
        return null;
    }

    public void deleteEntryById(Long id) {
        entryRepository.deleteById(id);
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }
}
