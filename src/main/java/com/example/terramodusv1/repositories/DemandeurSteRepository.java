package com.example.terramodusv1.repositories;
import com.example.terramodusv1.entities.devisSte.DemandeurSte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeurSteRepository extends JpaRepository<DemandeurSte,Long> {
}
