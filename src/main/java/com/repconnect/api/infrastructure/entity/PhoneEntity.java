package com.repconnect.api.infrastructure.entity;

import jakarta.persistence.*;

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
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    public PhoneEntity() {
    }

    public PhoneEntity(Integer id, String phoneNumber, String name, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public PhoneEntity(String phoneNumber, String name, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getName(), that.getName()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdateAt(), that.getUpdateAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoneNumber(), getName(), getCreatedAt(), getUpdateAt());
    }

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}




