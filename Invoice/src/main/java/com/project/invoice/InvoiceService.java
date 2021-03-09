package com.project.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class InvoiceService {
 
    @Autowired
    private InvoiceRepository repo;
     
    public List<Invoice> listAll() {
        return repo.findAll();
    }
     
    public void save(Invoice invoice) {
        repo.save(invoice);
    }
     
    public Invoice get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
