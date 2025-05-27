package br.com.api_cinema.api_cinema.modules.film.repository;

import br.com.api_cinema.api_cinema.modules.film.model.FilmModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface FilmRepository extends JpaRepository<FilmModel, Integer> {
    Optional<FilmModel> findByStartSessionAndRoomAndIdCinema(LocalDateTime hora, Integer room, UUID idCinema);
}
