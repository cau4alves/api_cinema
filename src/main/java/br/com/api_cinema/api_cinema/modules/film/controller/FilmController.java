package br.com.api_cinema.api_cinema.modules.film.controller;

import br.com.api_cinema.api_cinema.modules.film.model.FilmModel;
import br.com.api_cinema.api_cinema.modules.film.repository.FilmRepository;
import br.com.api_cinema.api_cinema.modules.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("/create")
    public Object create(@RequestBody FilmModel filmModel) {
        try {
            return this.filmService.execute(filmModel);
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }
}
