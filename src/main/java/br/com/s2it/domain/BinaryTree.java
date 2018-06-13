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
@Table(name = "tb_binary_tree")
@SequenceGenerator(name = "B_T_SEQ", sequenceName = "BINARY_TREE_SEQ", initialValue=1, allocationSize = 1)
public class BinaryTree implements Serializable {

	private static final long serialVersionUID = -4129239294618090194L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "B_T_SEQ")
	@Column(name = "id")
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "valor")
	@Getter
	@Setter
	private Integer valor;

	@Column(name = "left")
	@Getter
	@Setter
	private BinaryTree left;

	@Column(name = "right")
	@Getter
	@Setter
    private BinaryTree right;
}
