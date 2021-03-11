package com.project.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.invoice.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findInvoiceById(Long id);
   // List<Invoice> findByType(String type);
}
