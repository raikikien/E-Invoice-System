package com.project.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import javax.persistence.*;


@Entity (name="invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="type")
    private String type;
    @Column(name="money")
    private Long money;
    @Column(name="vat")
    private Long vat;
    @Column(name="chargeperiod")
    private Date chargeperiod;
    @Column(name="userIdInvoice")
    private Long userIdInvoice;
}
