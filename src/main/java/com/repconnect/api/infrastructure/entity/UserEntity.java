package com.repconnect.api.infrastructure.entity;

import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.domain.TypeOfUser;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
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
    private PhoneEntity phone;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "Id")
    private AddressEntity address;

    @Column(name = "type_of_user")
    private TypeOfUser typeOfUser;
    private String password;
    @Column(name = "activation_key")
    private String activationKey;
    @Column(name = "remember_token")
    private String rememberToken;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String email, PhoneEntity phone, AddressEntity address, TypeOfUser typeOfUser, String password, String activationKey, String rememberToken, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.typeOfUser = typeOfUser;
        this.password = password;
        this.activationKey = activationKey;
        this.rememberToken = rememberToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserEntity(String name, String email, PhoneEntity phone, AddressEntity address, TypeOfUser typeOfUser, String password, String activationKey, String rememberToken, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhoneEntity getPhone() {
        return phone;
    }

    public void setPhone(PhoneEntity phone) {
        this.phone = phone;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
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
        if (!(o instanceof UserEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getAddress(), that.getAddress()) && getTypeOfUser() == that.getTypeOfUser() && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getActivationKey(), that.getActivationKey()) && Objects.equals(getRememberToken(), that.getRememberToken()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPhone(), getAddress(), getTypeOfUser(), getPassword(), getActivationKey(), getRememberToken(), getCreatedAt(), getUpdatedAt());
    }
}
