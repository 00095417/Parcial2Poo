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
    private Edificio edificioTropas;
    private RecursosAlquimistas recursoMana = new RecursosAlquimistas("Mana", 2000);
    private RecursosAlquimistas recursoElixir = new RecursosAlquimistas("Elixir", 1000);
    private RecursosAlquimistas recursoCobalto = new RecursosAlquimistas("Cobalto", 1000);
    
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
}
