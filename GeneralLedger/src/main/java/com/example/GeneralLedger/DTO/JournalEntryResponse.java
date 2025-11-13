package com.example.GeneralLedger.DTO;

import com.example.GeneralLedger.Enum.JournalStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class JournalEntryResponse {
    private Long id;
    private String entryNumber;
    private String description;
    private String referenceNumber;
    private JournalStatus status;
    private BigDecimal totalDebit;
    private BigDecimal totalCredit;
    private List<JournalLineDTO> journalLineDTOS;
    private LocalDateTime entryDate;
    private LocalDateTime createdAt;
    private LocalDateTime postedAt;
}
