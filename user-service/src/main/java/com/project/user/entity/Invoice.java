package com.project.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private Long id;
    private String typename;
    private Long money;
    private Long vat;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date chargeperiod;
    private Long userId;
}
