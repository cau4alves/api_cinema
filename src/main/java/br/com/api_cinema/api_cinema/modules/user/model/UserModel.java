package br.com.api_cinema.api_cinema.modules.user.model;

import br.com.api_cinema.api_cinema.modules.film.model.FilmModel;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "users")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    private String email;

    private String password;

    @JoinColumn(name = "id_filme", insertable = false, updatable = false)
    @OneToMany
    @Nullable
    private FilmModel[] filmModel;

    @Column(name = "id_filme")
    @Nullable
    private Integer idFilm;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
