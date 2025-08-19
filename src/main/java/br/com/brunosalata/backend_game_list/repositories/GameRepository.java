package br.com.brunosalata.backend_game_list.repositories;

import br.com.brunosalata.backend_game_list.entities.Game;
import br.com.brunosalata.backend_game_list.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Bruno Salata Lima
 * github.com/Brunosalata
 */
public interface GameRepository extends JpaRepository<Game, Long> {

    /**
     *  Consulta Query customizada
     *
     *  <p>Requer <b>nativeQuery = true</b> por se tratar de SQL e não de JPQL, que é uma linguagem específica do JPA.
     *  Mas quando o nativeQuery é utilizado, o resultado será sempre uma Interface, também chamada de Projection</p>
      */
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
	List<GameMinProjection> searchByList(Long listId);

}
