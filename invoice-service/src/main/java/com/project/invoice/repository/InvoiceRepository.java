package com.project.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findInvoiceById(Long id);
    @Query("SELECT e FROM invoice e WHERE YEAR(e.chargeperiod) =:searchYear AND MONTH(e.chargeperiod) = :searchMonth")
    List <Invoice> findAllByMonthly(@Param("searchYear") int searchYear,@Param("searchMonth") int searchMonth);
    @Query("select e from invoice e where YEAR(e.chargeperiod) =:searchYear")
    List <Invoice> findAllByYearly(@Param("searchYear") int searchYear);
    @Query("select e from invoice e where date(e.chargeperiod) between :searchDateBegin AND :searchDateEnd")
    List<Invoice> findAllByPeriodDate(@Param("searchDateBegin") Date searchDateBegin,
                                      @Param("searchDateEnd") Date searchDateEnd);
    @Query ("SELECT e FROM invoice e where MONTH(e.chargeperiod) = :searchMonth AND YEAR(e.chargeperiod)  = :searchYear AND e.typename = :searchTypeName")
    List<Invoice> findDuplicateInvoice(@Param("searchMonth") int month,
                                       @Param("searchYear") int year,
                                       @Param("searchTypeName") String typename);
    List<Invoice> findInvoiceByUserId(Long userId);

    @Query ("SELECT  e FROM invoice e where MONTH(CURRENT_DATE())=month(e.chargeperiod)")
    List<Invoice> getAllByMonthly();

    @Query ("SELECT  e FROM invoice e where YEAR(CURRENT_DATE())=year(e.chargeperiod)")
    List<Invoice> getAllByYearly();

}
