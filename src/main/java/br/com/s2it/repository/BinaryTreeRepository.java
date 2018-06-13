package br.com.s2it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.s2it.domain.BinaryTree;

@Repository
public interface BinaryTreeRepository extends JpaRepository<BinaryTree, Long>{

}
