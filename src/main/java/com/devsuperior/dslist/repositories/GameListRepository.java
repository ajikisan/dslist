package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList,Long> {
   // Interface que estende JpaRepository, permitindo realizar operações de CRUD (Create, Read, Update, Delete)
   // na entidade Game List.
   // JpaRepository é uma interface do Spring Data JPA que fornece métodos prontos para manipulação de dados
   // no banco de dados.
   // A entidade que será manipulada é 'Game List' e o tipo da chave primária dessa entidade é 'Long'.

    @Modifying
    // Anotação que indica que este método executa uma operação de modificação no banco de dados,
    // como uma atualização, exclusão ou inserção.
    // É necessário em consultas que alteram o estado dos dados.
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    // Anotação que define a consulta SQL nativa a ser executada.
    // A propriedade 'value' contém a instrução SQL, que, neste caso, atualiza a coluna 'position'
    // na tabela 'tb_belonging' com base nos valores de 'list_id' e 'game_id'.

    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
    // Método que executa a consulta definida na anotação @Query.
    // Este método não retorna nenhum valor (void) e aceita os parâmetros 'listId', 'gameId' e 'newPosition'.


}