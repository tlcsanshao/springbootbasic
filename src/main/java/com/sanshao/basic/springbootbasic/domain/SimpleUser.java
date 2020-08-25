package com.sanshao.basic.springbootbasic.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class SimpleUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    private int age;

    private float score;


}
