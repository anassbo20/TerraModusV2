package com.example.terramodusv1.repositories.devisSte;
import com.example.terramodusv1.entities.devisSte.DevisSteAmiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisSteAmiableRepository extends JpaRepository<DevisSteAmiable,Long> {

}
