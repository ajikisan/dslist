package com.devsuperior.dslist.services;


import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist.entities.Game;
import java.util.List;

@Service // Anotação que indica que esta classe é um serviço do Spring.
         // Serviços são classes que contêm a lógica de negócios e são usadas para separar essa
         // lógica das camadas de controle e de persistência.
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    // Anotação que indica que o Spring deve injetar automaticamente uma instância da classe GameRepository
    // nesta variável. Isso é conhecido como injeção de dependência.

    public List<GameMinDTO> findAll() {
        // Método público que retorna uma lista de objetos GameMinDTO.
        // Este método é usado para buscar todos os jogos do repositório e convertê-los para o formato DTO.
        List<Game> result = gameRepository.findAll();
        // Chama o método findAll() do gameRepository para obter uma lista de todos os jogos.

        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        // Usa um stream para mapear cada objeto Game na lista result para um novo objeto GameMinDTO,
        // e depois coleta esses objetos em uma lista.
        return dto;
        // Retorna a lista de objetos GameMinDTO.
    }
}

