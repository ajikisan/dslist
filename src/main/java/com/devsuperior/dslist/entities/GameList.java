package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game_list")
public class GameList {

    @Id  // Anotação que indica que o campo 'id' é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Anotação que define a estratégia de geração do valor da chave primária. Neste caso, a estratégia é IDENTITY,
    // onde o banco de dados gera automaticamente um novo valor exclusivo para a chave primária.

    private Long id;
    private String name;

    public GameList() {
     // Construtor padrão sem parâmetros, necessário para algumas operações de frameworks como o JPA.
    }

    public GameList(Long id, String name) {
     // Construtor que inicializa a entidade com os valores fornecidos para 'id' e 'name'.
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        // Verifica se o objeto passado é da mesma classe que o objeto atual. Se não for, retorna false.
        GameList other = (GameList) obj;
        // Converte o objeto passado como argumento para um objeto do tipo GameList.
        return Objects.equals(id, other.id);
        // Compara o campo 'id' do objeto atual com o campo 'id' do objeto passado.
        // Retorna true se forem iguais, caso contrário, retorna false.
    }
}