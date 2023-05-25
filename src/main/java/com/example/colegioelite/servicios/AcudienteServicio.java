package com.example.colegioelite.servicios;

import com.example.colegioelite.entidades.Acudiente;
import com.example.colegioelite.repositorios.AcudienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcudienteServicio implements ServicioBase<Acudiente> {

    @Autowired
    protected AcudienteRepositorio acudienteRepositorio;
    @Override
    public List<Acudiente> buscarTodos() throws Exception {
        try{

            return acudienteRepositorio.findAll();


        }catch (Exception error){
           throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente buscarPorId(Integer id) throws Exception {
        try {
            Optional<Acudiente>acudienteOpcional = acudienteRepositorio.findById(id);
            if (acudienteOpcional.isPresent()){
                return acudienteOpcional.get();
            }
            else {
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente registrar(Acudiente datosARegistrar) throws Exception {
        try {

            Acudiente acudienteGuardado = acudienteRepositorio.save(datosARegistrar);
            return acudienteGuardado;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente actualizar(Integer id, Acudiente datosNuevos) throws Exception {
        try{

            Optional<Acudiente>acudienteOpcional = acudienteRepositorio.findById(id);
            if (acudienteOpcional.isPresent()){
                Acudiente acudienteExistente = acudienteOpcional.get();
                acudienteExistente.setNombre(datosNuevos.getNombre());
                acudienteExistente.setTelefono(datosNuevos.getTelefono());
                Acudiente acudienteActualizado = acudienteRepositorio.save(acudienteExistente);
                return acudienteActualizado;
            }
            else {
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{

            Optional<Acudiente>acudienteOpcional = acudienteRepositorio.findById(id);
            if (acudienteOpcional.isPresent()){
                acudienteRepositorio.deleteById(id);
                return true;
            }
            else {
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
