package br.com.s2it.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_calc")
@SequenceGenerator(name = "CALC_SEQ", sequenceName = "CALCULATE_SEQ", initialValue=1, allocationSize = 1)
public class CalculateC implements Serializable {

	private static final long serialVersionUID = -8750385055305486649L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CALC_SEQ")
	@Column(name = "id")
	@Getter
	@Setter
	private Long id;

	@Column(name = "number1")
	@Getter
	@Setter
	private Integer number1;

	@Column(name = "number2")
	@Getter
	@Setter
	private Integer number2;

}
