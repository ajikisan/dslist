package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;


import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Anotação que indica que esta classe é um serviço do Spring.
         // Serviços são classes que contêm a lógica de negócios e são usadas para separar essa
         // lógica das camadas de controle e de persistência.
public class GameListService {

    @Autowired
    // Anotação que indica que o Spring deve injetar automaticamente uma instância do GameRepository nesta variável.
    // Isso é conhecido como injeção de dependência.
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    // Anotação que indica que o método deve ser executado dentro de uma transação de somente leitura.
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
        // Converte a lista de GameList para uma lista de GameListDTO usando um stream e o construtor de GameListDTO,
        // e retorna a lista resultante.
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList entity = gameListRepository.findById(id).get();
        return new GameListDTO(entity);
        // Constrói um novo objeto GameListDTO usando o objeto GameList obtido, e retorna o objeto GameListDTO.
    }
}

