package br.com.brunosalata.backend_game_list.repositories;

import br.com.brunosalata.backend_game_list.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bruno Salata Lima
 * github.com/Brunosalata
 */
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
