/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosruiz.s.world;

import Player.Player;
import java.util.ArrayList;
/**
 *
 * @author Carlos Ruiz
 */
public class CarlosRuizSWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numFase = 0;
        Player player1 = new Player();
        boolean paro = true;
        
        player1.setFase(0);
        player1.eleccionRaza();
        
        do{
            player1.jugar();
            player1.setFase(numFase+=1);
            System.out.println("------Fin fase " + numFase + "------");
            if (numFase==5){
                paro = false;
            }
        }
        while(player1.getVidaEdificioPrincipal()>0&& paro);        
    }
    
}
