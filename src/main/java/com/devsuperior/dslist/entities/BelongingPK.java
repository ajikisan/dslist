package com.devsuperior.dslist.entities;

import java.util.Objects;
//import com.devsuperior.dslist.entities.Game;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
// Anotação que indica que esta classe é um tipo embutido. Classes embutidas são usadas como parte de outras entidades
// e não possuem sua própria identidade persistente. Elas são incorporadas em entidades e seus atributos são armazenados
// como colunas na tabela da entidade de propriedade.
public class BelongingPK {

    @ManyToOne
    // Anotação que especifica uma relação muitos-para-um.
    // Esta classe possui uma associação muitos-para-um com a entidade Game.
    @JoinColumn(name = "game_id")
    // Anotação que especifica a coluna de junção para a relação. O nome da coluna no banco de dados será "game_id",
    // que fará referência à chave primária da entidade Game.
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        return Objects.equals(game, other.game) && Objects.equals(list, other.list);
    }
}