package com.apex.carapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarPart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long partId;
    private String make;
    private String model;
    private String year;

}
