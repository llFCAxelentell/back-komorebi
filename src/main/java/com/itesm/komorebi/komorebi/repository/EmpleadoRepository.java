package com.itesm.komorebi.komorebi.repository;

import com.itesm.komorebi.komorebi.models.Empleado;
import com.itesm.komorebi.komorebi.models.EmpleadoID;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface EmpleadoRepository extends CrudRepository<Empleado, EmpleadoID> {
}