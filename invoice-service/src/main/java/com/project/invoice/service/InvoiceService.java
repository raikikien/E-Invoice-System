package com.project.invoice.service;


import com.project.invoice.entity.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.invoice.repository.InvoiceRepository;

import java.util.List;

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

    public List<Invoice> findAll() {
        log.info("Inside listAll method of InvoiceController");
        return invoiceRepository.findAll();
    }
    public void deleteById(long id) {
        log.info("Inside delete method of InvoiceController");
        invoiceRepository.deleteById(id);
    }

    public List<Invoice> findByType(String type) {
        return invoiceRepository.findByType(type);
    }
}

