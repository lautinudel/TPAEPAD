package isi.aepad.tp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.aepad.tp01.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
