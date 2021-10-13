package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import mx.com.syntech.tpe.salesforce.servicedesk.changestatus.principal.ChangeStatusSFBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 * Componente sincronizar la parte de lña resolucion de un ticket Este
 * componente debe de recibir el id persistente del ticket y debe de extraer la
 * siguiente información:
 *
 * 1- Area que resolvio el ticket 2- Diagnóstico final 3- Solución
 *
 * Hay que proponer los siguientes datos:
 *
 * p1 - Ticket de servicedesk p2 - Ticket en salesforce
 *
 * Con estos datos vamos a consumir un web service proporcionado or TPE el cual
 * se va a encargar de sincronizar estos datos en el ticket correspondiente de
 * salesforce
 *
 * Se debe de agregar en el log de actividades el resultado obtenido del cosumo
 * del webservice por el cual se envia esta información al Salesforce
 *
 *
 * @author dell
 */
public class PrincipalMain {

    // Constantes de la clase
    private static Category log = Category.getInstance(PrincipalMain.class);

    /**
     * Inicio de la ejecución
     *
     * @param args the command line arguments Los parametros que recibe son los
     * siguientes: args[0] = folioTicket args[1] = usuario args[2] = password)
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // System.out.println("Ejecutando en " + AppPropsBean.getPropsVO().getPrincipalAmbiente());

        // Datos de prueba
        // args = new String[]{"cr:1470890"};
        /**
         * Si no se está recibiendo los valores y estamos en el ambiente de
         * desarrollo inicializamos los siguientes valores de prueba #1 :
         * Ticket: cr:1470876 #2 : Substatus: NA #3 : Comentario de la bandeja:
         * "cualquier comentario de prueba
         */
        // Desglosamos los parámetros, deben de ser obligatoriamente 3 parametros
        System.out.println("Class BDD: " + AppPropsBean.getPropsVO().getBddClassDriver());
        log.info("   ::: Charset actual: " + (new CoreBean()).getCharsetActual());
        log.info("   ::: Languaje actual: " + (new CoreBean()).getLanguajeActual());

        if ((args == null || args.length == 0)
                && AppPropsBean.getPropsVO().getPrincipalAmbiente().equals("desarrollo")) {
            // Aplicamos con datos de prueba
            log.info("TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST  P R O B A N D O   C O N   I N F O R M A C I Ó N   F I J A  TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST");
            args = new String[1];
            args[0] = "cr:1470115";

        }
        if (args != null && args.length == 1) {
            // Desglosamos los par{ametros 
            String numeroTicket = args[0];

            // Ejecutamos el componente con los parámetros recibidos
            try {

                // Enviar la justificación correspondiente
                PrincipalBean bean = new PrincipalBean();
                PrincipalResultadoVO resultadoVO = bean.sendJustificacionDeResolucionDeTicket(numeroTicket);

                // Agregar la parte de Change status
                ChangeStatusSFBean changeStatusBean = new ChangeStatusSFBean();
                changeStatusBean.cambiarEstatus(numeroTicket, resultadoVO.getEstatusTicket(), resultadoVO.getLogActivityDescription());
                
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error("Se produjo un error al intentar ejecutar este componente");
                log.error("Mensaje del error: " + ex.getMessage());
                log.error("Traza....", ex);

            }

        } else {
            log.error("Los parámetros recibidos son incorrectos.");
            log.error("Se espera un solo parámetro que es el persid del ticket, por ejemplo cr:1470890");
        }

    }

}
