package com.example.terramodusv1.repositories.devisSte;
import com.example.terramodusv1.entities.devisSte.DevisSteDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisSteDigitalRepository extends JpaRepository<DevisSteDigital,Long> {

}
