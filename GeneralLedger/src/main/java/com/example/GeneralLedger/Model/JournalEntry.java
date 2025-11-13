package com.example.GeneralLedger.Model;

import com.example.GeneralLedger.Enum.JournalStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "journal_entries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String entryNumber; // JE-2023-001, JE-2023-002

    @Column(nullable = false)
    private LocalDateTime entryDate;

    @Column(nullable = false)
    private String description;

    private String referenceNumber; // payment_id, transfer_id, invoice_id

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JournalStatus status = JournalStatus.DRAFT;

    @Column(nullable = false)
    private BigDecimal totalDebit = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal totalCredit = BigDecimal.ZERO;

    @OneToMany(mappedBy = "journalEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JournalLine> journalLines = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime postedAt;


}
