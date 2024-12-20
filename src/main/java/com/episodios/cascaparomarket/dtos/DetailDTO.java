package com.episodios.cascaparomarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailDTO {
    private Long id;
    private ProductoDTO producto;
    private Integer cantidad;
    private Double precioUnitario;
}
