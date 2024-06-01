package com.ronisvonn.apigateway.repository;

import com.ronisvonn.apigateway.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findByNumero(Integer numero);
}