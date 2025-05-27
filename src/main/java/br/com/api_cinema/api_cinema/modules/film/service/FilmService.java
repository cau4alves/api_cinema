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

        var horaDuracao = filmModel.getDuration().getHour();
        var minDuracao = filmModel.getDuration().getMinute();
        var secDuracao = filmModel.getDuration().getSecond();
        var endSession = filmModel.getStartSession().plusHours(horaDuracao).plusMinutes(minDuracao).plusSeconds(secDuracao);
        filmModel.setEndSession(endSession);

        return this.filmRepository.save(filmModel);
    }
}
