package com.mx.bankaya.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity that manages Request information
 * @author Sarahy Ramirez
 */
@Setter
@Getter
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "IP")
    private String ip;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "METHOD")
    private String method;
}
