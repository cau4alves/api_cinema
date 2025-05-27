package br.com.api_cinema.api_cinema.modules.cinema.repository;

import br.com.api_cinema.api_cinema.modules.cinema.model.CinemaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CinemaRepository extends JpaRepository<CinemaModel, UUID> {
    Optional<CinemaModel> findByAddress(String address);
}