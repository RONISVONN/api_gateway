package com.ronisvonn.apigateway.controller;

import com.ronisvonn.apigateway.exeption.ResourceNotFoundExceptionPedido;
import com.ronisvonn.apigateway.model.Pedido;
import com.ronisvonn.apigateway.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }
   
    
    @GetMapping("/{numero}")
    public ResponseEntity<Pedido> obterPedidoPorNumero(@PathVariable Integer numero) {
        Optional<Pedido> pedido = pedidoRepository.findByNumero(numero);
        return pedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseThrow(() -> new ResourceNotFoundExceptionPedido("Pedido não encontrado para o número do pedido: " + numero));
    }
    
    
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
}
