package com.example.terramodusv1.repositories;
import com.example.terramodusv1.entities.TypeDevis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDevisRepository extends JpaRepository<TypeDevis,Long> {
}
