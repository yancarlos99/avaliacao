package br.com.cadastro.veiculo.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "{campo.veiculo.obrigatorio}")
	private String veiculo;
	
	@NotEmpty(message = "{campo.marca.obrigatorio}")
	private String marca;
	
	@NotNull
	private Integer ano;
	
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	private Boolean vendido;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime created;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime update;
	
	@PrePersist
	public void prePersist() {
		setCreated(LocalDateTime.now());
	} 
	

}
