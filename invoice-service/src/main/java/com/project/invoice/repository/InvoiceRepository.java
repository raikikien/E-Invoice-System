package com.project.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findInvoiceById(Long id);
    @Query("SELECT e FROM invoice e WHERE YEAR(e.chargeperiod) =:searchYear AND MONTH(e.chargeperiod) = :searchMonth")
    //@Query("select e from invoice e where MONTH(e.chargeperiod)=:searchMonth")
    List <Invoice> findAllByMonthly(@Param("searchYear") int searchYear,@Param("searchMonth") int searchMonth);
    @Query("select e from invoice e where YEAR(e.chargeperiod) =:searchYear")
    List <Invoice> findAllByYearly(@Param("searchYear") int searchYear);

   List<Invoice> findInvoiceByUserId(Long userId);
}
