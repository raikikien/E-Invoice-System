package com.project.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.invoice.entity.Invoice;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findInvoiceById(Long id);
}
