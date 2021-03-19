package com.project.user.api;

import com.google.gson.Gson;
import com.project.user.entity.Invoice;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "INVOICE-SERVICE")
public interface InvoiceApi {

    @GetMapping(value = "/users/{userId}/invoices")
    public List<Invoice> findInvoiceByUserId(@PathVariable("userId") Long userId);

    @PostMapping(value = "/invoices/new")
    public String saveInvoice(@RequestBody String body);

}
