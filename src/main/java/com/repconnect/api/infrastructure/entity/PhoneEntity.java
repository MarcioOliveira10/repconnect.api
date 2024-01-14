package com.repconnect.api.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "phones")
@Getter
@Setter
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
    private LocalDateTime updateAt;

    public PhoneEntity() {
    }

    public PhoneEntity(Integer id, String phoneNumber, String name, RepresentedEntity represented, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.represented = represented;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
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
    @PrePersist
    public void createData(){
        createdAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getName(), that.getName()) && Objects.equals(getRepresented(), that.getRepresented()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdateAt(), that.getUpdateAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoneNumber(), getName(), getRepresented(), getCreatedAt(), getUpdateAt());
    }
}




