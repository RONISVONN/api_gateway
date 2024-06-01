package com.ronisvonn.apigateway.repository;

import com.ronisvonn.apigateway.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByNumeroNumero(Long numero);
}