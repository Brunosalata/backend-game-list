package br.com.brunosalata.backend_game_list.service;

import br.com.brunosalata.backend_game_list.dto.GameListDTO;
import br.com.brunosalata.backend_game_list.entities.GameList;
import br.com.brunosalata.backend_game_list.projections.GameMinProjection;
import br.com.brunosalata.backend_game_list.repositories.GameListRepository;
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
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

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

    @Transactional
    public void moveFromTo(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
