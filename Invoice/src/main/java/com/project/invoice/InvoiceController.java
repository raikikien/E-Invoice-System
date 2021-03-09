package com.project.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InvoiceController {
 
    @Autowired
    private InvoiceService service;
     
  /*  @GetMapping("/users/{userId}/invoices")
    public ResponseEntity<String> getInvoices(@PathVariable String userId){
    	ResponseEntity.ok(service.listAll());
    }*/ 
    @RequestMapping("/invoices")
    public String viewHomePage(Model model) {
        List<Invoice> listInvoices = service.listAll();
        model.addAttribute("listInvoices", listInvoices);
         
        return "index";
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