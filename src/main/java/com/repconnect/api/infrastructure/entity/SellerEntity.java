package com.repconnect.api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Entity
@Table(name = "sellers")
@Getter
@Setter
@ToString
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SellerEntity() {
    }

    public SellerEntity(Integer id, UserEntity userEntity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userEntity = userEntity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SellerEntity(UserEntity userEntity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userEntity = userEntity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    @PrePersist
    protected void OnCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
}
