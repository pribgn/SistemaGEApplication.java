package org.educadventista.Sistema.GE.service;

import org.educadventista.Sistema.GE.entity.Pedido;
import org.educadventista.Sistema.GE.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido updatePedido(Long id, Pedido updatedPedido) {
        Optional<Pedido> existingPedidoOptional = pedidoRepository.findById(id);
        if (existingPedidoOptional.isPresent()) {
            Pedido existingPedido = existingPedidoOptional.get();
            if (updatedPedido.getProduto() != null) {
                existingPedido.setProduto(updatedPedido.getProduto());
            }
            if (updatedPedido.getQuantidade() != 0) {
                existingPedido.setQuantidade(updatedPedido.getQuantidade());
            }
            if (updatedPedido.getPreco() != 0) {
                existingPedido.setPreco(updatedPedido.getPreco());
            }
            if (updatedPedido.getFornecedor() != null) {
                existingPedido.setFornecedor(updatedPedido.getFornecedor());
            }
            return pedidoRepository.save(existingPedido);
        } else {
            throw new RuntimeException("Pedido not found with id: " + id);
        }
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}