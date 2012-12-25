package org.team5.bank.core.server.service.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Transaction")
public class Transaction  implements Serializable {

	private static final long serialVersionUID = -3841990332137061168L;
	
	private Long id;
     private String fromAccount;
     private String toAccount;
     private String type;
     private double amount;
     private Date timeStamp;

    public Transaction() {
    }

    public Transaction(String fromAccount, String toAccount, String type, double amount, Date timeStamp) {
       this.fromAccount = fromAccount;
       this.toAccount = toAccount;
       this.type = type;
       this.amount = amount;
       this.timeStamp = timeStamp;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="fromAccount", nullable=false, length=15)
    public String getFromAccount() {
        return this.fromAccount;
    }
    
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
    
    @Column(name="toAccount", nullable=false, length=15)
    public String getToAccount() {
        return this.toAccount;
    }
    
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    
    @Column(name="type", nullable=false, length=8, columnDefinition="enum('deposit','withdraw','transfer')")
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="amount", nullable=false, precision=22, scale=0)
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_stamp", nullable=false, length=19)
    public Date getTimeStamp() {
        return this.timeStamp;
    }
    
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }




}
