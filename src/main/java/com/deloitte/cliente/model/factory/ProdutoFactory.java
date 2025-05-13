package com.deloitte.cliente.model.factory;

import com.deloitte.cliente.model.dto.ProdutoDTO;
import com.deloitte.cliente.model.entity.Produto;

public class ProdutoFactory {
    public static Produto fromDTO(ProdutoDTO dto) {
        var produto = new Produto();
        produto.setNome(dto.nome());
        produto.setValor(dto.valor());
        return produto;
    }

    public static ProdutoDTO fromEntity(Produto p) {
        return new ProdutoDTO(p.getNome(), p.getValor());
    }
}
