package com.example.GeneralLedger.Service;


import com.example.GeneralLedger.DTO.JournalEntryDTO;
import com.example.GeneralLedger.DTO.JournalEntryResponse;
import com.example.GeneralLedger.DTO.JournalLineDTO;
import com.example.GeneralLedger.Enum.JournalStatus;

import com.example.GeneralLedger.Model.Account;
import com.example.GeneralLedger.Model.JournalEntry;


import com.example.GeneralLedger.Model.JournalLine;
import com.example.GeneralLedger.Repository.AccountRepository;
import com.example.GeneralLedger.Repository.JournalLineRepository;
import com.example.GeneralLedger.Repository.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalService {

    private final JournalRepository journalRepository;
    private final AccountRepository accountRepository;
    private final JournalLineRepository journalLineRepository;

    public JournalEntry createJournalEntry(JournalEntryDTO request) {

        if (request.getJournalLineDTOS() == null || request.getJournalLineDTOS().isEmpty()) {
            throw new RuntimeException("Journal entry must have at least one line");
        }


        BigDecimal totalDebit = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;

        for (JournalLineDTO line : request.getJournalLineDTOS()) {
            totalDebit = totalDebit.add(line.getDebit());
            totalCredit = totalCredit.add(line.getCredit());
        }

        if (totalDebit.compareTo(totalCredit) != 0) {
            throw new RuntimeException("Total debit and credit must be equal");
        }

        JournalEntry entry = new JournalEntry();
        entry.setEntryNumber(generateEntryNumber());
        entry.setEntryDate(request.getEntryDate());
        entry.setDescription(request.getDescription());
        entry.setReferenceNumber(request.getReferenceNumber());
        entry.setStatus(JournalStatus.DRAFT);
        entry.setTotalDebit(totalDebit);
        entry.setTotalCredit(totalCredit);

        JournalEntry savedEntry = journalRepository.save(entry);
        Long nextTransactionId = getNextTransactionId();
        for (JournalLineDTO lineDTO : request.getJournalLineDTOS()) {
            // FIX: Use accountCode instead of account ID
            Account account = accountRepository.findByAccountCode(lineDTO.getAccountCode())
                    .orElseThrow(() -> new RuntimeException("Account not found with code: " + lineDTO.getAccountCode()));

            JournalLine line = new JournalLine();
            line.setJournalEntry(savedEntry);
            line.setAccount(account);
            line.setDebit(lineDTO.getDebit());
            line.setCredit(lineDTO.getCredit());
            line.setTransactionId(nextTransactionId);
            line.setDescription(lineDTO.getDescription());

            journalLineRepository.save(line);
        }

        return savedEntry;

    }

    private Long getNextTransactionId() {

        return journalLineRepository.findMaxTransactionId();
    }

    private String generateEntryNumber() {
        long count = journalRepository.count() + 1;
        return "JE-" + LocalDate.now().getYear() + "-" + String.format("%04d", count);
    }


    public List<JournalEntry> getAllJournalEntries() {
        return journalRepository.findAllByOrderByEntryDateDesc();
    }


    public JournalEntry getJournalEntryById(Long entryId) {
        Optional<JournalEntry> entryOptional = journalRepository.findById(entryId);

        if (entryOptional.isEmpty()) {
            throw new RuntimeException("Journal entry not found with id: " + entryId);
        }

        return entryOptional.get();
    }


    public JournalEntry postJournalEntry(Long entryId) {
        Optional<JournalEntry> entryOptional = journalRepository.findById(entryId);

        if (entryOptional.isEmpty()) {
            throw new RuntimeException("Journal entry not found with id: " + entryId);
        }

        JournalEntry entry = entryOptional.get();

        if (entry.getStatus() != JournalStatus.DRAFT) {
            throw new RuntimeException("Only DRAFT entries can be posted");
        }

        entry.setStatus(JournalStatus.POSTED);
        entry.setPostedAt(LocalDateTime.now());

        return journalRepository.save(entry);
    }


    public List<JournalEntry> getJournalEntriesByStatus(JournalStatus status) {
        return journalRepository.findByStatusOrderByEntryDateDesc(status);
    }

}


