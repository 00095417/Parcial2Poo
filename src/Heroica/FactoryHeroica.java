/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heroica;

import Alquimistas.Alquimista;
import Creacionista.Creacionista;
import Factory.AbstracFactoryRazas;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryHeroica implements AbstracFactoryRazas{

    @Override
    public void getAlquimista() {}

    @Override
    public Heroica getHeroica(String type) {
        return new RazaElegida();
    }

    @Override
    public Creacionista getCreacionista(String type) {
        return null;
    }
    
    
    
}
