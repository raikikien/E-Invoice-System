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
    //@Column(name="type")
    private String type;
    //@Column(name="money")
    private Long money;
  //  @Column(name="vat")
    private Long vat;
   // @Column(name="chargeperiod")
    private Date chargeperiod;
}
