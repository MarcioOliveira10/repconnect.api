package com.repconnect.api.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.repconnect.api.core.domain.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "represented")
@Getter
@Setter
@ToString
public class RepresentedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String webSite;
    private String email;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "Id")
    private AddressEntity address;

    @OneToMany(mappedBy = "represented", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PhoneEntity> phones;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public RepresentedEntity() {
    }

    public RepresentedEntity(String name, String webSite, String email, AddressEntity address, List<PhoneEntity> phones, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.webSite = webSite;
        this.email = email;
        this.address = address;
        this.phones = phones;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public RepresentedEntity(Integer id, String name, String webSite, String email, AddressEntity address, List<PhoneEntity> phones, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.webSite = webSite;
        this.email = email;
        this.address = address;
        this.phones = phones;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepresentedEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getWebSite(), that.getWebSite()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getPhones(), that.getPhones()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getWebSite(), getEmail(), getAddress(), getPhones(), getCreatedAt(), getUpdatedAt());
    }
}



