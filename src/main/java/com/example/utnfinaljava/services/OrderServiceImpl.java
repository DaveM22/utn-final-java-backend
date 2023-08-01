package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.OrderDetailDto;
import com.example.utnfinaljava.dtos.OrderDetailReportDto;
import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.dtos.OrderReportDto;
import com.example.utnfinaljava.dtos.OrderViewDto;
import com.example.utnfinaljava.entities.Order;
import com.example.utnfinaljava.entities.OrderDetail;
import com.example.utnfinaljava.entities.ProductSupplier;
import com.example.utnfinaljava.entities.claves_compuestas.OrderId;
import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;
import com.example.utnfinaljava.interfaces.OrderService;
import com.example.utnfinaljava.repositories.OrderDetailRepository;
import com.example.utnfinaljava.repositories.OrderRepository;
import com.example.utnfinaljava.repositories.ProductSupplierRepository;
import com.example.utnfinaljava.util.exceptions.AmountIsZeroOrNullException;
import com.example.utnfinaljava.util.exceptions.StockIsNegativeException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    private final ProductSupplierRepository productoRepository;

    @Override
    public List<OrderViewDto> getOrders() {
        List<Order> entities = orderRepository.findAll();
        List<OrderViewDto> dtos = new ArrayList<OrderViewDto>();
        for (Order order : entities) {
            OrderViewDto dto = new OrderViewDto();
            dto.setOrderNumber(order.getOrderNumber());
            dto.setAmountProducts(order.GetTotalAmount());
            if (order.getParticular() != null) {
                dto.setCustomerName(order.getParticular().getFirstName() + " " + order.getParticular().getLastName());
            }
            else{
                dto.setCustomerName(order.getCompany().getBusinessName());
            }
            dto.setDateFrom(order.getOrderDate());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    @Transactional
    public void createOrder(OrderDto order) {

        boolean anyAmountZero = order.getDetails().stream().anyMatch(n -> n.amount == null || n.amount == 0);
        if (anyAmountZero) {
            throw new AmountIsZeroOrNullException(
                    "No se pueden crear pedidos de productos sin cantidades especificadas");
        }

        boolean anyPriceZeroOrNull = order.getDetails().stream().anyMatch(n -> n.total == null || n.total == 0);
        if (anyPriceZeroOrNull) {
            throw new AmountIsZeroOrNullException("No se pueden crear perdidos de productos sin precios registrados");
        }

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
            detail.setPrice(detailDto.getPrice());
            detail.setId(new OrderId());
            detail.getId().setOrderNumber(save.getOrderNumber());
            detail.getId().setIdPersona(detailDto.getPersonaId());
            detail.getId().setProductId(detailDto.getProductId());
            detail.setTotal(detailDto.getTotal());
            details.add(detail);
            ProductoProveedorId id = new ProductoProveedorId();
            id.setPersonaId(detailDto.getPersonaId());
            id.setProductId(detailDto.getProductId());
            ids.add(id);
        }
        orderDetailRepository.saveAll(details);

        List<ProductSupplier> productSuppliers = productoRepository.findAllById(ids);
        for (OrderDetailDto dto : order.getDetails()) {
            ProductSupplier produtSup = productSuppliers.stream().findFirst()
                    .filter(x -> x.getId().getPersonaId() == dto.getPersonaId()
                            && x.getId().getProductId() == dto.getProductId())
                    .get();
            produtSup.setAmount(produtSup.getAmount() - dto.getAmount());
        }
        boolean productSupplierWithZeroStock = productSuppliers.stream().anyMatch(n -> n.getAmount() < 0);
        if (productSupplierWithZeroStock) {
            throw new StockIsNegativeException(
                    "No se pueden realizar compras donde el stock de los productos finalice por debajo de cero");
        }
        productoRepository.saveAll(productSuppliers);
    }

    @Override
    public OrderReportDto getOrderById(Long id) {
        Order order = this.orderRepository.getReferenceById(id);
        OrderReportDto dto = new OrderReportDto();
        dto.setDiscount(order.getDiscount());
        if(order.getCompany() == null){
            dto.setCustomerName(order.getParticular().getFirstName() + ' ' + order.getParticular().getLastName());
            dto.setDirection(order.getParticular().getCustomer().getPersona().getDirection());
            dto.setEmail(order.getParticular().getCustomer().getPersona().getEmail());
        }
        else{
            dto.setCustomerName(order.getCompany().getBusinessName());
            dto.setDirection(order.getCompany().getCustomer().getPersona().getDirection());
            dto.setEmail(order.getCompany().getCustomer().getPersona().getEmail());
        }
        dto.setDateFrom(order.getOrderDate());
        
        List<OrderDetailReportDto> details = new ArrayList<OrderDetailReportDto>();
        for (OrderDetail detail : order.getDetails()) {
            OrderDetailReportDto detailDto = new OrderDetailReportDto();
            detailDto.setAmount(detail.getAmount());
            detailDto.setProductName(detail.getProduct().getDescription());
            detailDto.setTotal(detail.getTotal());
            detailDto.setPrice(detail.getPrice());
            detailDto.setSupplierName(detail.getSupplier().getBusinessName());
            details.add(detailDto);
        }
        dto.setDetails(details);

        return dto;
    }

}
