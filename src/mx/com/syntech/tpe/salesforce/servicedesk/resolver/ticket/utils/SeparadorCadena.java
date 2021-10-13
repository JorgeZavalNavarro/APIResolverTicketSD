package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.utils;

/**
 *
 * @author jzavala
 */
public class SeparadorCadena {

    // Propiedades de la clase
    public static final String SERIE_NUMERO = "0123456789";
    public static final String SERIE_MAYUSCULA = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    public static final String SERIE_MINUSCULA = "abcdefghijklmnñopqrstuvwxyz";
    public static final String[] PRONOMBRES = new String[]{"de", "del", "la", "las"};

    /**
     * Este método va a separar la cadena que se está recibiendo en porciones
     * correspondientes segun el separador que se esta especificado Si alguno de
     * los valores que se reecibe es nulo la función regresa nulo
     *
     * @param cadena String - Cadena a separar
     * @param separador String - Separador que se va a conciderar
     * @return String[] - Arreglo de elementos obtenidos de la cadena
     * correspondiente
     */
    public static String[] separarCadena(String cadena, String separador) {
        String[] retorno = null;

        if (cadena != null && separador != null) {

            // Inicializamos los contadores
            int i = 0;
            int inicio = 0;
            int pos = 0;

            while (pos >= 0) {
                i++;
                pos = cadena.indexOf(separador, pos);
                if (pos == -1) {
                    break;
                }
                pos = pos + separador.length();

            }

            if (cadena.trim().length() == 0) {
                i = 0;
            }

            if (i > 1) {
                retorno = new String[i];
                pos = 0;
                inicio = 0;
                i = 0;
                while (pos >= 0) {
                    pos = cadena.indexOf(separador, pos);
                    if (pos == -1) {
                        break;
                    }
                    if (i == 0) {
                        retorno[i] = cadena.substring(inicio, pos);
                    } else {
                        retorno[i] = cadena.substring(inicio + separador.length(), pos);
                    }
                    inicio = pos;
                    pos = pos + separador.length();
                    i++;

                }
                if (i < retorno.length) {
                    retorno[i] = cadena.substring(inicio + separador.length());
                }

            } else if (i == 1) {
                retorno = new String[1];
                retorno[0] = cadena;
            } else if (i == 0) {
                retorno = new String[0];
            }
        }

        return (retorno);
    }

    public static int[] separarNumero(String cadena, String separador) {
        int[] retorno = null;
        if (cadena != null && !cadena.isEmpty() && separador != null && !separador.isEmpty()) {
            String[] cadNumero = separarCadena(cadena, separador);
            retorno = new int[cadNumero.length];
            for (int i = 0; i < cadNumero.length; i++) {
                retorno[i] = Integer.valueOf(cadNumero[i]).intValue();
            }
        }
        return retorno;
    }

    /**
     * Método que nos va a devolver una porsión de la cadena segun el nivel que
     * se esta especificado y el separador, por ejemplo
     * cadenaHasta("uno.dos.tres.cuatro.cinco", ".", 3)="uno.dos.tres" Si alguno
     * de los parametros que se recibe es nulo la función regresa nulo
     *
     * @param cadena String - Cadena a analizar y extraer la porcion
     * correspondiente
     * @param separador String - Separador de la cadena correspondiente
     * @param indice int - Nivel o numero de elementos a devolver
     * @return String - Cadena de retorno de la función
     */
    public static String cadenaHasta(String cadena, String separador, Integer indice) {
        String retorno = null;

        if (cadena != null && separador == null && indice != null) {
            retorno = "";
            int i = 0;
            int nivel = indice.intValue();
            String[] elemento = separarCadena(cadena, separador);
            if (nivel < elemento.length) {
                for (i = 0; i < nivel; i++) {
                    if (i > 0) {
                        retorno += separador;
                    }
                    retorno += elemento[i];
                }
            } else {
                retorno = cadena;
            }
        }
        return retorno;
    }

    /**
     * Método que nos va a devolver la subcadena segun el nivel o indice que se
     * reciobe como parametri por ejemplo
     * cadenaNivel("uno.dos.tres.cuatro.cinco", ".", 3)="tres" Si alguno de los
     * parametros que se recibe es nulo la función regresa -1
     *
     * @param cadena - Cadena Origen de donde se va a extraer la información
     * @param separador - Separador que define las subcadenas
     * @param indice - Indice de la cubcadeba que se desea extraer de la cadena
     * oriogen
     * @return Cadena del indice solicitado
     */
    public static String elementoNumero(String cadena, String separador, Integer indice) {
        String retorno = null;
        if (cadena != null && separador != null && indice != null) {
            int nivel = indice.intValue();
            String[] elemento = separarCadena(cadena, separador);
            if (nivel < elemento.length) {
                retorno = elemento[nivel - 1];
            }
        }
        return retorno;
    }

