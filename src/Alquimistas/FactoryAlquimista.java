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
    private Edificio edificioPrincipal = new Edificio();
    private Edificio edificioRecurso = new Edificio();
    private Edificio edificioTropas = new Edificio();
    private RecursoAlquimista recursoMana = new RecursoAlquimista("Mana", 2000);
    private RecursoAlquimista recursoElixir = new RecursoAlquimista("Elixir", 1000);
    private RecursoAlquimista recursoCobalto = new RecursoAlquimista("Cobalto", 1000);
    
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
        edificioPrincipal.setNombre("Abadia");
        edificioPrincipal.setRecurso1(recursoMana);
        edificioPrincipal.setRecurso2(recursoElixir);
        edificioPrincipal.setRecurso3(recursoCobalto);
        edificioPrincipal.setCapacidad_recurso1(10000);
        edificioPrincipal.setCapacidad_recurso2(5000);
        edificioPrincipal.setCapacidad_recurso3(5000);
        edificioPrincipal.setNivel(1);
        edificioPrincipal.setVida(350);
        return edificioPrincipal;
    }
    
}
