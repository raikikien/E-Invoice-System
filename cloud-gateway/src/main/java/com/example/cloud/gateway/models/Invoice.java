package com.example.cloud.gateway.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


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
