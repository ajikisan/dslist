package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController  // Anotação que indica que esta classe é um controlador REST, o que significa que ela
                 // trata requisições HTTP e envia respostas HTTP no formato JSON ou XML.

@RequestMapping(value = "/games")
                 // Define a URL base para todos os endpoints dentro desta classe.
                 // Todas as requisições para "/games" serão tratadas por métodos dentro desta classe.

public class GameController {
    @Autowired
    // Anotação que indica que o Spring deve injetar automaticamente uma instância da classe GameService
    // nesta variável. Isso é conhecido como injeção de dependência.
    private GameService gameService;

    @GetMapping(value = "/{id}")
    // Anotação que mapeia requisições HTTP GET para o método findByID(). O valor "/{id}" indica que o método
    // aceitará um parâmetro de caminho na URL, que será o identificador do jogo.
    public GameDTO findByID(@PathVariable Long id){
        // Método público que retorna um objeto GameDTO correspondente ao identificador fornecido na URL.
        // A anotação @PathVariable indica que o parâmetro 'id' será extraído do caminho da URL.
        GameDTO result = gameService.findById(id);
        // Chama o método findById do serviço gameService para obter os detalhes do jogo a partir do
        // identificador fornecido.
        return result;
        // Retorna o objeto GameDTO contendo os detalhes do jogo.
    }

    @GetMapping
    // Anotação que mapeia requisições HTTP GET para o método findAll(). Quando uma requisição GET é enviada
    // para "/games", este método é chamado.
    public List<GameMinDTO> findAll() {
           List<GameMinDTO> result = gameService.findAll();
            return result;
        }
    }


