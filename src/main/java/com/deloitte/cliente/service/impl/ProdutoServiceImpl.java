package com.deloitte.cliente.service.impl;

import com.deloitte.cliente.model.dto.ProdutoDTO;
import com.deloitte.cliente.model.entity.Produto;
import com.deloitte.cliente.model.factory.ProdutoFactory;
import com.deloitte.cliente.repository.ProdutoRepository;
import com.deloitte.cliente.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoDTO cadastrar(ProdutoDTO dto) {
        validarValorProduto(dto.valor());

        Produto produto = ProdutoFactory.fromDTO(dto);
        Produto salvo = produtoRepository.save(produto);
        return ProdutoFactory.fromEntity(salvo);
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll().stream()
                .map(ProdutoFactory::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO editar(Long id, ProdutoDTO dto) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        validarValorProduto(dto.valor());

        produtoExistente.setNome(dto.nome());
        produtoExistente.setValor(dto.valor());

        Produto atualizado = produtoRepository.save(produtoExistente);
        return ProdutoFactory.fromEntity(atualizado);
    }

    @Override
    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ProdutoFactory.fromEntity(produto);
    }

    @Override
    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado para exclusão");
        }
        produtoRepository.deleteById(id);
    }

    private void validarValorProduto(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do produto não pode ser menor ou igual a 0");
        }
    }
}
