package com.innova.repository;

import com.innova.entity.ComputerEntity;
import org.springframework.data.repository.CrudRepository;

//Long -> id nin tipi
public interface ComputerRepository extends CrudRepository<ComputerEntity,Long> {

}
