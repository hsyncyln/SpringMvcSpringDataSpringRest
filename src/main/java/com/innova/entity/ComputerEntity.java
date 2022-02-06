package com.innova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "computer")
public class ComputerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long computerId;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "computer_trade")
    private String computerTrade;

    //@Column(name = "computer_price",columnDefinition = "Decimal(10,2) default='100.00'")
    @Column(name = "computer_price")
    private double computerPrice;

    @Column(name="computer_serial_number",length = 11,nullable = false,unique = true)
    private int serialComputerNumber;

  //  @Lob //buyuk veriler icin
  //  private  String bigData;

  //  @Transient //Sadece Javada
  //  private String justJava;

    @Column(name = "computer_createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;
}
