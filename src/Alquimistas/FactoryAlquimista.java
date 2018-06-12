/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;

import Creacionista.Creacionista;
import Factory.AbstracFactoryRazas;
import Heroica.Heroica;
import java.util.ArrayList;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryAlquimista implements AbstracFactoryRazas {
    
    private final Menu menuAlquimista = Menu.getInstance();
    private Edificio edificioPrincipal;
    private Edificio edificioRecurso = new Edificio();
    private Edificio edificioTropas = new Edificio();
    private Edificio edificioVehiculo = new Edificio();
    private RecursosAlquimistas recursoMana = new RecursosAlquimistas("Mana", 2000);
    private RecursosAlquimistas recursoElixir = new RecursosAlquimistas("Elixir", 1000);
    private RecursosAlquimistas recursoCobalto = new RecursosAlquimistas("Cobalto", 1000);
    private ArrayList<Edificio> listaEdificioRecurso = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioTropas = new ArrayList<>();
    
    @Override
    public void getAlquimista() {
        if (edificioPrincipal == null){
            setEdificioPrincipal();
        }
        
        System.out.println("Recurso actual......");
        System.out.println(edificioPrincipal.getRecurso1().getNombre() + ": " + edificioPrincipal.getRecurso1().getCantidad());
        System.out.println(edificioPrincipal.getRecurso2().getNombre() + ": " + edificioPrincipal.getRecurso2().getCantidad());
        System.out.println(edificioPrincipal.getRecurso3().getNombre() + ": " + edificioPrincipal.getRecurso3().getCantidad());
  
        setEdificioRecurso("mana");
        
        System.out.println("--------");
        System.out.println(edificioRecurso.getNombre());
        System.out.println("----------");
        
        if (edificioPrincipal.getRecurso2().getCantidad()>edificioRecurso.getCosto2()&&
            edificioPrincipal.getRecurso3().getCantidad()>edificioRecurso.getCosto3()){
            edificioPrincipal.getRecurso2().setCantidad(edificioPrincipal.getRecurso2().getCantidad()-edificioRecurso.getCosto2());
            edificioPrincipal.getRecurso3().setCantidad(edificioPrincipal.getRecurso3().getCantidad()-edificioRecurso.getCosto3());
        }
        else{
            System.out.println("Recurso Insuficiente");
        }
        
        System.out.println("Recurso actual......");
        System.out.println(edificioPrincipal.getRecurso1().getNombre() + ": " + edificioPrincipal.getRecurso1().getCantidad());
        System.out.println(edificioPrincipal.getRecurso2().getNombre() + ": " + edificioPrincipal.getRecurso2().getCantidad());
        System.out.println(edificioPrincipal.getRecurso3().getNombre() + ": " + edificioPrincipal.getRecurso3().getCantidad());
        
    }

    @Override
    public Heroica getHeroica(String type) {
        return null;
    }

    @Override
    public Creacionista getCreacionista(String type) {
        return null;
    }
    
    //Creando el Centro de Mando
    public void setEdificioPrincipal(){
        edificioPrincipal = new Edificio();
        edificioPrincipal.EdificioP("Abadia", recursoMana, recursoElixir, recursoCobalto, 
                                    500, 100, 100, 100, 10000, 5000, 5000, 1);
    }
    //Creando los edificios que te generan recursos
    public void setEdificioRecurso(String recurso){
        
        int rAux;
        
        switch(recurso){
            
            case "mana":
                rAux = recursoMana.getCantidad();
                recursoMana.setCantidad(0);
                edificioRecurso.EdificioR("Generador de Mana", recursoMana, 1000, 0, 50, 50, 500, 3, 100);
                recursoMana.setCantidad(rAux);
                break;
                
            case "elixir":
                rAux = recursoElixir.getCantidad();
                recursoElixir.setCantidad(0);
                edificioRecurso.EdificioR("Recolector de Elixir", recursoElixir, 1000, 50, 0, 50, 500, 3, 100);
                recursoElixir.setCantidad(rAux);
                break;
                
            case "cobalto":
                rAux = recursoCobalto.getCantidad();
                recursoCobalto.setCantidad(0);
                edificioRecurso.EdificioR("Recolector de Cobalto", recursoCobalto, 1000, 50, 50, 0, 500, 3, 100);
                recursoCobalto.setCantidad(rAux);
                break;                      
        }
    }
    //Creando las Guarniciones que crearan las tropas
    public void setEdificoTropa(String guarnicio){
        
        TropasAlquimistas tropa = new TropasAlquimistas();
        
        switch(guarnicio){
            case "gremio":
                tropa.TropasAlquimistas("Gremio", 100, 35, 25, 10, 10, 5);
                edificioTropas.EdificioT("Guarnicio de Gremios", tropa, 150, 75, 75, 75, 2);
                break;
            case "magos":
                tropa.TropasAlquimistas("Magos", 10, 7, 6, 5, 5, 0);
                edificioTropas.EdificioT("Guarnicio de Magos", tropa, 100, 50, 50, 50, 5);
                break;
            case "especial":
                tropa.TropasAlquimistas("Chaman", 100, 50, 50, 50, 50, 1);
        }
    }
    //Creando los Talleres que crearan los vehiculos
    public void setEdificioVehiculo(String taller){
    
        VehiculosAlquimistas vehiculo = new VehiculosAlquimistas();
        
        switch (taller){
            case "aerodeslizador":
                vehiculo.VehiculosAlquimistas("Aerodeslizador", 100, 30, 0, 25, 25);
                edificioVehiculo.EdificioV("Taller de Aerodeslizadores", vehiculo, 100, 100, 100, 100, 1);
                break;
            case "espejo de fuego":
                vehiculo.VehiculosAlquimistas("Espejo de Fuego", 100, 30, 0, 25, 25);
                edificioVehiculo.EdificioV("Taller de Espejos de Fuego", vehiculo, 100, 100, 100, 100, 1);
                break;
        }
    }
}
