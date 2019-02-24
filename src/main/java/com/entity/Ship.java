package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "ship")
@EntityListeners(Ship.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Commander commander;

    @NotBlank
    private String name;

    @NotBlank
    private Integer shipIdNumber;

    @NotBlank
    private String shipType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShipIdNumber() {
        return shipIdNumber;
    }

    public void setShipIdNumber(Integer shipIdNumber) {
        this.shipIdNumber = shipIdNumber;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Commander getCommander() {
        return commander;
    }

    public void setCommander(Commander commander) {
        this.commander = commander;
    }
}
