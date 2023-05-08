package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.OrderDetailDto;
import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.entities.Order;
import com.example.utnfinaljava.entities.OrderDetail;
import com.example.utnfinaljava.entities.ProductSupplier;
import com.example.utnfinaljava.entities.claves_compuestas.OrderId;
import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;
import com.example.utnfinaljava.interfaces.OrderService;
import com.example.utnfinaljava.interfaces.ProductSupplierService;
import com.example.utnfinaljava.repositories.OrderDetailRepository;
import com.example.utnfinaljava.repositories.OrderRepository;
import com.example.utnfinaljava.repositories.ProductSupplierRepository;
import com.example.utnfinaljava.repositories.ProductoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    private final ProductSupplierRepository productoRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<OrderDto> getOrders() {
        var entities = orderRepository.findAll();
        List<OrderDto> dtos = entities.stream().map(a -> modelMapper.map(a, OrderDto.class))
        .collect(Collectors.toList());
        return dtos;
    }

    @Override
    @Transactional
    public void createOrder(OrderDto order) {
       Order obj = new Order();
       obj.setOrderNumber(0L);
       obj.setOrderDate(order.getDate());
       obj.setPersonaId(order.getPersonaId());
       Order save = orderRepository.save(obj);
       List<OrderDetail> details = new ArrayList<OrderDetail>();
       List<ProductoProveedorId> ids = new ArrayList<ProductoProveedorId>();
       for (OrderDetailDto detailDto : order.getDetails()) {
            OrderDetail detail = new OrderDetail();
            detail.setAmount(detailDto.getAmount());
            detail.setId(new OrderId());
            detail.getId().setOrderNumber(save.getOrderNumber());
            detail.getId().setIdPersona(detailDto.getPersonaId());
            detail.getId().setProductId(detailDto.getProductId());
            detail.setTotal(detailDto.getTotal());
            details.add(detail);
            ProductoProveedorId id = new ProductoProveedorId();
            id.setIdPersona(detailDto.getPersonaId());
            id.setProducto(detailDto.getProductId());
            ids.add(id);
       }
       orderDetailRepository.saveAll(details);

       List<ProductSupplier> productSuppliers = productoRepository.findAllById(ids);
       for (OrderDetailDto dto : order.getDetails()) {
            ProductSupplier produtSup = productSuppliers.stream().findFirst().filter(x 
            -> x.getId().getIdPersona() == dto.getPersonaId() && x.getId().getProducto() == dto.getProductId()).get();
            produtSup.setCantidad(produtSup.getCantidad() - dto.getAmount());
       }
       productoRepository.saveAll(productSuppliers);
    }
    
}
