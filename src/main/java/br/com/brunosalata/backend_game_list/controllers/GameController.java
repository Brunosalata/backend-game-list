package br.com.brunosalata.backend_game_list.controllers;

import br.com.brunosalata.backend_game_list.dto.GameMinDTO;
import br.com.brunosalata.backend_game_list.entities.Game;
import br.com.brunosalata.backend_game_list.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bruno Salata Lima
 * github.com/Brunosalata
 *
 * <p>Controller é a porta de entrada do backend.
 * Ele que expõe os endpoints que serão acessados pelo frontend.</p>
 * <p>Ele recebe uma solicitação do frontend, acessa as camadas de serviço,
 * que farão as consultas e processamentos e retornação os dados necessários (dto),
 * que serão disponibilizados ao frontend.</p>
 */
@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

}
