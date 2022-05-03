package com.itesm.komorebi.komorebi.service;

import com.itesm.komorebi.komorebi.dto.EmpleadoDTO;
import com.itesm.komorebi.komorebi.models.Empleado;
import com.itesm.komorebi.komorebi.models.EmpleadoID;
import com.itesm.komorebi.komorebi.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    //Create
    public void createEmpleado(final EmpleadoDTO empleado){
        Empleado e = new Empleado();
        e.setRole(empleado.getRole());
        e.setTimestamp(empleado.getTimestamp());
        e.setName_staff(empleado.getName_staff());
        e.setActive(empleado.getActive());
        e.setEmail(empleado.getEmail());
        e.setPassword(empleado.getPassword());
        e.setPhone(empleado.getPhone());
        e.setAgents_name(empleado.getAgents_name());
        e.setLast_session(empleado.getLast_session());
        empleadoRepository.save(e);
    }

    //READ
    public Iterable<Empleado> lista(){
        return empleadoRepository.findAll();
    }
    public Empleado getOne(String role, String timestamp){
        EmpleadoID empleadoID = new EmpleadoID(role, timestamp);
        return empleadoRepository.findById(empleadoID).get();
    }
    public boolean existsId(String role, String timestamp){
        EmpleadoID empleadoID = new EmpleadoID(role, timestamp);
        return empleadoRepository.existsById(empleadoID);
    }

    //UPDATE
    public Empleado update(EmpleadoDTO empleadoDTO){
        EmpleadoID empleadoID = new EmpleadoID(empleadoDTO.getRole(), empleadoDTO.getTimestamp());
        Empleado empleado = empleadoRepository.findById(empleadoID).get();
        empleado.setRole(empleadoDTO.getRole());
        empleado.setTimestamp(empleadoDTO.getTimestamp());
        empleado.setName_staff(empleadoDTO.getName_staff());
        empleado.setActive(empleadoDTO.getActive());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setPassword(empleadoDTO.getPassword());
        empleado.setPhone(empleadoDTO.getPhone());
        empleado.setAgents_name(empleadoDTO.getAgents_name());
        empleado.setLast_session(empleadoDTO.getLast_session());
        return empleadoRepository.save(empleado);
    }

    //DELETE
    public void delete(String role, String timestamp){
        EmpleadoID empleadoID = new EmpleadoID(role,timestamp);
        empleadoRepository.deleteById(empleadoID);
    }
}
