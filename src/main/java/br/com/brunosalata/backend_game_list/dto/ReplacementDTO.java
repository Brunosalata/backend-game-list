package br.com.brunosalata.backend_game_list.dto;

/**
 * @author Bruno Salata Lima
 * github.com/Brunosalata
 */
public class ReplacementDTO {

    private Integer sourceIndex;
    private Integer destinationIndex;

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}
