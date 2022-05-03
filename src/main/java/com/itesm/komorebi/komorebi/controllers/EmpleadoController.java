package com.itesm.komorebi.komorebi.controllers;

import com.itesm.komorebi.komorebi.dto.EmpleadoDTO;
import com.itesm.komorebi.komorebi.models.Empleado;
import com.itesm.komorebi.komorebi.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    //Create
    //Insert a tuple
    @PostMapping("/save")
    public EmpleadoDTO save(@RequestBody EmpleadoDTO empleado) throws Exception{
        empleadoService.createEmpleado(empleado);
        return empleado;
    }


    //Read
    //Select 1 tuple
    @GetMapping("/read/{role}/{timestamp}")
    public ResponseEntity<Empleado> getOne(@PathVariable("role") String role, @PathVariable("timestamp") String timestamp){
        if(!empleadoService.existsId(role,timestamp))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(empleadoService.getOne(role,timestamp));
    }


    //Select all tuples
    @GetMapping("/all")
    public ResponseEntity<Iterable<Empleado>> getAll(){
        return ResponseEntity.ok(empleadoService.lista());
    }


    //Update a tuple
    @PutMapping("/update")
    public ResponseEntity<Empleado> update(@RequestBody EmpleadoDTO empleadoDTO){
        if(!empleadoService.existsId(empleadoDTO.getRole(),empleadoDTO.getTimestamp()))
            return new ResponseEntity("no existe, no se puede actualziar", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(empleadoService.update(empleadoDTO));
    }


    //Delete a tuple
    @DeleteMapping("/delete/{role}/{timestamp}")
    public ResponseEntity<?> delete(@PathVariable("role") String role, @PathVariable("timestamp") String timestamp){
        if(!empleadoService.existsId(role, timestamp))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        empleadoService.delete(role,timestamp);
        return new ResponseEntity("empleado eliminado", HttpStatus.OK);
    }
}
