package com.apex.carapp.repositories;

import com.apex.carapp.entities.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<CarPart, Long> {


}
