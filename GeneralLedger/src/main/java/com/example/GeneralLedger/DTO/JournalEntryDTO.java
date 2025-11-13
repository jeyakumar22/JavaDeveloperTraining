package com.example.GeneralLedger.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class JournalEntryDTO {
    private LocalDateTime entryDate;
    private String description;
    private String referenceNumber;
    private List<JournalLineDTO> journalLineDTOS;
}

