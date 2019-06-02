package isi.aepad.tp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.aepad.tp01.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
