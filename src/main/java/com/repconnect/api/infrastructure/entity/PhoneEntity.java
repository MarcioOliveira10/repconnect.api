package com.repconnect.api.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "phones")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String name;
    @ManyToOne
    @JoinColumn(name = "represented_id")
    @JsonBackReference
    private RepresentedEntity represented;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public PhoneEntity() {
    }

    public PhoneEntity(Integer id, String phoneNumber, String name, RepresentedEntity represented, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.represented = represented;
        this.createdAt = createdAt;
        this.updatedAt = updateAt;
    }

    public PhoneEntity(Integer id, String phoneNumber, String name, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public PhoneEntity(String phoneNumber, String name, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    @PrePersist
    public void createData(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RepresentedEntity getRepresented() {
        return represented;
    }

    public void setRepresented(RepresentedEntity represented) {
        this.represented = represented;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getName(), that.getName()) && Objects.equals(getRepresented(), that.getRepresented()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoneNumber(), getName(), getRepresented(), getCreatedAt(), getUpdatedAt());
    }
}




