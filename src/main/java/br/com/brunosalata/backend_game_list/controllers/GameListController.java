package br.com.brunosalata.backend_game_list.controllers;

import br.com.brunosalata.backend_game_list.dto.GameDTO;
import br.com.brunosalata.backend_game_list.dto.GameListDTO;
import br.com.brunosalata.backend_game_list.dto.GameMinDTO;
import br.com.brunosalata.backend_game_list.service.GameListService;
import br.com.brunosalata.backend_game_list.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * que serão disponibilizados ao frontend, não retorna entidade.</p>
 */
@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        GameListDTO result = gameListService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

}
