package org.concesionaria.concesionaria.repository;

import org.concesionaria.concesionaria.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, String> {
}
