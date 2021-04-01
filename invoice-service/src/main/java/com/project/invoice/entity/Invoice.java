package com.project.invoice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.time.LocalDate;
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
    @Column(name="typename")
    private String typename;
    @Column(name="money")
    private Long money;
    @Column(name="vat")
    private Long vat;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name="chargeperiod")
    private LocalDate chargeperiod;
    @Column(name="userId")
    private Long userId;
    @Column(name="totalmoney")
    private Long totalmoney;
}
