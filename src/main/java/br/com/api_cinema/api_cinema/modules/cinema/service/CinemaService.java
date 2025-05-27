package br.com.api_cinema.api_cinema.modules.cinema.service;

import br.com.api_cinema.api_cinema.modules.cinema.model.CinemaModel;
import br.com.api_cinema.api_cinema.modules.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public CinemaModel execute(CinemaModel cinemaModel) {
        this.cinemaRepository.findByAddress(cinemaModel.getAddress())
                .ifPresent(
                        (user) -> {
                            throw new RuntimeException("Cinema com mesmo endereço já encontrado");
                        }
                );

        return this.cinemaRepository.save(cinemaModel);
    }
}
