package com.example.cloud.gateway.api;

import com.example.cloud.gateway.models.Invoice;
import com.example.cloud.gateway.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(name = "INVOICE-SERVICE")
public interface InvoiceAPI {

    @PostMapping("/invoices/new")
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice);

    @PutMapping("/invoices/update/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") Long id, @RequestBody Invoice invoice);

    @GetMapping("/invoices/find/{id}")
    public Invoice findInvoiceById(@PathVariable("id") Long id);

    @GetMapping("/invoices/searchMonthly/{year}/{month}")
    public List<Invoice> findAllInvoicesByMonthly(@PathVariable("year") int year, @PathVariable("month") int month);

    @GetMapping("/invoices/searchYearly/{year}")
    public List<Invoice> findAllInvoicesByYearly(@PathVariable("year") int year);

    @GetMapping("/invoices/searchDatePeriod") // example to test: ("/invoices/searchDatePeriod?start=2021/04/01&end=2021/04/30")
    public List<Invoice> findAllByPeriodDate(@RequestParam("start") Date searchDateBegin,
                                             @RequestParam("end") Date searchDateEnd);
    @GetMapping("/invoices/all")
    public ResponseEntity<List<Invoice>> getAllInvoices();

    @GetMapping("/users/{userId}/invoices")
    public ResponseEntity<List<Invoice>> getInvoicesByUserId(@PathVariable("userId") Long userId);

    @DeleteMapping("/invoices/delete/{id}")
    public ResponseEntity<HttpStatus> deleteInvoice(@PathVariable("id") long id);

}
