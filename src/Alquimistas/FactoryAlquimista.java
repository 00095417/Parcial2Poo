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
    
    @Override
    public void getAlquimista() {
        if (edificioPrincipal == null){
            setEdificioPrincipal();
        }
        menuAlquimista.mostrar();
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
        
        RecursoAlquimista recursoMana = new RecursoAlquimista("Mana", 2000);
        RecursoAlquimista recursoElixir = new RecursoAlquimista("Elixir", 1000);
        RecursoAlquimista recursoCobalto = new RecursoAlquimista("Cobalto", 1000);
        
        return edificioPrincipal = new Edificio.EdificioBuilder("Abadia")
                .recurso1(recursoMana).recurso2(recursoElixir).recurso3(recursoCobalto)
                .capacidad_recurso1(10000).capacidad_recurso2(5000).capacidad_recurso3(5000)
                .vida(350).build();
    }
    
}
