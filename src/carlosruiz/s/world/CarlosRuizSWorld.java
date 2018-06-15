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
        Player player2 = new Player();
        
        player1.setFase(0);
        player1.eleccionRaza();
        player2.setFase(0);
        player2.eleccionRaza();
        
        do{
            player1.setFase(numFase+=1);
            player1.setFasejuego();
            player1.jugar();
            player2.setFase(numFase);
            player2.setFasejuego();
            player2.jugar();
            System.out.println("------Fin fase " + numFase + "------");
        }
        while(player1.getVidaEdificioPrincipal()>0&& player2.getVidaEdificioPrincipal()>0);        
    }
    
}
