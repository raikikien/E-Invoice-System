package com.project.invoice;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

 
@Entity
public class Invoice {
	
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id)
    {
    	this.id = id;
    }
	private String type;
    private long money;
    private long vat;
    private Date chargeperiod;
    
    public Invoice( long id, String type, long money, long vat, Date chargeperiod) {
		super();
		this.id = id;
		this.type = type;
		this.money = money;
		this.vat = vat;
		this.chargeperiod = chargeperiod;
	}
    
    public Invoice() {
    super();
    }
 
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public long getVat() {
		return vat;
	}

	public void setVat(long vat) {
		this.vat = vat;
	}

	public Date getChargeperiod() {
		return chargeperiod;
	}

	public void setChargeperiod(Date chargeperiod) {
		this.chargeperiod = chargeperiod;
	}
}