//Componente de camada de acesso a Dados

package com.devsuperior.dslist.repositories;
import com.devsuperior.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GameRepository extends JpaRepository<Game,Long> {
// Interface que estende JpaRepository, permitindo realizar operações de CRUD (Create, Read, Update, Delete)
// na entidade Game.
// JpaRepository é uma interface do Spring Data JPA que fornece métodos prontos para manipulação de dados
// no banco de dados.
// A entidade que será manipulada é 'Game' e o tipo da chave primária dessa entidade é 'Long'.

    // Consulta customizada
    // Anotação @Query que indica que este método executa uma consulta SQL nativa.
    // A propriedade 'value' contém a consulta SQL, que será executada diretamente no banco de dados.
    // Seleciona campos específicos da tabela 'tb_game' e da tabela 'tb_belonging'.
    // Realiza um inner join entre 'tb_game' e 'tb_belonging' baseado no campo 'game_id'.
    // Filtra os resultados da consulta para incluir apenas aqueles onde 'list_id' em 'tb_belonging'
    // corresponde ao valor do parâmetro 'listId'.
    // Ordena os resultados da consulta pelo campo 'position' em 'tb_belonging'.
	// Quando no executado o postegres não leu as aspas tb_game.game_year AS `year`
	// ocasionado  "error": "Internal Server Error" http://localhost:8080/lists/1/games,


    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")

	List<GameMinProjection> searchByList(Long listId);
	// Declaração de um método abstrato em um repositório que retorna uma lista de objetos do tipo 'GameMinProjection'.
    // O método aceita um parâmetro 'listId' do tipo Long, que é usado para filtrar os resultados da consulta.
    // 'GameMinProjection' é uma interface que define um subconjunto de campos da entidade 'Game', permitindo consultas
    // mais leves e específicas.
}