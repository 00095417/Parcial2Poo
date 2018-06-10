/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Alquimistas.Alquimista;
import Creacionista.Creacionista;
import Heroica.Heroica;

/**
 *
 * @author Carlos Ruiz
 */
public interface AbstracFactoryRazas {
    
    Alquimista getAlquimista(String type);
    Heroica getHeroica(String type);
    Creacionista getCreacionista(String type);
    
    
}
