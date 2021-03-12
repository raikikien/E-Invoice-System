package com.project.invoice.controller;


import com.project.invoice.entity.Invoice;
import com.project.invoice.repository.InvoiceRepository;
import com.project.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @GetMapping("/searchMonth/{month}")
    public List<Invoice> findAllInvoicesByMonthly(@PathVariable("month") int month){
        return invoiceService.findAllByMonth(month);
    }
    @GetMapping("/searchYear/{year}")
    public List<Invoice> findAllInvoicesByYearly(@PathVariable("year") int year){
        return invoiceService.findAllByYear(year);
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    public ResponseEntity<List<Invoice>> getAllInvoices(@RequestParam(required = false) String type) {
        try {
            List<Invoice> invoices = new ArrayList<Invoice>();

            if (type == null)
                invoiceService.findAll().forEach(invoices::add);

            if (invoices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            invoiceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

