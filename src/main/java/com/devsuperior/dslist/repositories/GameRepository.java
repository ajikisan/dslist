//Componente de camada de acesso a Dados CRUD

package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dslist.entities.Game;


public interface GameRepository extends JpaRepository<Game,Long> {
// Interface que estende JpaRepository, permitindo realizar operações de CRUD (Create, Read, Update, Delete)
// na entidade Game.
// JpaRepository é uma interface do Spring Data JPA que fornece métodos prontos para manipulação de dados
// no banco de dados.
// A entidade que será manipulada é 'Game' e o tipo da chave primária dessa entidade é 'Long'.

}