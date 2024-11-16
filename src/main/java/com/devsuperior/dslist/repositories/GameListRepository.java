package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
   // Interface que estende JpaRepository, permitindo realizar operações de CRUD (Create, Read, Update, Delete)
   // na entidade Game List.
   // JpaRepository é uma interface do Spring Data JPA que fornece métodos prontos para manipulação de dados
   // no banco de dados.
   // A entidade que será manipulada é 'Game List' e o tipo da chave primária dessa entidade é 'Long'.

}