package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;


import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
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

    @Transactional
    // Anotação que indica que o método deve ser executado dentro de uma transação.
    // Isso garante que todas as operações realizadas no método sejam atômicas, consistentes,
    // isoladas e duráveis (propriedades ACID).
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        // Método público que move um item dentro de uma lista com base nos índices fornecidos.

        List<GameMinProjection> list = gameRepository.searchByList(listId);
        // Obtém a lista de itens do repositório gameRepository usando o listId fornecido.

        GameMinProjection obj = list.remove(sourceIndex);
        // Remove o item da posição sourceIndex da lista e armazena esse item na variável obj.
        list.add(destinationIndex, obj);
        // Adiciona o item removido na posição destinationIndex da lista.

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        // Determina o menor valor entre sourceIndex e destinationIndex.
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        // Determina o maior valor entre sourceIndex e destinationIndex.

        for (int i = min; i <= max; i++) {
            // Itera sobre a faixa de índices de min até max.
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
            // Atualiza a posição do item na lista no banco de dados usando o repositório gameListRepository.
        }
    }
}

