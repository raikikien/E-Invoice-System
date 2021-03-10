package com.project.invoice.service;


import com.project.invoice.entity.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.invoice.repository.InvoiceRepository;

@Service
@Slf4j
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) {
        log.info("Inside saveInvoice method of InvoiceController");
        return invoiceRepository.save(invoice);
    }

    public Invoice findInvoiceById(Long id) {
        log.info("Inside findInvoiceById method of InvoiceController");
        return invoiceRepository.findInvoiceById(id);
    }
}

