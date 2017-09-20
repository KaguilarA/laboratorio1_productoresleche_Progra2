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
import java.io.*;
import java.text.DecimalFormat;

public class Ui {

    /**
     * @param args the command line arguments
     */
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
    //Funcion que lee las variables
    public static void main(String[] args) throws IOException {
        int cantVacasSinCria, cantVacasConCria, estacionDelAnno;
        double areaDisponible;
        double[] infoHatos = new double[3];
        
        out.println("<--- Ingrese la cantidad de vacas sin cr\u00eda --->");
        cantVacasSinCria = Integer.parseInt(in.readLine());
        
        out.println("<--- Ingrese la cantidad de vacas con cr\u00eda --->");
        cantVacasConCria = Integer.parseInt(in.readLine());
        
        out.println("<--- Ingrese el \u00e1rea disponible de terreno en hectareas --->");
        areaDisponible = Double.parseDouble(in.readLine());
        
        estacionDelAnno = optionSelected();
        
        infoHatos = Cl.datosPorHato(cantVacasSinCria, cantVacasConCria, areaDisponible, estacionDelAnno);
        
        out.println("Imprimiendo resultados");
        out.println("El total de produccion es de un total de: " + infoHatos[0]);
        out.println("El total de ganancias es de un total de: " + formatPrice(infoHatos[1]));
        out.println("El precio por botella es de un total de: " + infoHatos[2]);
    }
    
    //Funcion que se encarga de escoger la estacion
    static int optionSelected() throws IOException{
        int opcion;
        
        out.println("<--- Seleccione una estación del a\u00f1o --->");
        out.println("1.  Verano");
        out.println("2.  Invierno");
        out.println("3.  Otoño");
        out.println("4.  Primavera");
        out.println();
        out.println("Seleccione su opci\u00f3n: ");
        opcion = Integer.parseInt(in.readLine());
        return opcion;
    }
    
    public static String formatNumber (Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        return formatter.format(price);
    }

    public static String formatNumberWhitoutDecimal (Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(price);
    }

    public static String formatPrice(Double price) {
        String toShow = formatNumberWhitoutDecimal(price);
        if (toShow.indexOf(".") > 0) {
            return formatNumber(price);
        } else {
            return formatNumberWhitoutDecimal(price);
        }
    }
}