package com.example.GeneralLedger.Repository;


import com.example.GeneralLedger.Enum.JournalStatus;
import com.example.GeneralLedger.Model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<JournalEntry, Long> {
    List<JournalEntry> findAllByOrderByEntryDateDesc();

    List<JournalEntry> findByStatusOrderByEntryDateDesc(JournalStatus status);
}
