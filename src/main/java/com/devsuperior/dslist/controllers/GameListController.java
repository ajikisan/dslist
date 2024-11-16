package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // Anotação que indica que esta classe é um controlador REST, o que significa que ela
                 // trata requisições HTTP e envia respostas HTTP no formato JSON ou XML.

@RequestMapping(value = "/lists")
                 // Define a URL base para todos os endpoints dentro desta classe.
                 // Todas as requisições para "/lists" serão tratadas por métodos dentro desta classe.

public class GameListController {
    @Autowired
    // Anotação que indica que o Spring deve injetar automaticamente uma instância da classe GameService
    // nesta variável. Isso é conhecido como injeção de dependência.
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        GameListDTO result = gameListService.findById(id);
        return result;
    }

    @GetMapping
        public List<GameListDTO> findAll() {
           List<GameListDTO> result = gameListService.findAll();
            return result;
        }


    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
}



