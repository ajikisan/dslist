package com.devsuperior.dslist.dto;

public class ReplacementDTO {
    private Integer sourceIndex;
    // Declaração do campo 'sourceIndex', que armazena o índice de origem para uma operação de substituição.
    private Integer destinationIndex;
    // Declaração do campo 'destinationIndex', que armazena o índice de destino para uma operação de substituição.

    public Integer getSourceIndex() {
        // Método público que retorna o valor do campo 'sourceIndex'.
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        // Método público que define o valor do campo 'sourceIndex'.
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestinationIndex() {
        // Método público que retorna o valor do campo 'destinationIndex'.
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        // Método público que define o valor do campo 'destinationIndex'.
        this.destinationIndex = destinationIndex;
    }
}
