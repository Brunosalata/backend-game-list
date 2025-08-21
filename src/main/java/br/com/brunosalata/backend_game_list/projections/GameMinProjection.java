package br.com.brunosalata.backend_game_list.projections;

/**
 * @author Bruno Salata Lima
 * github.com/Brunosalata
 */
public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
