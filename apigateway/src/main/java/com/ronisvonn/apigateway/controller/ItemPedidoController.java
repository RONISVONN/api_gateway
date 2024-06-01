package com.ronisvonn.apigateway.controller;

import com.ronisvonn.apigateway.exeption.ResourceNotFoundExceptionItemPedido;
import com.ronisvonn.apigateway.model.ItemPedido;
import com.ronisvonn.apigateway.model.Pedido;
import com.ronisvonn.apigateway.repository.ItemPedidoRepository;
import com.ronisvonn.apigateway.repository.PedidoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedido/{numero}/item")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> getItemPedidos(@PathVariable Long numero) {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findByNumeroNumero(numero);
        if (itemPedidos.isEmpty()) {
            throw new ResourceNotFoundExceptionItemPedido("Itens de pedido não encontrados para o número do pedido: " + numero);
        }
        return ResponseEntity.ok(itemPedidos);
    }
  
    
    @PostMapping
    public ResponseEntity<ItemPedido> createItemPedido(@PathVariable Integer numero, @RequestBody ItemPedido itemPedido) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findByNumero(numero);
        if (!pedidoOptional.isPresent()) {
            throw new ResourceNotFoundExceptionItemPedido("Pedido não encontrado para o número: " + numero);
        }

        Pedido pedido = pedidoOptional.get();
        itemPedido.setNumero(pedido);

        ItemPedido savedItemPedido = itemPedidoRepository.save(itemPedido);
        return ResponseEntity.ok(savedItemPedido);
    }
}

