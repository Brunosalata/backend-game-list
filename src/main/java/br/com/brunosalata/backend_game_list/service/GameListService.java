package br.com.brunosalata.backend_game_list.service;

import br.com.brunosalata.backend_game_list.dto.GameListDTO;
import br.com.brunosalata.backend_game_list.entities.GameList;
import br.com.brunosalata.backend_game_list.repositories.GameListRepository;
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
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList result = gameListRepository.findById(id).get();
        return new GameListDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result =  gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

}
