package com.sweet_bites_order_service.dto;

import java.util.Objects;

public class ClientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String country;
    private String phoneNumber;
    private RoleDTO roleDTO;
    private boolean blocked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return blocked == clientDTO.blocked && Objects.equals(id, clientDTO.id) && Objects.equals(name, clientDTO.name) && Objects.equals(surname, clientDTO.surname) && Objects.equals(email, clientDTO.email) && Objects.equals(address, clientDTO.address) && Objects.equals(country, clientDTO.country) && Objects.equals(phoneNumber, clientDTO.phoneNumber) && Objects.equals(roleDTO, clientDTO.roleDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, address, country, phoneNumber, roleDTO, blocked);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roleDTO=" + roleDTO +
                ", blocked=" + blocked +
                '}';
    }
}
