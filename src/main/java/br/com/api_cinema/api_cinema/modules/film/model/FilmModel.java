package br.com.api_cinema.api_cinema.modules.film.model;

import br.com.api_cinema.api_cinema.modules.cinema.model.CinemaModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity(name = "film")
@Data
public class FilmModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "start_session")
    private LocalDateTime startSession;

    @Column(name = "end_session")
    private LocalDateTime endSession;

    private LocalTime duration;

    private Integer room;

    private Double price;

    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "id_cinema", insertable = false, updatable = false)
    private CinemaModel cinemaModel;

    @Column(name = "id_cinema")
    private UUID idCinema;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
