package br.com.api_cinema.api_cinema.modules.cinema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "cinema")
@Data
public class CinemaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Email(message = "Digite um email válido")
    private String email;

    @Length(min = 8, max = 100, message = "A senha deve ter entre 8 e 100 caracteres")
    private String password;

    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
    private String name;

    private String address;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
