package com.example.terramodusv1.repositories;
import com.example.terramodusv1.entities.Immob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImmobRepository extends JpaRepository<Immob,Long> {
}
