package com.devsuperior.dslist.projections;

public interface GameMinProjection {
    // Interface que define uma "projeção mínima" da entidade Game, retornando apenas um subconjunto de seus campos.
    Long getId();
    // Método que retorna o identificador único do jogo.
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
