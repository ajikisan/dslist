
package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

// Classe independente do banco de dados

public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {

    }
// Construtor da classe GameMinDTO que recebe um objeto do tipo Game como parâmetro.

    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        // Inicializa o campo 'id' com o valor do campo 'id' do objeto Game recebido.
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }


    public GameMinDTO(GameMinProjection projection) {
     id = projection.getId();
     title = projection.getTitle();
     year = projection.getYear();
     imgUrl = projection.getImgUrl();
     shortDescription = projection.getShortDescription();

    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}