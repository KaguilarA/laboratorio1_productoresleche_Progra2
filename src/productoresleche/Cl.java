/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productoresleche;

/**
 *
 * @author kevin
 */
public class Cl {
    public static double[] datosPorHato(int pVacas, int pVacasCrias, double pAreaDisp, int pEstacion){
        double[] infoHatos = new double[3];
        
        infoHatos[0] = produccion(pVacas, pVacasCrias, pAreaDisp, pEstacion);
        infoHatos[1] = ganancias(pVacas, pVacasCrias, pAreaDisp, pEstacion);
        infoHatos[2] = precioBotella(pEstacion);
        
        return infoHatos;
    }
    
    public static double produccion(int pVacas, int pVacasCria, double pAreaDisp, int pEstacion){
        double haPorVacaSinCria, haPorVacaConCria, alimentacionVacasCrias, alimentacionVacasSinCrias, cantNecesaria, produccionCrias, produccionSinCrias, produccionTotal;
        
        switch(pEstacion){
            case 1:
                cantNecesaria = 3.0;
            break;
            case 4:
                cantNecesaria = 1.5;
            break;
            default:
                cantNecesaria = 0.5;
            break;
        }
        
        alimentacionVacasSinCrias = pVacas * pAreaDisp;
        haPorVacaSinCria = alimentacionVacasSinCrias * pAreaDisp / 100;
        
        alimentacionVacasCrias = pVacasCria * pAreaDisp + 0.5;
        haPorVacaConCria = alimentacionVacasCrias * pAreaDisp / 100;
        
        if(haPorVacaSinCria >= 70){
            produccionSinCrias = 20;
            produccionCrias = 35;
        }else{
            produccionSinCrias = produccionCrias = 15;
        }
        
        produccionTotal = (produccionCrias / pVacasCria) + (produccionSinCrias + pVacas);
        
        return produccionTotal;
    }
    
    public static double ganancias(int pVacas, int pVacasCria, double pAreaDisp, int pEstacion){
        int precioBotella;
        double produccion, ganancias;
        
        precioBotella = precioBotella(pEstacion);

        produccion = produccion(pVacas, pVacasCria, pAreaDisp, pEstacion);
         
        ganancias = produccion * precioBotella * 30;
        
        return ganancias;
    }
    
    public static int precioBotella(int pEstacion){
        int precioBotella;
        
        if(pEstacion == 1){
            precioBotella = 300;
        }else{
            precioBotella = 100;
        }
        
        return precioBotella;
    }
}