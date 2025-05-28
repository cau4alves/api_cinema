package br.com.api_cinema.api_cinema.modules.payment.model;

import br.com.api_cinema.api_cinema.modules.film.model.FilmModel;
import br.com.api_cinema.api_cinema.modules.user.model.UserModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "payment")
@Data
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "payment_method")
    private String paymentMethod;

    @JoinColumn(name = "id_filme", insertable = false, updatable = false)
    @OneToOne
    private FilmModel filmModel;

    @Column(name = "id_film")
    private Integer idFilm;

    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    @OneToOne
    private UserModel userModel;

    @Column(name = "id_user")
    private UUID idUser;

    @Column(name = "is_paid")
    private boolean isPaid;
}
