package com.example.terramodusv1.repositories;
import com.example.terramodusv1.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
