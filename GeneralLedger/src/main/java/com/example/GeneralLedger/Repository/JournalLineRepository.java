package com.example.GeneralLedger.Repository;

import com.example.GeneralLedger.Model.JournalLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JournalLineRepository extends JpaRepository<JournalLine , Long> {
    @Query("SELECT COALESCE(MAX(jl.transactionId), 0) FROM JournalLine jl")
    Long findMaxTransactionId();

}
