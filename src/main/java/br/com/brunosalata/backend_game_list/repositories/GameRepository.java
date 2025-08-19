package br.com.brunosalata.backend_game_list.repositories;

import br.com.brunosalata.backend_game_list.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bruno Salata Lima
 * github.com/Brunosalata
 */
public interface GameRepository extends JpaRepository<Game, Long> {
}
