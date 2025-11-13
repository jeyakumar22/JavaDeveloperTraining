package com.example.GeneralLedger.Controller;



import com.example.GeneralLedger.DTO.JournalEntryDTO;
import com.example.GeneralLedger.DTO.JournalEntryResponse;
import com.example.GeneralLedger.Enum.JournalStatus;
import com.example.GeneralLedger.Model.JournalEntry;
import com.example.GeneralLedger.Service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService journalService;

    @PostMapping("/entries")
    public ResponseEntity<JournalEntry> createJournalEntry(
            @RequestBody JournalEntryDTO request) {
        JournalEntry entry = journalService.createJournalEntry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(entry);
    }
    @GetMapping("/entries")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        List<JournalEntry> entries = journalService.getAllJournalEntries();
        return ResponseEntity.ok(entries);
    }

    @GetMapping("/entries/{entryId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable Long entryId) {
        JournalEntry entry = journalService.getJournalEntryById(entryId);
        return ResponseEntity.ok(entry);
    }

    @PostMapping("/entries/{entryId}/post")
    public ResponseEntity<JournalEntry> postJournalEntry(@PathVariable Long entryId) {
        JournalEntry entry = journalService.postJournalEntry(entryId);
        return ResponseEntity.ok(entry);
    }

    @GetMapping("/entries/status/{status}")
    public ResponseEntity<List<JournalEntry>> getJournalEntriesByStatus(
            @PathVariable JournalStatus status) {
        List<JournalEntry> entries = journalService.getJournalEntriesByStatus(status);
        return ResponseEntity.ok(entries);
    }
}