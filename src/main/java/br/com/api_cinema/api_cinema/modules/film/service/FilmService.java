package br.com.api_cinema.api_cinema.modules.film.service;

import br.com.api_cinema.api_cinema.modules.film.model.FilmModel;
import br.com.api_cinema.api_cinema.modules.film.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public FilmModel execute(FilmModel filmModel) {
        this.filmRepository.findByStartSessionAndRoomAndIdCinema(filmModel.getStartSession(), filmModel.getRoom(), filmModel.getIdCinema())
                .ifPresent(
                        (user) -> {
                            throw new RuntimeException("Sessão já encontrada!");
                        }
                );

        var startSession = filmModel.getStartSession();
        var duration = filmModel.getDuration();
        var endSession = filmModel.getStartSession().plusHours(duration.getHour()).plusMinutes(duration.getMinute()).plusSeconds(duration.getSecond());

        boolean existsOverlap = filmRepository.existsByRoomAndIdCinemaAndStartSessionLessThanAndEndSessionGreaterThan(
                filmModel.getRoom(),
                filmModel.getIdCinema(),
                endSession,
                startSession
        );

        if (existsOverlap) {
            throw new RuntimeException("Já existe uma sessão nesse intervalo!");
        }
        filmModel.setEndSession(endSession);

        return this.filmRepository.save(filmModel);
    }
}
