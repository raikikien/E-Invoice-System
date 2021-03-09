package com.project.invoice;

import java.util.Arrays;
import java.util.List;
import com.project.invoice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class InvoiceController {
 
    @Autowired
    private InvoiceService service;    
    
    @GetMapping(value ="/invoices")
    public ResponseEntity<List<Invoice>> findAllInvoice() {
        List<Invoice> invoices = service.listAll();
        if (invoices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }
    
    @PostMapping(value="/invoices/new")
    public void newInvoice() {
    	Invoice invoice = new Invoice();
    }
    
    
    @RequestMapping("/new")
    public String showNewInvoicePage(Model model) {
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
         
        return "new_invoice";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
    	service.save(invoice);
         
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditInvoicePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_invoice");
        Invoice invoice = service.get(id);
        mav.addObject("invoice", invoice);
         
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable(name = "id") int id) {
    	service.delete(id);
        return "redirect:/";       
    }
}