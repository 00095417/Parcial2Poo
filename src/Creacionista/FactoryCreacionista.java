/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creacionista;

import Factory.AbstracFactoryRazas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author Carlos Ruiz
 */
public class FactoryCreacionista implements AbstracFactoryRazas{
    
    private final Menu menuCreacionista = Menu.getInstance();
    private Edificio edificioPrincipal;
    private Edificio edificioRecurso = new Edificio();
    private Edificio edificioTropas = new Edificio();
    private Edificio edificioVehiculo = new Edificio();
    private Edificio aux = new Edificio();
    private ArrayList<Edificio> listaEdificioRecurso = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioGuarnicion = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioTalleres = new ArrayList<>();
    private ArrayList<Edificio> edificiosEnEspera = new ArrayList<>();
    private int fase;
    private boolean continuar = true;
    Scanner entrada = new Scanner(System.in);

    @Override
    public void getAlquimista(){}

    @Override
    public void getHeroica() {}

    @Override
    public void getCreacionista() 
    {
        if (edificioPrincipal == null)
        {
            setEdificioPrincipal();
        }
        System.out.println("Fase actual: " + this.fase);
        menus();
    }

    @Override
    public int getVidaEdificioPrincipal() {
        return edificioPrincipal.getVida();
    }

    @Override
    public void setFase(int fase) {
        this.fase = fase;
    }
    
    public void setEdificioPrincipal(){
        edificioPrincipal = new Edificio();
        edificioPrincipal.EdificioP("Cantera","Granito","Ether","Carbono", 
                                    500, 2000, 1000, 1000, 100, 100, 100, 10000, 5000, 5000, 1);
    }
    
    public void setEdificioRecurso(String recurso){
        
        switch(recurso)
        {
            
            case "mana":
                edificioRecurso.EdificioR("Generador de Granito", "Granito", 1000, 0, 0, 50, 50, 500, 3, 100, this.fase);
                break;
                
            case "elixir":
                edificioRecurso.EdificioR("Recolector de Ether", "Ether", 1000, 0, 50, 0, 50, 500, 3, 100, this.fase);
                break;
                
            case "cobalto":
                edificioRecurso.EdificioR("Recolector de Carbono", "Carbono", 1000, 0, 50, 50, 0, 500, 3, 100, this.fase);
                break;                      
        }
    }
    
    public void setEdificioTropa(String guarnicio){
        
        TropasCreacionista tropa = new TropasCreacionista();
        
        switch(guarnicio)
        {
            case "gremio":
                tropa.TropasCreacionista("Incursion", 100, 35, 25, 10, 10, 5,0);
                edificioTropas.EdificioT("Guarnicion de Incursion", tropa, 150, 75, 75, 75, 2, this.fase,4);
                break;
            case "magos":
                tropa.TropasCreacionista("Reclutas", 10, 7, 6, 5, 5, 0,0);
                edificioTropas.EdificioT("Guarnicion de Reclutas", tropa, 100, 50, 50, 50, 5, this.fase,4);
                break;
            case "especial":
                tropa.TropasCreacionista("Inquisidor", 100, 50, 50, 0, 50, 50,0);
                edificioTropas.EdificioT("Guarnicion Especial", tropa, 100, 75, 75, 75, 1, this.fase, 4);
                break;
        }
    }
    
    public void setEdificioVehiculo(String taller){
    
        VehiculosCreacionista vehiculo = new VehiculosCreacionista();
        
        switch (taller)
        {
            case "aerodeslizador":
                vehiculo.VehiculosCreacionista("Demoledor", 100, 30, 0, 25, 25,0);
                edificioVehiculo.EdificioV("Taller de Demoledor", vehiculo, 100, 100, 100, 100, 1, this.fase, 4);
                break;
            case "espejo de fuego":
                vehiculo.VehiculosCreacionista("Helicoptero", 100, 30, 0, 25, 25,0);
                edificioVehiculo.EdificioV("Taller de Helicoptero", vehiculo, 100, 100, 100, 100, 1, this.fase, 4);
                break;
        }
    }
    
