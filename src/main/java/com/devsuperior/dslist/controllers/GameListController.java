package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    // Anotação que mapeia requisições HTTP GET para o método findById().
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

    @PostMapping(value = "/{listId}/replacement")
    // Anotação que mapeia requisições HTTP POST para o método move().
    // O valor "/{listId}/replacement" indica que o método aceitará um parâmetro de caminho na URL,
    // que será o identificador da lista.
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
      // Método público que manipula a requisição para mover um item dentro de uma lista.
      // A anotação @PathVariable indica que o parâmetro 'listId' será extraído do caminho da URL.
      // A anotação @RequestBody indica que o corpo da requisição será desserializado para um objeto ReplacementDTO.
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
        // Chama o método move do serviço gameListService, passando o 'listId', 'sourceIndex' e
        // 'destinationIndex' extraídos do objeto ReplacementDTO.
    }

}



