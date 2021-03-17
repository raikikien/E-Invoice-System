package com.project.invoice.controller;


import com.project.invoice.entity.Invoice;
import com.project.invoice.repository.InvoiceRepository;
import com.project.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@Slf4j
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/invoices/new")
    public Invoice saveInvoice(@RequestBody Invoice invoice) {

        return invoiceService.saveInvoice(invoice);
    }

    @PutMapping("/invoices/update/{id}")
    public ResponseEntity<Invoice> updateTutorial(@PathVariable("id") Long id, @RequestBody Invoice invoice) {
        Optional<Invoice> invoiceData = Optional.ofNullable(invoiceService.findInvoiceById(id));

        if (invoiceData.isPresent()) {
            Invoice _tutorial = invoiceData.get();
            _tutorial.setType(invoice.getType());
            _tutorial.setMoney(invoice.getMoney());
            _tutorial.setVat(invoice.getVat());
            _tutorial.setChargeperiod(invoice.getChargeperiod());
            return new ResponseEntity<>(invoiceService.saveInvoice(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/invoices/{id}")
    public Invoice findInvoiceById(@PathVariable("id") Long id) {
        return invoiceService.findInvoiceById(id);
    }

    @GetMapping("/invoices/searchMonthly/{year}/{month}")
    public List<Invoice> findAllInvoicesByMonthly(@PathVariable("year") int year,@PathVariable("month") int month){
        return invoiceService.findAllByMonth(year,month);
    }
    @GetMapping("/invoices/searchYearly/{year}")
    public List<Invoice> findAllInvoicesByYearly(@PathVariable("year") int year){
        return invoiceService.findAllByYear(year);
    }
    @GetMapping("/invoices/searchDatePeriod")
    public List<Invoice> findAllByPeriodDate(@RequestParam("start") Date searchDateBegin,
                                             @RequestParam("end") Date searchDateEnd){
        return invoiceService.findAllByPeriodDate(searchDateBegin, searchDateEnd);
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        try {
            List<Invoice> invoices =  invoiceService.findAll();

            if (invoices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @GetMapping("/users/{userId}/invoices")
    public ResponseEntity<List<Invoice>> getInvoicesByUserId(@PathVariable("userId") Long userId){
        try {
            List<Invoice> invoices =  invoiceService.findInvoiceByUserId(userId);

            if (invoices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            invoiceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