    public void mostrarRaza(){
              
        System.out.println("------Raza Alquimista------");
        System.out.println("---------Recursos----------");
        System.out.println(edificioPrincipal.getGranito() + ": " + edificioPrincipal.getCantidadGranito());
        System.out.println(edificioPrincipal.getEther() + ": " + edificioPrincipal.getCantidadEther());
        System.out.println(edificioPrincipal.getCarbono() + ": " + edificioPrincipal.getCantidadCarbono());
        
        System.out.println("---------Edificios---------");
        if (listaEdificioRecurso.isEmpty())
        {
            System.out.println("No hay edificios que generen recursos");
        }
        else{
            for (Edificio edificioR: listaEdificioRecurso)
            {
                if("Generador de Granito".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getProduccion()*(this.fase-edificioR.getFaseCreacion()));
                }
                if("Recolector de Ether".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadEther());
                }
                if("Recolector de Carbono".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadCarbono());
                }   
            }
        }
        if (listaEdificioGuarnicion.isEmpty())
        {
            System.out.println("No hay guarniciones");
        }
        else{
            int pos = 0;
            for (Edificio g:listaEdificioGuarnicion)
            {
                System.out.println((pos +=1) +". "+g.getNombre()); 
            }
        }
        if (listaEdificioTalleres.isEmpty())
        {
            System.out.println("No hay talleres");
        }
        else{
            int pos = 0;
            for (Edificio edificioT: listaEdificioTalleres)
            {
                System.out.println((pos += 1) +". "+edificioT.getNombre());
            }
        }
        
        System.out.println("----Edificios en espera----");
        
        if (edificiosEnEspera.isEmpty())
        {
            System.out.println("No tienes edificios en espera para usar");
        }
        else
        {
            Iterator<Edificio> e = edificiosEnEspera.iterator();
            
            while(e.hasNext())
            {
                aux = e.next();
                if((aux.getFaseCreacion()+aux.getTiempo_espera())==this.fase)
                {
                    if ("Generador de Granito".equals(aux.getNombre()))
                    {
                        listaEdificioRecurso.add(aux);
                        e.remove();
                    }
                    if ("Recolector de Ether".equals(aux.getNombre()))
                    {
                        listaEdificioRecurso.add(aux);
                        e.remove();
                    }
                    if ("Recolector de Carbono".equals(aux.getNombre()))
                    {
                        listaEdificioRecurso.add(aux);
                        e.remove();
                    }
                    if ("Guarnicion de Incursion".equals(aux.getNombre()))
                    {
                        listaEdificioGuarnicion.add(aux);
                        e.remove();
                    }
                    if ("Guarnicion de Reclutas".equals(aux.getNombre()))
                    {
                        listaEdificioGuarnicion.add(aux);
                        e.remove();
                    }
                    if ("Guarnicion Especial".equals(aux.getNombre()))
                    {
                        listaEdificioGuarnicion.add(aux);
                        e.remove();
                    }
                    if ("Taller de Demoledor".equals(aux.getNombre()))
                    {
                        listaEdificioTalleres.add(aux);
                        e.remove();
                    }
                    if ("Taller de Helicopteros".equals(aux.getNombre()))
                    {
                        listaEdificioTalleres.add(aux);
                        e.remove();
                    }
                }
                else
                {   
                    System.out.println(aux.getNombre()+", tiempo de espera "+aux.getTiempo_espera()
                                        +" fases"+", fase de creacion "+aux.getFaseCreacion()+", fase actual "+this.fase);
                }
            }
        }
        
        System.out.println("---------Tropas------------");
        if (listaEdificioGuarnicion.isEmpty())
        {
            System.out.println("No hay guarniciones");
        }
        else{
            for (Edificio g:listaEdificioGuarnicion)
            {
                System.out.println(g.getTropa().getNombreTropa() +" "+ g.getTropa().getCantidad()); 
            }
        }
        if (listaEdificioTalleres.isEmpty())
        {
            System.out.println("No hay talleres");
        }
        else{
            for (Edificio t:listaEdificioTalleres)
            {
                System.out.println(t.getVehiculo().getNombreVehiculo()+" "+t.getVehiculo().getCantidad());
            }
        }
    }
    
    public void menus(){
        continuar = true;
        while(continuar)
        {
            mostrarRaza();
            menuCreacionista.menuPrincipal();
            
             switch(entrada.nextLine())
            {
                //Menú que te muestra los edificios que se pueden crear y las condiciones para poder hacerlo
                case "1":
                    switch (menuCreacionista.menuEdificios())
                    {
                        case "Generador de Granito":
                            setEdificioRecurso("granito");
                            if (edificioPrincipal.getCantidadEther()>edificioRecurso.getCosto2()&&
                                edificioPrincipal.getCantidadCarbono()>edificioRecurso.getCosto3())
                            {    
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()-edificioRecurso.getCosto2());
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()-edificioRecurso.getCosto3());
                                edificiosEnEspera.add(edificioRecurso);
                                edificioRecurso = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Recolector de Ether":
                            setEdificioRecurso("ether");
                            if (edificioPrincipal.getCantidadGranito()>edificioRecurso.getCosto1()&&
                                edificioPrincipal.getCantidadCarbono()>edificioRecurso.getCosto3())
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()-edificioRecurso.getCosto1());
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()-edificioRecurso.getCosto3());
                                edificiosEnEspera.add(edificioRecurso);
                                edificioRecurso = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Recolector de Carbono":
                            setEdificioRecurso("carbono");
                            if (edificioPrincipal.getCantidadGranito()>edificioRecurso.getCosto1()&&
                                edificioPrincipal.getCantidadEther()>edificioRecurso.getCosto2())
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()-edificioRecurso.getCosto1());
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()-edificioRecurso.getCosto2());
                                edificiosEnEspera.add(edificioRecurso);
                                edificioRecurso = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Guarnicion de Incursion":
                            setEdificioTropa("incursion");
                            if (edificioPrincipal.getCantidadGranito()>edificioTropas.getCosto1()&&
                                edificioPrincipal.getCantidadEther()>edificioTropas.getCosto2()&&
                                edificioPrincipal.getCantidadCarbono()>edificioTropas.getCosto3())
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- edificioTropas.getCosto1());
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- edificioTropas.getCosto2());
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- edificioTropas.getCosto3());
                                edificiosEnEspera.add(edificioTropas);
                                edificioTropas = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Guarnicion de Reclutas":
                             setEdificioTropa("recluta");
                            if (edificioPrincipal.getCantidadGranito()>edificioTropas.getCosto1()&&
                                edificioPrincipal.getCantidadEther()>edificioTropas.getCosto2()&&
                                edificioPrincipal.getCantidadCarbono()>edificioTropas.getCosto3())
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- edificioTropas.getCosto1());
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- edificioTropas.getCosto2());
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- edificioTropas.getCosto3());
                                edificiosEnEspera.add(edificioTropas);
                                edificioTropas = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Guarnicion Especial":
                             setEdificioTropa("especial");
                            if (edificioPrincipal.getCantidadGranito()>edificioTropas.getCosto1()&&
                                edificioPrincipal.getCantidadEther()>edificioTropas.getCosto2()&&
                                edificioPrincipal.getCantidadCarbono()>edificioTropas.getCosto3())
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- edificioTropas.getCosto1());
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- edificioTropas.getCosto2());
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- edificioTropas.getCosto3());
                                edificiosEnEspera.add(edificioTropas);
                                edificioTropas = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Taller de Demoledor":
                             setEdificioVehiculo("demoledor");
                            if (edificioPrincipal.getCantidadGranito()>edificioVehiculo.getCosto1()&&
                                edificioPrincipal.getCantidadEther()>edificioVehiculo.getCosto2()&&
                                edificioPrincipal.getCantidadCarbono()>edificioVehiculo.getCosto3())
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- edificioVehiculo.getCosto1());
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- edificioVehiculo.getCosto2());
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- edificioVehiculo.getCosto3());
                                edificiosEnEspera.add(edificioVehiculo);
                                edificioVehiculo = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Taller de Helicoptero":
                            setEdificioVehiculo("helicoptero");
                            if (edificioPrincipal.getCantidadGranito()>edificioVehiculo.getCosto1()&&
                                edificioPrincipal.getCantidadEther()>edificioVehiculo.getCosto2()&&
                                edificioPrincipal.getCantidadCarbono()>edificioVehiculo.getCosto3())
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- edificioVehiculo.getCosto1());
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- edificioVehiculo.getCosto2());
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- edificioVehiculo.getCosto3());
                                edificiosEnEspera.add(edificioVehiculo);
                                edificioVehiculo = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;      
                    }
                    break;
                //Menú que te muestra las tropas a crear y las condiciones para hacerlo
                case "2":
                    switch(menuCreacionista.menuTropas())
                    {
                        case "Incursion":
                            if (listaEdificioGuarnicion.isEmpty())
                            {
                                System.out.println("No dispone de Guarniciones");
                                break;
                            }
                            else{
                                System.out.println("Elija que guarnicion usar:");
                                int index = entrada.nextInt();

                                if ("Guarnicion de Incursion".equals(listaEdificioGuarnicion.get(index-1).getNombre())&&index>0)
                                {
                                    TropasCreacionista tropaAux = listaEdificioGuarnicion.get(index-1).getTropa();
                                    System.out.println("Cantidad a adiestrar (max 5):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadGranito()>(tropaAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadEther()>(tropaAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCarbono()>(tropaAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=5)
                                    {
                                        edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- tropaAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- tropaAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- tropaAux.getCostoR3()*cantidad);

                                        listaEdificioGuarnicion.get(index-1).getTropa().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else{
                                    System.out.println("Error de Guarnicion");
                                }
                                break;
                            }
                        case "Recluta":
                            if (listaEdificioGuarnicion.isEmpty())
                            {
                                System.out.println("No dispone de Guarniciones");
                                break;
                            }
                            else{
                                System.out.println("Elija que guarnicion usar:");
                                int index = entrada.nextInt();

                                if ("Guarnicion de Reclutas".equals(listaEdificioGuarnicion.get(index-1).getNombre())&&index>0)
                                {
                                    TropasCreacionista tropaAux = listaEdificioGuarnicion.get(index-1).getTropa();
                                    System.out.println("Cantidad a adiestrar (max 10):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadGranito()>(tropaAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadEther()>(tropaAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCarbono()>(tropaAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=10)
                                    {
                                        edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- tropaAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- tropaAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- tropaAux.getCostoR3()*cantidad);

                                        listaEdificioGuarnicion.get(index-1).getTropa().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else{
                                    System.out.println("Error de guarnicion");
                                }
                                break;
                            }
                        case "Especial":
                            if (listaEdificioGuarnicion.isEmpty())
                            {
                                System.out.println("No dispones de la Guarnicion");
                                break;
                            }
                            else{
                                System.out.println("Elija que guarnicion usar:");
                                int index = entrada.nextInt();

                                if ("Guarnicion Especial".equals(listaEdificioGuarnicion.get(index-1).getNombre())&&index>0)
                                {
                                    TropasCreacionista tropaAux = listaEdificioGuarnicion.get(index-1).getTropa();
                                    System.out.println("Cantidad a adiestrar (max 1):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadGranito()>(tropaAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadEther()>(tropaAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCarbono()>(tropaAux.getCostoR3()*cantidad)&& cantidad==1)
                                    {
                                        edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- tropaAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- tropaAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- tropaAux.getCostoR3()*cantidad);

                                        listaEdificioGuarnicion.get(index-1).getTropa().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else{
                                    System.out.println("No dispone de la Guarnicion Especial");
                                }
                                break;
                            }
                        case "volver":
                            break;
                    }
                    break;
                case "3":
                    switch(menuCreacionista.menuVehiculos()){
                        case "Demoledor":
                            if (listaEdificioTalleres.isEmpty())
                            {
                            System.out.println("No dispone de Talleres");
                            break;
                            }
                            else{
                                System.out.println("Elija que taller usar:");
                                int index = entrada.nextInt();

                                if ("Taller de Demoledor".equals(listaEdificioTalleres.get(index-1).getNombre())&&index>0)
                                {
                                    VehiculosCreacionista vehiculoAux = listaEdificioTalleres.get(index-1).getVehiculo();
                                    System.out.println("Cantidad a adiestrar (max 5):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadGranito()>(vehiculoAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadEther()>(vehiculoAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCarbono()>(vehiculoAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=5)
                                    {
                                        edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- vehiculoAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- vehiculoAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- vehiculoAux.getCostoR3()*cantidad);

                                        listaEdificioTalleres.get(index-1).getVehiculo().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else 
                                {
                                    System.out.println("Error de Taller");
                                }
                                break;
                            }
                        case "Helicoptero":
                            if (listaEdificioTalleres.isEmpty())
                            {
                            System.out.println("No dispone de un Taller");
                            break;
                            }
                            else{
                                System.out.println("Elija que taller usar:");
                                int index = entrada.nextInt();

                                if ("Taller de Helicopteros".equals(listaEdificioTalleres.get(index-1).getNombre())&&index>0)
                                {
                                    VehiculosCreacionista vehiculoAux = listaEdificioTalleres.get(index-1).getVehiculo();
                                    System.out.println("Cantidad a adiestrar (max 5):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadGranito()>(vehiculoAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadEther()>(vehiculoAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCarbono()>(vehiculoAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=5)
                                    {
                                        edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()- vehiculoAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()- vehiculoAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()- vehiculoAux.getCostoR3()*cantidad);

                                        listaEdificioTalleres.get(index-1).getVehiculo().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("No hay suficientes recursos o cantidad invalida");                            
                                    }
                                }
                                else
                                {
                                    System.out.println("Error de Taller");
                                }
                                break;
                            }
                    }
                case "6":
                    if (listaEdificioRecurso.isEmpty()){
                        System.out.println("No dispone de Edificios que te generen o produscan algun recurso");
                    }
                    else
                    {
                        for (Edificio recolectar:listaEdificioRecurso){
                            if ("Generador de Granito".equals(recolectar.getNombre()))
                            {
                                edificioPrincipal.setCantidadGranito(edificioPrincipal.getCantidadGranito()
                                                                  +recolectar.getProduccion()*(this.fase-recolectar.getFaseCreacion()));
                                recolectar.setFaseCreacion(this.fase);   
                            }
                            if ("Recolector de Ether".equals(recolectar.getNombre()))
                            {
                                edificioPrincipal.setCantidadEther(edificioPrincipal.getCantidadEther()
                                                                    +recolectar.getProduccion()*(this.fase-recolectar.getFaseCreacion()));
                                recolectar.setFaseCreacion(this.fase);
                            }
                            if ("Recolector de Carbono".equals(recolectar.getNombre()))
                            {
                                edificioPrincipal.setCantidadCarbono(edificioPrincipal.getCantidadCarbono()
                                        +recolectar.getProduccion()*(this.fase-recolectar.getFaseCreacion()));
                                recolectar.setFaseCreacion(this.fase);
                            }
                        }
                    }
                    break;
                case "7":
                    continuar = false;
                    break;
            }
        }
    }
    
}
