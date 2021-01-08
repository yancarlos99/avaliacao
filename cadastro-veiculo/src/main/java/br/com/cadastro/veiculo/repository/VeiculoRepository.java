package br.com.cadastro.veiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.veiculo.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
