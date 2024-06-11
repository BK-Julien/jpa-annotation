package dev.bkjulien.data_jpa.repositories;

import dev.bkjulien.data_jpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {

}
