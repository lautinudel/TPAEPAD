package isi.aepad.tp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.aepad.tp01.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
