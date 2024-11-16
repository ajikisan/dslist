package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Anotação que marca esta classe como uma entidade que será mapeada para uma tabela do banco de dados.
@Table(name = "tb_game") // Especifica o nome da tabela do banco de dados que esta entidade será mapeada.
public class Game {

    @Id // Indica que o campo id é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração do valor da
    // chave primária. Neste caso, a estratégia é IDENTITY, onde o banco de dados gera automaticamente
    // um novo valor exclusivo para a chave primária.
    private Long id;
    private String title; // Título do jogo

    // Anotação que define o nome da coluna no Banco de Dados
    @Column(name = "game_year") //Ano de lançamento do jogo
    private Integer year;
    private String genre; //Gênero do jogo
    private String platforms; //Plataformas disponíveis para o jogo
    private Double score; //Pontuação do jogo
    private String imgUrl; //URL da imagem do jogo

    @Column(columnDefinition = "TEXT")
    private String shortDescription; //Descrição curta do jogo

    @Column(columnDefinition = "TEXT")
    private String longDescription; //Descrição longa do jogo

    public Game() {
    }

    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
                String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    // Método público que retorna o valor da variável 'id'.
    // É utilizado para obter o valor do identificador do objeto.
    public Long getId() {
        return id;
    }

    // Método público que define o valor da variável 'id'.
    // É utilizado para configurar o valor do identificador do objeto.
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

    @Override
    // Anotação que indica que este método substitui o método 'hashCode' da classe pai (Object).
    public int hashCode() {
        return Objects.hash(id);
        // Gera um código hash para o objeto atual usando o campo 'id'.
        // O método 'Objects.hash' cria um valor hash consistente com o método 'equals', o que é importante
        // para o uso em coleções baseadas em hash, como HashMap e HashSet.
    }

    @Override // Anotação que indica que este método substitui o método 'equals' da classe pai (Object).
    public boolean equals(Object obj) {
        // Verifica se a referência do objeto atual é igual à do objeto passado como argumento.
        // Se forem iguais, retorna verdadeiro.
        if (this == obj)
            return true;

        // Verifica se o objeto passado como argumento é nulo. Se for, retorna false.
        if (obj == null)
            return false;

        // Verifica se o objeto passado é da mesma classe que o objeto atual. Se não for, retorna false.
        if (getClass() != obj.getClass())
            return false;

        // Converte o objeto passado como argumento para um objeto do tipo Game.
        Game other = (Game) obj;
        return Objects.equals(id, other.id);
        // Compara o campo 'id' do objeto atual com o campo 'id' do objeto passado.
        // Retorna true se forem iguais, caso contrário, retorna false.
    }
}