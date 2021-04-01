package com.project.invoice.service;


import com.project.invoice.entity.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.invoice.repository.InvoiceRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> findAllByMonth(int year, int month){
        return invoiceRepository.findAllByMonthly(year,month);
    }
    public List<Invoice> findAllByYear(int year){
        return invoiceRepository.findAllByYearly(year);
    }

    public Invoice findInvoiceById(Long id) {
        return invoiceRepository.findInvoiceById(id);
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }


    public void deleteById(long id) {
        invoiceRepository.deleteById(id);
    }

   public List<Invoice> findInvoiceByUserId(Long userId) {
        return invoiceRepository.findInvoiceByUserId(userId);
    }

    public List<Invoice> findAllByPeriodDate(Date searchDateBegin, Date searchDateEnd) {
        return invoiceRepository.findAllByPeriodDate(searchDateBegin, searchDateEnd );
    }

    public List<Invoice> getAllByMonthly(){
        return invoiceRepository.getAllByMonthly();
    }

    public List<Invoice> getAllByYearly(){
        return invoiceRepository.getAllByYearly();
    }

    public List<Invoice> findDuplicateInvoice(Invoice invoice)
    {
//        LocalDate localDate = invoice.getChargeperiod().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate = invoice.getChargeperiod();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        return invoiceRepository.findDuplicateInvoice(month, year, invoice.getTypename());
    }
}

