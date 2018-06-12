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
    private Edificio edificioRecurso;
    private Edificio edificioTropas;
    private RecursosAlquimistas recursoMana = new RecursosAlquimistas("Mana", 2000);
    private RecursosAlquimistas recursoElixir = new RecursosAlquimistas("Elixir", 1000);
    private RecursosAlquimistas recursoCobalto = new RecursosAlquimistas("Cobalto", 1000);
    
    @Override
    public void getAlquimista() {
        if (edificioPrincipal == null){
            setEdificioPrincipal();
        }
        
        System.out.println(edificioPrincipal.getRecurso1().getNombre() + ": " + edificioPrincipal.getRecurso1().getCantidad());
        System.out.println(edificioPrincipal.getRecurso2().getNombre() + ": " + edificioPrincipal.getRecurso2().getCantidad());
        System.out.println(edificioPrincipal.getRecurso3().getNombre() + ": " + edificioPrincipal.getRecurso3().getCantidad());
    
        if (edificioRecurso == null){
            setEdificioRecurso1();
        }
        
        //edificioRecurso.EdificioBuilder
        
    }

    @Override
    public Heroica getHeroica(String type) {
        return null;
    }

    @Override
    public Creacionista getCreacionista(String type) {
        return null;
    }
    
    public Edificio setEdificioPrincipal(){
        
    return null;
    }
    
    public Edificio setEdificioRecurso1(){
        
    return null;    
    }
    
}