    /**
     * Método que nos va a devolver el total de subcadenas contenidas en la
     * cadena origen basados en el separador que se esta recibiendoi como
     * parámetro. Si alguno de los parametros que se recibe es nulo la función
     * regresa nulo
     *
     * @param cadena - Cadena donde se encuentran contenidas las subcadenas
     * @param separador - Separador que define las subcadenas
     * @return - Numero de subcadenas contenidas en la cadena
     */
    public static Integer totalSub(String cadena, String separador) {
        Integer retorno = null;
        if (cadena != null && separador != null) {
            String[] elemento = separarCadena(cadena, separador);
            retorno = new Integer(elemento.length + 1);
        }
        return retorno;
    }

    /**
     * Método que se va a encargar de verificar qie alguna letra de la cadena
     * cadenaBuscar existe en cadenaOrigen
     *
     * @param cadenaOrigen
     * @param cadenaBuscar
     * @return
     */
    public static boolean existe(String cadenaOrigen, String cadenaBuscar) {
        for (int i = 0; i < cadenaOrigen.length(); i++) {
            if (cadenaBuscar.indexOf(cadenaOrigen.substring(i, i + 1)) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeNumero(String cadenaOrigen) {
        return existe(cadenaOrigen, SERIE_NUMERO);
    }

    public static boolean existeMayuscula(String cadenaOrigen) {
        return existe(cadenaOrigen, SERIE_MAYUSCULA);
    }

    public static boolean existeMuniscula(String cadenaOrigen) {
        return existe(cadenaOrigen, SERIE_MINUSCULA);
    }

    public static Integer numElementos(String cadena, String separador) {
        Integer retorno = null;
        int i = 0;
        int pos = 0;

        while (pos >= 0) {
            i++;
            pos = cadena.indexOf(separador, pos);
            if (pos == -1) {
                break;
            }
            pos = pos + separador.length();

        }

        // Cargamos el valor de retorno
        retorno = new Integer(i);

        // Retorno del método
        return retorno;

    }

    /**
     * Este método va a devolver las posiciones que ocupan cada uno de los
     * elementos encontrados en la cadena segun el separador especificado,
     * indicando la posicion donde empiesa la cadena correspondiente
     *
     * @param cadena String - Cadena a desglosar
     * @param separador String - Separador de los elementos en la cadena
     * @return Integer[] - Arreglo con las posiciones de los elementos
     * encontrados
     */
    public static Integer[] posiciones(String cadena, String separador) {
        Integer[] retorno = null;
        int i = numElementos(cadena, separador).intValue();
        int pos = 0;

        if (cadena.trim().length() == 0) {
            i = 0;
        }

        if (i > 1) {
            retorno = new Integer[i];
            pos = 0;
            i = 1;
            retorno[0] = new Integer(0);
            while (pos >= 0) {
                pos = cadena.indexOf(separador, pos);
                if (pos == -1) {
                    break;
                }
                retorno[i] = new Integer(pos);
                pos = pos + separador.length();
                i++;
            }
        } else if (i == 1) {
            retorno = new Integer[1];
            retorno[0] = new Integer(0);
        } else if (i == 0) {
            retorno = new Integer[0];
        }

        return (retorno);
    }

    public static boolean soloCadena(String cadena, String valida) {
        for (int i = 0; i < cadena.length(); i++) {
            if (valida.indexOf(cadena.substring(i, i + 1)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean soloEntero(String cadenaOrigen) {
        return soloCadena(cadenaOrigen, SERIE_NUMERO);
    }

    /**
     * Método que va a realizar el proceso inverso a la separación de las
     * cadenas, este las va a unificar segun el contenido del arreglo, y su
     * unión va a estar definida por el parámetro segundo
     *
     * @param cadena String[]
     * @param separador String
     * @return String
     */
    public String invertirSeparar(String[] cadena, String separador) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < cadena.length; i++) {
            if (i > 0) {
                buf.append(separador);
            }
            buf.append(cadena[i]);
        }
        return buf.toString();
    }

    /**
     * Método que se va a encargar de juntar las cadenas contenidas en el
     * arreglo correspondiente sin agregar ningun separador Si el arreglo es
     * nulo la función regresa nulo; Si el arregklo esta vacio la función
     * regresa una cadena vacia (****falta validar)
     *
     * @param cadena
     * @return
     */
    public static String juntarCadena(String[] cadena, boolean usarTrim) {
        String retorno = null;
        if (cadena != null) {
            StringBuffer buf = new StringBuffer();
            for (String elemento : cadena) {
                if (usarTrim) {
                    buf.append(elemento.trim());
                }
            }
            retorno = buf.toString();
        }
        return retorno;

    }

    public static String juntarCadena(String[] cadena, boolean usarTrim, String joiner) {
        String retorno = null;
        if (cadena != null && joiner != null && !joiner.isEmpty()) {
            StringBuffer buf = new StringBuffer();
            for (String elemento : cadena) {
                if (usarTrim) {
                    if (!buf.toString().isEmpty()) {
                        buf.append(joiner);
                    }
                    buf.append(elemento.trim());
                }
            }
            retorno = buf.toString();
        }
        return retorno;

    }

    /**
     * Método que se va a encargar de quitar las palabras contenidas en quitar
     * de la cadena que se está recibiendo como parametro aliminando los
     * espacios en blanco existentes en los extremos Si alguno de los parametros
     * se recibe nulo o vacio el método devuelve nulo
     *
     * @param cadena - Cadena a limpiar
     * @param quitar - Arreglo con las cadenas a limpiar
     * @return
     */
    public static String quitarPalabras(String cadena, String[] quitar) {
        String retorno = null;
        if (cadena != null && !cadena.isEmpty() && quitar != null && quitar.length > 0) {
            retorno = cadena.toString();
            String[] subCadena = null;
            for (String elem : quitar) {
                if (elem != null && !elem.isEmpty()) {
                    subCadena = separarCadena(retorno, elem);
                    retorno = juntarCadena(subCadena, true);
                }
            }
        }
        return retorno;
    }

    /**
     * Método que se va a encargar de quitar todas y cada una de las letras
     * existentes en quitar desde la cadena que se reibe como parámetro,
     * respetando los espacios en blanco si no se especifica en quitar Si alguno
     * de los parametros se recibe nulo o vacio la función regresa nulo
     *
     * @param cadena
     * @param quitar
     * @return
     */
    public static String quitarLetras(String cadena, String quitar) {
        String retorno = null;
        String[] subElemento = null;
        if (cadena != null && !cadena.isEmpty() && quitar != null && !quitar.isEmpty()) {
            String letra = null;
            retorno = cadena.toString();
            for (int i = 0; i < quitar.length(); i++) {
                letra = quitar.substring(i, i + 1);
                System.out.println("Letra: " + letra);
                subElemento = separarCadena(retorno, letra);
                retorno = juntarCadena(subElemento, true);
            }
        }
        return retorno;
    }

    /**
     * Método que va a obtener la cuenta de correo hasta el arroba, ejemplo
     * email: jzavala74mz@yahoo.com.mx, el método regresa jzavala74mz Si la
     * función recibe nulo el método regresa nulo
     *
     * @param email - Coreo electróinico a depurar
     * @return
     */
    public static String nombreEmail(String email) {
        String retorno = null;
        if (email != null) {
            int pos = email.indexOf("@");
            if (pos >= 0) {
                retorno = email.substring(0, pos);
            } else {
                retorno = email;
            }
        }
        return retorno;
    }

    public static String[] separarCadenaPorLongitud(String cadenaSeparar, Integer longitud) {

        // Valor de retorno de la función
        String[] retorno = null;

        // Validamos los parámetros de entrada
        if (cadenaSeparar != null && !cadenaSeparar.isEmpty()) {
            // Inicializamos los contadores
            int i = 0;
            int inicio = 0;
            int posIni = 0;
            int posFin = 0;

            // Obtenemos el número de elementos contando de 4 X 4
            int numElementos = cadenaSeparar.length() / longitud;
            numElementos++;

            retorno = new String[numElementos];

            // Desglosamos de n en n donde n = longitud
            while (posIni < cadenaSeparar.length()) {
                posFin = posIni + longitud;
                if (posFin > cadenaSeparar.length()) {
                    posFin = cadenaSeparar.length();
                }

                retorno[i] = cadenaSeparar.substring(posIni, posFin);
                posIni = posFin;
                i++;

            }

        }

        // Retorno del método
        return retorno;
    }

    // MAIN PARA PROBAR LOS MÉTODOS
    public static void main(String param[]) {
        // System.out.println("Probar las cadenas");
        // System.out.println(existe("1MiNombre","1234567890"));
        String cadena = "de la llave de la mora juan carlos";
        System.out.println("Sin las letras: " + quitarPalabras(cadena, PRONOMBRES));
        String[] cad = separarCadenaPorLongitud(cadena, 5);
        System.out.println(cad.length);

    }

}
