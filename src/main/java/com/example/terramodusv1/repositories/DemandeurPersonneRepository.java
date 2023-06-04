package com.example.terramodusv1.repositories;
import com.example.terramodusv1.entities.devisPersonne.DemandeurPersonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeurPersonneRepository extends JpaRepository<DemandeurPersonne,Long> {
}
