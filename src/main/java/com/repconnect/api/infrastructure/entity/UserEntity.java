package com.repconnect.api.infrastructure.entity;

import com.repconnect.api.core.domain.TypeOfUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "phone_id", referencedColumnName = "Id")
    private PhoneEntity phoneEntity;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "Id")
    private AddressEntity addressEntity;
    private TypeOfUser typeOfUser;
    private String password;
    private String activationKey;
    private String rememberToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String email, PhoneEntity phoneEntity, AddressEntity addressEntity, TypeOfUser typeOfUser, String password, String activationKey, String rememberToken, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneEntity = phoneEntity;
        this.addressEntity = addressEntity;
        this.typeOfUser = typeOfUser;
        this.password = password;
        this.activationKey = activationKey;
        this.rememberToken = rememberToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserEntity(String name, String email, PhoneEntity phoneEntity, AddressEntity addressEntity, TypeOfUser typeOfUser, String password, String activationKey, String rememberToken, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.email = email;
        this.phoneEntity = phoneEntity;
        this.addressEntity = addressEntity;
        this.typeOfUser = typeOfUser;
        this.password = password;
        this.activationKey = activationKey;
        this.rememberToken = rememberToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    @PrePersist
    protected void OnCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhoneEntity(), that.getPhoneEntity()) && Objects.equals(getAddressEntity(), that.getAddressEntity()) && getTypeOfUser() == that.getTypeOfUser() && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getActivationKey(), that.getActivationKey()) && Objects.equals(getRememberToken(), that.getRememberToken()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPhoneEntity(), getAddressEntity(), getTypeOfUser(), getPassword(), getActivationKey(), getRememberToken(), getCreatedAt(), getUpdatedAt());
    }
}
