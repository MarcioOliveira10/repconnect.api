package com.repconnect.api.infrastructure.repository;

import com.repconnect.api.infrastructure.entity.RepresentedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IRepresentedRepository extends JpaRepository<RepresentedEntity, Integer> {
//    @Query("SELECT r FROM Represented r WHERE r.name = :name")
//    List<RepresentedEntity> getRepresentedByName(@Param("name") String name);
    default boolean existsByNameIgnoringSpaces(String name) {
        String trimmedName = name.replaceAll("\\s", ""); // Remove todos os espaços
        return existsByName(trimmedName);
    }
    @Query("SELECT COUNT(r) > 0 FROM RepresentedEntity r WHERE TRIM(r.name) = TRIM(:name)")
    boolean existsByName(String name);

   // Optional<RepresentedEntity> findById(Integer id);

}
