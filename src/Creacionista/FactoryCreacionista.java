/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creacionista;

import Alquimistas.Alquimista;
import Factory.AbstracFactoryRazas;
import Heroica.Heroica;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryCreacionista implements AbstracFactoryRazas{

    @Override
    public void getAlquimista(){}

    @Override
    public Heroica getHeroica(String type) {
        return null;
    }

    @Override
    public Creacionista getCreacionista(String type) {
        return new RazaElegida();
    }

    @Override
    public int getVidaEdificioPrincipal() {
        return 0;
    }

    @Override
    public void setFase(int fase) {
        
    }
    
    
    
}
