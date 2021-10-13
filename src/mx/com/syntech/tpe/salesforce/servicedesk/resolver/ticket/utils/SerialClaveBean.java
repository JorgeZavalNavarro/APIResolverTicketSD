/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.utils;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jorge Zavala Navarro
 */
public class SerialClaveBean {

    // Propiedades de la clase
    private String llenado = null;
    private char carFill = (char)48;
    private String cadenaTotal = null;
    private String[] mapeoLetra = {
        "0","1","2","3","4","5","6","7","8","9",
        "A","B","C","D","E","F","G","H","I","J",
        "K","L","M","N","O","P","Q","R","S","T",
        "U","V","W","X","Y","Z",
        "a","b","c","d","e","f","g","h","i","j",
        "k","l","m","n","o","p","q","r","s","t",
        "u","v","w","x","y","z"};

    private String[] mapeoLlave = {
        "0","1","2","3","4","5","6","7","8","9",
        "A","B","C","D","E","F","G","H","I","J",
        "K","L","M","N","O","P","Q","R","S","T",
        "U","V","W","X","Y","Z"};

    public SerialClaveBean(){

    }
    /**
     * Método  constructor en donde vamos a recibir una cadena con las llaves separadas por el separado
     * correspondiente, los cuales se deben de ajustar a la liongitud especificada completandolo con ceros
     * a las izquierdfa
     * @param cadena
     * @param separador
     */
    public SerialClaveBean(String cadena, String separador, int longClave) throws SerialClaveException{

        // Armamos la caderna de llenado segun la longitud
        char[] carLlenado = new char[longClave];
        Arrays.fill(carLlenado, this.carFill);
        llenado = carLlenado.toString();
        
        // Revisamos los parametros
        if(cadena!=null && !cadena.isEmpty() && separador!=null && !separador.isEmpty() && longClave>0 && longClave<10){

            // Armamos la cadena total
            String[] clave = SeparadorCadena.separarCadena(cadena, separador);

            // Completamos segun la loingitud de la clave
            if(clave!=null && clave.length>0){

                // Procesamos clave por clave
                this.cadenaTotal = "";
                for(int i=0; i<clave.length; i++){

                    // Verificamos si la clave viene nula
                    if(clave[i]!=null){
                        clave[i] = "";
                    }

                    // Verificamos si la clave excede la longitud correspondiente
                    if(clave[i].length()>longClave){
                        throw new SerialClaveException("Alguna de las claves recibidas excede la longitud correspondientye");
                    }

                    // Completamos la cadena
                    clave[i] = llenado.substring(0, longClave - clave[i].length()) + clave[i];
                    this.cadenaTotal = this.cadenaTotal + clave[i];

                }


            }else{
                throw new SerialClaveException("Los valores que se estan recibiendo estan incompletos o son incorrectos");
            }
        }else{
            throw new SerialClaveException("Los valores que se estan recibiendo estan incompletos o son incorrectos");
        }

    }

    public SerialClaveBean(String cadenaTotal){
        this.cadenaTotal = cadenaTotal;
    }

    /**
     * Método constructor en donde vamos a recibir un arreglo de las claves y la
     * longitud de clada clave quie se conciodera
     * @param clave
     * @param longClave
     */
    public SerialClaveBean(Integer[] intClave, int longClave) throws SerialClaveException{
        // Revisamos los valores que se estan recibienco como parámetrp
        if(intClave!=null && intClave.length>0 && longClave>0){

            char[] carLlenado = new char[longClave];
            Arrays.fill(carLlenado, '0');
            llenado = new String(carLlenado);

            // Convertirmos a cadenas las claves numéridcas
            String[] clave = new String[longClave];
            this.cadenaTotal = "";
            for(int i=0; i<intClave.length; i++){
                if(intClave[i]!=null){
                    clave[i] = "" + intClave[i].intValue();
                }else{
                    clave[i] = "";
                }
                clave[i] = llenado.substring(0, longClave - clave[i].length()) + clave[i];
                this.cadenaTotal = this.cadenaTotal + clave[i];
            }

        }else{
            throw new SerialClaveException("Los valores que se están recibiendo estan incompletos o son incorrectos");
        }

    }

    public String getSerial(int longitud){
        String retorno = null;
        Random rand = new Random();
        retorno = "";
        for(int i=0; i<longitud; i++){
            retorno = retorno + mapeoLetra[rand.nextInt(52)];
        }
        return retorno;
    }

    public String getLlave(int clave, int longitud){
        String retorno = null;
        Random rand = new Random(clave);
        retorno = "";
        for(int i=0; i<longitud; i++){
            retorno = retorno + mapeoLlave[rand.nextInt(36)];
        }
        return retorno;
    }


    /**
     * Armamos el serial, y las claves son puros numeros que los convertiremos a letras
     * @return
     */
    public String armarSerial(){
        String retorno = null;

        // Armamos el caracteris de ciclos (A=1, B=2... max J=10)
        Random rand = new Random(10);
        int ciclos = rand.nextInt(10) + 1;
        int sum = 0;
        int suma[] = new int[ciclos];
        String caracterCiclos = new String(new char[]{((char)(65 + ciclos))});
        retorno = caracterCiclos;

        // Armamos nuestras sumatorias que parten de la letra A
        rand = new Random(52);
        for(int i=0; i<ciclos; i++){
            sum = rand.nextInt(52);
            suma[i] = sum;
            retorno = retorno + mapeoLetra[sum];
        }

        // Agregamos los caracteres de sumatorias procesano la cadena que recibimos
        int indiceOriginal = 0;
        int indiceFinal = 0;
        int contSuma = 0;
        String cadIndiceOriginal = null;
        String cadIndiceFinal = null;
        for(int i=0; i<this.cadenaTotal.length(); i++){
            cadIndiceOriginal = this.cadenaTotal.substring(i, i+1);
            indiceOriginal = Integer.valueOf(cadIndiceOriginal).intValue();
            indiceFinal = indiceOriginal + suma[contSuma];
            cadIndiceFinal = mapeoLetra[indiceFinal];
            retorno = retorno + cadIndiceFinal;
            contSuma++;
            if(contSuma>=suma.length){
                contSuma=0;
            }
        }
        return retorno;
    }

    public static void main(String[] param){
        // Preparamos nuestras claves
        SerialClaveBean serial = new SerialClaveBean();
        for(int i=0;i<100;i++){
            System.out.println("Serial generado: " + serial.getSerial(8).toUpperCase());
        }
        
        System.out.println("Serial por clave: " + serial.getLlave(854123659, 4));
    }

}
