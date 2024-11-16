package com.devsuperior.dslist.entities;

import java.util.Objects;
//import com.devsuperior.dslist.entities.Game;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    // Anotação que indica que o campo 'id' é uma chave primária embutida, que contém um objeto do tipo 'BelongingPK'.
    // Esta chave composta é usada para representar a chave primária de uma entidade que consiste em mais de um campo.
    private BelongingPK id = new BelongingPK();
    // Declaração do campo 'id' que é uma instância da classe 'BelongingPK'.
    // Este campo será usado como a chave primária da entidade.

    private Integer position;
    // Declaração do campo 'position' que armazena a posição dentro de um ranking ou lista.

    public void setGame(Game game) {
        id.setGame(game);
    }
    // Método público que define o campo 'game' dentro da chave primária embutida 'id'
    // usando o método 'setGame' da classe 'BelongingPK'.

    public Game getGame() {
        return id.getGame();
    }
    // Método público que retorna o campo 'game' da chave primária embutida 'id' usando o
    // método 'getGame' da classe 'BelongingPK'.

    public void setList(GameList list) {
        id.setList(list);
    }

    public GameList getList() {
        return id.getList();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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
        Belonging other = (Belonging) obj;
        return Objects.equals(id, other.id);
    }
}