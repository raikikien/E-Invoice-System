package com.project.invoice.controller;


import com.project.invoice.entity.Invoice;
import com.project.invoice.repository.InvoiceRepository;
import com.project.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class InvoiceController {
    Logger LOG = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/invoices/new")
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
        if (invoiceService.findDuplicateInvoice(invoice).isEmpty()) {
            return new ResponseEntity<Invoice>(invoiceService.saveInvoice(invoice), HttpStatus.OK);
        } else {
            return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/invoices/update/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") Long id, @RequestBody Invoice invoice) {
        Optional<Invoice> invoiceData = Optional.ofNullable(invoiceService.findInvoiceById(id));

        if (invoiceData.isPresent() && invoiceService.findDuplicateInvoice(invoice).isEmpty() ) {
            Invoice _invoice = invoiceData.get();
            _invoice.setTypename(invoice.getTypename());
            _invoice.setMoney(invoice.getMoney());
            _invoice.setVat(invoice.getVat());
            _invoice.setChargeperiod(invoice.getChargeperiod());
            _invoice.setTotalmoney(invoice.getTotalmoney());
            return new ResponseEntity<>(invoiceService.saveInvoice(_invoice), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/invoices/find/{id}")
    public Invoice findInvoiceById(@PathVariable("id") Long id) {
        Invoice invoice = invoiceService.findInvoiceById(id);
        return invoice;
    }

    @GetMapping("/invoices/searchMonthly/{year}/{month}")
    public List<Invoice> findAllInvoicesByMonthly(@PathVariable("year") int year,@PathVariable("month") int month){
        return invoiceService.findAllByMonth(year,month);
    }
    @GetMapping("/invoices/searchYearly/{year}")
    public List<Invoice> findAllInvoicesByYearly(@PathVariable("year") int year){
        return invoiceService.findAllByYear(year);
    }
    @GetMapping("/invoices/searchDatePeriod") // example to test: ("/invoices/searchDatePeriod?start=2021/04/01&end=2021/04/30")
    public List<Invoice> findAllByPeriodDate(@RequestParam("start") Date searchDateBegin,
                                             @RequestParam("end") Date searchDateEnd){
        return invoiceService.findAllByPeriodDate(searchDateBegin, searchDateEnd);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/invoices/all")
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

    @GetMapping("/invoices/monthly")
    public ResponseEntity<List<Invoice>> getAllByMonthly() {
        try {
            List<Invoice> invoices =  invoiceService.getAllByMonthly();

            if (invoices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/invoices/yearly")
    public ResponseEntity<List<Invoice>> getAllByYearly() {
        try {
            List<Invoice> invoices =  invoiceService.getAllByYearly();

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

    @DeleteMapping("/invoices/delete/{id}")
    public ResponseEntity<HttpStatus> deleteInvoice(@PathVariable("id") long id) {
        try {
            invoiceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

