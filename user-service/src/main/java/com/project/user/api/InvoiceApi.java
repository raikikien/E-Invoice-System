package com.project.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVOICE-SERVICE")
public interface InvoiceApi {
    @GetMapping(value = "users/{userId}/invoices")
    public String getInvoicesByUserId(@PathVariable("userId") Long userId);
}
