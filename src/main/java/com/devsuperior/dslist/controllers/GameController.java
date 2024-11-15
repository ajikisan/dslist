package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController  // Anotação que indica que esta classe é um controlador REST, o que significa que ela
                 // trata requisições HTTP e envia respostas HTTP no formato JSON ou XML.
@RequestMapping(value = "/games")  // Define a URL base para todos os endpoints dentro desta classe.
                        // Todas as requisições para "/games" serão tratadas por métodos dentro desta classe.
public class GameController {
    @Autowired
    // Anotação que indica que o Spring deve injetar automaticamente uma instância da classe GameService
    // nesta variável. Isso é conhecido como injeção de dependência.

    private GameService gameService;

    @GetMapping
    // Anotação que mapeia requisições HTTP GET para o método findAll(). Quando uma requisição GET é enviada
    // para "/games", este método é chamado.
    public List<GameMinDTO> findAll() {
           List<GameMinDTO> result = gameService.findAll();
            return result;
        }
    }


