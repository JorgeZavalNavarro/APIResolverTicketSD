package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.utils;


import java.util.Random;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreException;

/**
 *
 * @author jzavala
 */
public class CamuflajeBean {

    public static final String CAMUF_SEPARADOR_COMUN = ",";
    public static final String CAMUF_SERIE_CODIGO_VALIDO = ValidaCadena.let_ing + "@!?#";



    /**
     * Método Constructor
     */
    public CamuflajeBean() {
    }

    /**
     * Método para codificar una cadena dada en un arreglo de caracteres.
     * @param car char[] - Arreglo de Caracteres a codificar
     * @return String - Regresa los códigos ascii's de cada uno de los elementos
     *                  del arreglo que se recibió separador por el separador especificado en
     *                  la propiedad de
     */
    public static String salida(char[] car){
        String retorno = null;
        retorno="";
        for(int i=0;i<car.length;i++){
            if(i>0){
                retorno += CAMUF_SEPARADOR_COMUN;
            }
            retorno+=""+(int)car[i];
        }
        return retorno;
    }

    /**
     * Método para convertir una cadena que contiene los códigos ascii's separador por
     * comas en la cadena correspondiente, segun los ascii´s encontrados
     * @param cadena String - Cadena con los códigos ascii's separados por comas
     * @return String - Cadena decodificada
     */
    public static String entrada(String cadena){
        String retorno = null;
        String[] elem = SeparadorCadena.separarCadena(cadena,CAMUF_SEPARADOR_COMUN);
        char[] car = new char[elem.length];
        Integer ascii = null;
        for(int i =0;i<elem.length;i++){
            ascii = new Integer(elem[i]);
            car[i] = (char)ascii.intValue();
        }
        retorno = new String(car);

        return retorno;
    }

    /**
     * Método para camuflajear o descamuflajear una cadena segun el proceso especificado
     * @param cadena String - Cadena origen a camuflajear
     * @return char[] - Arreglo de los caracteres que componen la cadena camuflajeada
     */
    public static char[] camuflaje(String cadena){
        String retorno = null;
        Random randomSec = new Random();
        Random randomInc = new Random();
        int secuencia = 0;
        char[] serie = new char[6];
        int[] incremento = null;
        char[] cars = null;
        serie[0] = (char)210;
        serie[1] = (char)221;
        serie[2] = (char)222;
        serie[3] = (char)225;
        serie[4] = (char)230;
        serie[5] = (char)238;

        String cadSerie = new String(serie);

        // VERIFICAMOS SI LA CADENA QUE SE ESTÁ RECIBIENDO ESTA CAMUFLAJEADA O SE VA A CAMUFLAJEAR
        if(cadena.length()>6 && cadena.substring(0,6).compareTo(cadSerie)==0){
            // A DESCAMUFLAJEAR
            char[] car = cadena.toCharArray();
            secuencia = (int)car[6];
            incremento = new int[secuencia];
            char[] carRet = null;

            // CARGAMOS LOS CARACTERES DE LOS INCREMENTOS
            for(int i=0; i<secuencia; i++){
                incremento[i] = (int)car[7+i];
            }

            // TRANSFORMAMOS LA PARTE ENCRIPTADA
            int dest=0;
            int sec=0;
            int origen=0;
            int destino=0;
            retorno="";
            carRet = new char[cadena.length() - (7+secuencia)];
            for(int i=7+secuencia;i<cadena.length();i++){
                if(sec>=secuencia){
                    sec=0;
                }
                origen = (int)car[i];
                destino = origen - incremento[sec];
                retorno+= (char)(destino);
                carRet[dest] = (char)destino;
                sec++;
                dest++;

            }
            return carRet;


        }else{
            // A CAMUFLAJEAR
            retorno = new String(serie);

            // GENERAMOS UN NUMERO ALEATORIO DEL 1 AL 6 Y LE SUMAMOS 3
            secuencia = 3 + randomSec.nextInt(6);
            retorno += (char) secuencia;

            // DETERMINAMOS LOS INCREMENTOS O LAS DIFERENCIAS PARA EL CÓDIGO ASCII
            incremento = new int[secuencia];
            for (int i = 0; i < secuencia; i++) {
                incremento[i] = 10 + randomInc.nextInt(90);
                retorno += (char) incremento[i];
            }

            // TRANSFORMAMOS LA CADENA SEGUN LAS SECUENCIAS ESPECIFICADAS
            int sec = 0;
            int origen = 0;
            int destino = 0;
            cars = cadena.toCharArray();
            for (int i = 0; i < cars.length; i++) {
                if (sec >= secuencia) {
                    sec = 0;
                }
                origen = (int) cars[i];
                destino = origen + incremento[sec];
                cars[i] = (char) destino;
                retorno += (char) (destino);
                sec++;
            }

            // HAY QUE JUNTAR LOS ARREGLOS serie[], (char)secuencia; incremento[], cars[];
            char[] ret = new char[serie.length + incremento.length + cars.length + 1];
            int cont = 0;

            // AGREGAMOS serie
            for (int i = 0; i < serie.length; i++) {
                ret[cont] = serie[i];
                cont++;
            }

            // AGREGAMOS secuencia
            ret[cont] = (char) secuencia;
            cont++;

            // AGREGAMOS incremento
            for (int i = 0; i < incremento.length; i++) {
                ret[cont] = (char) incremento[i];
                cont++;
            }

            // AGREGAMOS cars
            for (int i = 0; i < cars.length; i++) {
                ret[cont] = cars[i];
                cont++;
            }

            return ret;
        }
    }


