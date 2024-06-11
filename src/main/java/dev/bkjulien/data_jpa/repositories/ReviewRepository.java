package dev.bkjulien.data_jpa.repositories;

import dev.bkjulien.data_jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
