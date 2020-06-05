package atividade.projeto_final_lucas_amorim_180045.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import atividade.projeto_final_lucas_amorim_180045.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}