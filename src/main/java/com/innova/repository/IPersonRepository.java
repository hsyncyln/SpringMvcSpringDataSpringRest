package com.innova.repository;

import com.innova.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface IPersonRepository extends PagingAndSortingRepository<PersonEntity,Long> {
}
