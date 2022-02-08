package com.innova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "user_mail")
    private String emailAddress;

    @Column(name = "user_age")
    private int userAge;

    @Column(name = "user_message",unique = true)
    private String userMessage;

    @Column(name = "computer_createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;
}
