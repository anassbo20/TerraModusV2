package com.example.terramodusv1.repositories.devisPersonne;
import com.example.terramodusv1.entities.devisPersonne.DevisPersonneOpci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisPersonneOpciRepository extends JpaRepository<DevisPersonneOpci,Long> {

}
