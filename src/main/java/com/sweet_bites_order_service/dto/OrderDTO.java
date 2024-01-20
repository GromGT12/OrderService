package com.sweet_bites_order_service.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderDTO {
    private Integer id;
    private ClientDTO clientDTO;
    private Date orderDate;
    private String status;
    private String comment;
    private List<OrderDetailsDTO> orderDetailsDTOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<OrderDetailsDTO> getOrderDetailsDTOList() {
        return orderDetailsDTOList;
    }

    public void setOrderDetailsDTOList(List<OrderDetailsDTO> orderDetailsDTOList) {
        this.orderDetailsDTOList = orderDetailsDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(clientDTO, orderDTO.clientDTO) && Objects.equals(orderDate, orderDTO.orderDate) && Objects.equals(status, orderDTO.status) && Objects.equals(comment, orderDTO.comment) && Objects.equals(orderDetailsDTOList, orderDTO.orderDetailsDTOList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientDTO, orderDate, status, comment, orderDetailsDTOList);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", clientDTO=" + clientDTO +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                ", orderDetailsDTOList=" + orderDetailsDTOList +
                '}';
    }
}