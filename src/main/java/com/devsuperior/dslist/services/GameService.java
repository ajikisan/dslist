package com.devsuperior.dslist.services;


import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist.entities.Game;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Anotação que indica que esta classe é um serviço do Spring.
         // Serviços são classes que contêm a lógica de negócios e são usadas para separar essa
         // lógica das camadas de controle e de persistência.
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    // Anotação que indica que o Spring deve injetar automaticamente uma instância da classe GameRepository
    // nesta variável. Isso é conhecido como injeção de dependência.

    @Transactional(readOnly = true)
    // Anotação que indica que o método deve ser executado dentro de uma transação. O parâmetro 'readOnly = true'
    // especifica que esta transação é somente leitura, o que significa que não haverá alterações no banco de dados.
    // Essa configuração pode melhorar o desempenho e garantir a consistência dos dados.
    public GameDTO findById(Long id){
        // Método público que retorna um objeto GameDTO correspondente ao identificador fornecido.
        Game result = gameRepository.findById(id).get();
        // Chama o método findById do repositório para buscar um objeto Game pelo seu identificador.
        // O método get() é usado para obter o objeto Game a partir do Optional retornado pelo repositório.
        GameDTO dto = new GameDTO(result);
        // Constrói um novo objeto GameDTO usando o objeto Game obtido.
        return dto;
        // Retorna o objeto GameDTO.
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}

