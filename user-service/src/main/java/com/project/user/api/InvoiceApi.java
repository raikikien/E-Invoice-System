package com.project.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "INVOICE-SERVICE")
public interface InvoiceApi {
    @GetMapping(value = "/users/{userId}/invoices")
    public String getInvoicesByUserId(@PathVariable("userId") Long userId);
    @PostMapping(value = "/invoices/new")
    public String saveInvoice(@RequestBody String body);



}
