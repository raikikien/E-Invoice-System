package com.project.invoice.userAPI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-SERVICE")
public interface UserAPI {
    @GetMapping(value = "/users/{userId}/invoices")
    public String findInvoiceByUserId();
}
