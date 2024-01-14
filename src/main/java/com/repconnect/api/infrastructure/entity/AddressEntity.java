package com.repconnect.api.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String number;
    private String city;
    @Column(name="zip_code")
    private String zipCode;
    private String complement;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //constructors

    public AddressEntity(Integer id, String street, String number, String city,
                         String zipCode, String complement, LocalDateTime createdAt,
                         LocalDateTime updatedAt) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipCode = zipCode;
        this.complement = complement;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public AddressEntity(String street, String number, String city, String zipCode,
                         String complement, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipCode = zipCode;
        this.complement = complement;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    @PrePersist
    protected void OnCreate(){
        createdAt= LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public AddressEntity() {
    }

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = LocalDateTime.now();
    }

    //toString

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", complement='" + complement + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getZipCode(), that.getZipCode()) && Objects.equals(getComplement(), that.getComplement()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStreet(), getNumber(), getCity(), getZipCode(), getComplement(), getCreatedAt(), getUpdatedAt());
    }
}
