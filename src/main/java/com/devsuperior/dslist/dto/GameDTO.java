package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

public class GameDTO {

    private Long id;  // número de identificação na tabela
    private String title; // Título do jogo
    private Integer year; // Ano de lançamento do jogo
    private String genre; //Gênero do jogo
    private String platforms; //Plataformas disponíveis para o jogo
    private Double score; //Pontuação do jogo
    private String imgUrl; //URL da imagem do jogo
    private String shortDescription; //Descrição curta do jogo
    private String longDescription; //Descrição longa do jogo

    public GameDTO(){

    }

    public GameDTO(Game entity){
        // Construtor da classe GameDTO que recebe um objeto do tipo Game como parâmetro.
        BeanUtils.copyProperties(entity,this);
        // Usa o método copyProperties da classe BeanUtils para copiar todas as propriedades do
        // objeto Game recebido para o objeto atual (this) de GameDTO.
        // Isso facilita a transferência de dados do objeto de entidade para o objeto DTO (Data Transfer Object)
        // sem a necessidade de copiar manualmente cada propriedade.


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
