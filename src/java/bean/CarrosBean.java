/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logica.LogicaCarros;
import models.Carros;

/**
 *
 * @author RicardoM
 */


@ManagedBean
@ViewScoped
public class CarrosBean {
    
    private Carros carro; 
    private List<Carros> listCar;
    private Carros selectedCar;
    private LogicaCarros logicaCarros;

    public Carros getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Carros selectedCar) {
        this.selectedCar = selectedCar;
    }
        
    public CarrosBean() {
        carro = new Carros();
        listCar = new ArrayList<>();
        logicaCarros= new LogicaCarros();
        cargarCarros();
    }

   

    public LogicaCarros getLogicaCarros() {
        return logicaCarros;
    }

    public void setLogicaCarros(LogicaCarros logicaCarros) {
        this.logicaCarros = logicaCarros;
    }

    public Carros getCarro() {
        return carro;
    }

    public void setCarro(Carros carro) {
        this.carro = carro;
    }

    public List<Carros> getListCar() {
        return listCar;
    }

    public void setListCar(List<Carros> listCar) {
        this.listCar = listCar;
    }
    
    public void cargarCarros(){
    listCar.addAll(logicaCarros.cargarCarros());
    }
    
     public void registrarCarros() {
               
        logicaCarros.insertarCarros(carro);
        listCar.clear();
        cargarCarros();
    }
     
    public void editarCarros(Carros selectedCar) {
               
        logicaCarros.editarCarros(selectedCar );
        listCar.clear();
        cargarCarros();
    }
    
    public void resetLista(){
       logicaCarros.resetListaCarros();
       listCar.clear();
       cargarCarros();
    }
    
    public void eliminarCarros(){
        logicaCarros.eliminarCarros(carro);
        listCar.clear();
        cargarCarros();
    }
    
    
    
}
