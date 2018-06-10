/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Alquimistas.FactoryAlquimista;
import Creacionista.FactoryCreacionista;
import Heroica.FactoryHeroica;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryProducerRazas {
    
    public static AbstracFactoryRazas getFactory(String type){
        
        switch(type){
            case "1":
                return new FactoryAlquimista();
            case "2":
                return new FactoryCreacionista();
            case "3":
                return new FactoryHeroica();
            default:
                return null;
        }
    }
    
}
