package org.concesionaria.concesionaria.repository;

import org.concesionaria.concesionaria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
