package br.com.brunosalata.backend_game_list.service;

import br.com.brunosalata.backend_game_list.dto.GameDTO;
import br.com.brunosalata.backend_game_list.dto.GameMinDTO;
import br.com.brunosalata.backend_game_list.entities.Game;
import br.com.brunosalata.backend_game_list.projections.GameMinProjection;
import br.com.brunosalata.backend_game_list.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bruno Salata Lima
 * github.com/Brunosalata
 *
 * <p>Service sempre retorna os dados DTO para a classe Controller. Nunca os dados brutos,
 * sem tratamento. Questão de boas práticas</p>
 */
@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result =  gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result =  gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
