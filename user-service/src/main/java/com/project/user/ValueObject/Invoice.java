package com.project.user.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    private Long id;
    private String type;
    private Long money;
    private Long vat;
    private Date chargeperiod;
    private Long userIdInvoice;
}
