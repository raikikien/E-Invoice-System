package com.project.invoice.controller;


import com.project.invoice.entity.Invoice;
import com.project.invoice.repository.InvoiceRepository;
import com.project.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@RequestMapping("/invoices")
@Slf4j
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/")
    public Invoice saveInvoice(@RequestBody Invoice invoice) {
        logger.info("Inside saveInvoice method of InvoiceController");
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/{id}")
    public Invoice findInvoiceById(@PathVariable("id") Long id) {
        logger.info("Inside findInvoiceById method of InvoiceController");
        return invoiceService.findInvoiceById(id);
    }

 /*   @GetMapping("/all")
    public @ResponseBody Iterable < Invoice > getAllInvoices() {
        return InvoiceRepository.saveAll();
    }*/
    
}

