package com.fatec.itu.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.itu.product.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