    public char[] camuflajeCodigo(String cadena, String codigo) throws CoreException {

        // Definimos las variables a usar en el método
        char[] retorno = null;

        // Validamos el código que se está recibiendo
        if(!this.codigoValido(codigo)){
            throw new CoreException("Codigo de camuflaje inválido: " + codigo);
        }

        // Camuflajeamos la cadena correspondiente

        return retorno;
    }

    /**
     * Verificamos que el contenido del código que se está especificando en el parámetro
     * de entrada solo contenga caracteres segun la definción de la propiedad de la
     * clase CAMUF_SERIE_CODIGO_VALIDO
     * @param codigo String - Código a validar
     * @return boolean - True si el código es válido
     *                   False si el código es inválido
     */
    private boolean codigoValido(String codigo){
        ValidaCadena validaCadena = new ValidaCadena();
        return validaCadena.validaContenido(codigo,this.CAMUF_SERIE_CODIGO_VALIDO);
    }


    public static void main(String[] param){
        String cadena = "Mi nombre es jorge zavala navarro y ya";
        char[] camuflaje = null;
        String codificada = null;
        
        
        // Convertimos 100 veces la cadena desplegando la cadena camuflajeada y codificada
        for(int i=0; i<1; i++){
            camuflaje = CamuflajeBean.camuflaje(cadena);
            codificada = CamuflajeBean.salida(camuflaje);
            System.out.println(i + "-->" + "Camuflaje: " + ((new String(camuflaje))) + " | " + codificada);
        }
        
        
        String decodificada = CamuflajeBean.entrada("210,221,222,225,230,238,8,91,21,57,93,57,82,13,46,168,126,89,203,168,191,111,160,192,53,158,208,89,188,124,160,194,122,89,215,154,200,110,154,188,53,167,190,175,179,127,160,202,53,178,125,178,179");
        String cadFinal = new String(CamuflajeBean.camuflaje(decodificada));
        System.out.println("cadena:" + cadena);
        System.out.println("camuflaje:" + new String(camuflaje));
        System.out.println("codificada:" + codificada);
        System.out.println("decodificada:" + decodificada);
        System.out.println("cadFinal:" + cadFinal);

    }
}
