package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.utils;

import java.util.ArrayList;
import java.util.List;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreException;

/**
 *
 * @author jzavala
 */
public class ValidaCadena {
    // PROPIEDADES DE LA CLASE
    public static final String abc_min = "abcdefghijklmnñopqrstuvwxyz";
    public static final String abc_MAY = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    public static final String abc_min_ing = "abcdefghijklmnopqrstuvwxyz";   // Ingles sin la "ñ"
    public static final String abc_MAY_ING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";   // Ingles sin la "Ñ"
    public static final String abc = abc_min + abc_MAY;
    public static final String abc_ing = abc_min_ing + abc_MAY_ING;
    public static final String num = "0123456789";
    public static final String let = abc + num;
    public static final String let_ing = abc_ing + num;

    public ValidaCadena() {
    }



    public static boolean validaContenido(String origen, String valida){
        boolean retorno = true;

        // BUSCAMOS QUE CADA CARACTER DE LA CADENA ORIGEN, ESTE CONTENIDA EN LA CADENA VALIDA
        char[] cadOrigen = origen.toCharArray();
        int pos = 0;

        // ESCANEAMOS EN LAS CADENAS
        for(int i=0;i<cadOrigen.length;i++){
            pos = valida.indexOf(cadOrigen[i]);
            if(pos==-1){
                // LA CADENA ORIGEN TIENE UN CARACTER NO VALIDO
                return false;
            }
        }

        return retorno;
    }
    
    /**
     * Valida que dos cadenas sean excatamente iguales entre si aplicando el case sensitive
     * Si alguna o ambas de las cadenas son nulas EL MÉTODO DEVUELVE TRUE
     * Si ambas cadenas son vacias (isEmpty) el método regresa True
     * Antes de realizar la comparación las cadenas son pasadas por el trim correspondiente
     * para eliminar los espacios en blanco de los extremos correspondientes
     * @param cadenaUno
     * @param cadenaDos
     * @return 
     */
    public static boolean cadenasIguales(String cadenaUno, String cadenaDos){
        boolean retorno = Boolean.FALSE;
        
        // Primero validamos que ambas cadenas no esten nulas y/o vacias
        if(cadenaUno!=null && cadenaDos!=null){
            cadenaUno = cadenaUno.trim();
            cadenaDos = cadenaDos.trim();
            if(cadenaUno.equals(cadenaDos)){
                retorno = Boolean.TRUE;
            }
        }else if(cadenaUno==null && cadenaDos!=null){
            retorno = Boolean.FALSE;
        }else if(cadenaUno!=null && cadenaDos==null){
            retorno = Boolean.FALSE;
        }else if(cadenaUno==null && cadenaDos==null){
            retorno = Boolean.TRUE;
        }
        return retorno;
    }

    public static boolean validaRequerido(String origen, String valida) throws CoreException {
        throw new CoreException("Método no desarrollado. origen: " + origen + ", valida:" + valida);
    }

    public static int inicioCadena(String cadena, String valida, int posInicial){
        int retorno = cadena.length();
        int primero = 0;
        char[] cadValida = valida.toCharArray();
        for(int i=0; i<cadValida.length;i++){
            primero = cadena.indexOf(cadValida[i], posInicial);
            if(primero<retorno && primero > -1){
                retorno = primero;
            }
        }
        if(retorno>=cadena.length()){
            retorno = -1;
        }
        return retorno;
    }


    public static void main(String[] param){
        System.out.println(ValidaCadena.validaContenido("Jorge Zavala Navarro",ValidaCadena.abc + " "));
        System.out.println(ValidaCadena.inicioCadena("jorge Zavala Navarro", ValidaCadena.abc_MAY, 7));

        String origen = "cPruebaDeTabla";
        int posMay = 0;
        int inicio = 0;
        String trozo = null;
        String retorno = null;
        List<java.lang.String> fragmento = new ArrayList<java.lang.String>();
        while(true){
            posMay = ValidaCadena.inicioCadena(origen,ValidaCadena.abc_MAY,inicio+1);
            if(posMay>0){
                trozo = origen.substring((inicio==0?inicio:inicio), posMay);
                System.out.println(trozo);
                fragmento.add(origen.substring(inicio, posMay));
                inicio=posMay;
            }else{
                trozo = origen.substring(inicio);
                fragmento.add(origen.substring(inicio));
                System.out.println(trozo);
                break;
            }
        }

        // CONVERTIMOS A MAYUSCULAS CADA ELEMENRTO Y ARMAMOS LA CADENA RESULTANTE
        retorno = "";
        for(int i=0;i<fragmento.size();i++){
            if(i>0){
                retorno += "_";
            }
            retorno += ((String)fragmento.get(i)).toUpperCase();
        }
        System.out.println("Origen: " + origen);
        System.out.println("Retorno: " + retorno);
    }

}
