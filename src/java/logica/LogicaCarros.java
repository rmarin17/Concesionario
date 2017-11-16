/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import db.CarrosDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import models.Carros;

/**
 *
 * @author RicardoM
 */
public class LogicaCarros {
    
    CarrosDao dao;
    
    public LogicaCarros() {
       dao= new CarrosDao();
    }   
    
    public List<Carros> cargarCarros(){
     List<Carros> carros = new ArrayList<>();
        carros.addAll(dao.cargarCarros());
        return carros;
    }
    
   public void insertarCarros(Carros carro) {
        if (dao.addCar(carro)) {
            System.out.println("Registro completo");
        } else {
            System.out.println("No se puedo registrar correctamente");
        }
    }

    public void resetListaCarros() {
        if (dao.resetList()) {
            System.out.println("Reset exitoso");
        } else {
            System.out.println("no se pudo limpiar la lista");
        }
    }

    public void eliminarCarros(Carros carro) {
        if (dao.deleteCar(carro)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Se selimino correctamente"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "No se pudo eliminar"));
        }
    }
    
     public void editarCarros(Carros carro) {
        if (dao.editCar(carro)) {
            System.out.println("Se edito correctamente");
        } else {
            System.out.println("No se puedo completar la edición");
        }
    }
    
}
