/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heroica;

/**
 *
 * @author Carlos Ruiz
 */
public class RazaElegida implements Heroica{

    @Override
    public String heroica(String type) {
        return "Soy un " + type;
    }
    
}
