package com.proyectoCitas.proyectoCitas.repository;

import com.proyectoCitas.proyectoCitas.entity.Client;
import com.proyectoCitas.proyectoCitas.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from client where state = 1")
    List<Client> getActiveClient();
}
