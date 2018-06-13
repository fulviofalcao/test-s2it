package br.com.s2it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.s2it.domain.CalculateC;

@Repository
public interface CalculateCRepository extends JpaRepository<CalculateC, Long>{

}
