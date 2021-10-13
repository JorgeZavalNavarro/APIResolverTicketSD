
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.syntech.tpe.salesforce.servicedesk.changestatus.principal;

import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 *
 * @author dell
 */
public class ChangeStatusMain {

    // Constantes de la clase
    private static Category log = null;

    /**
     * @param args the command line arguments 1471026	cr:1471026	1051556
     * 0x6CD8DE6C80BA4A46ACBEF4A5244CABA9	NULL	KONIBIT	KONIBIT	OP
     */
    public static void main(String[] args) {
        // TODO code application logic here

        AppPropsBean.getPropsVO().getBddClassDriver();
        log = Category.getInstance(ChangeStatusMain.class);

        log.info("   ::: Iniciando proceso...");
        if (args == null || args.length == 0) {
            log.info("TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST  P R O B A N D O   C O N   I N F O R M A C I Ó N   F I J A  TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST                                                             TEST-TEST-TEST");
            log.info("TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST");
            args = new String[3];
            args[0] = "cr:1470876";
            args[1] = "NA";
            args[2] = "Esta es una prueba de comentarios correspondentes.";
        }
        // Recibir los parámetros
        if (args != null && args.length == 3) {

            try {
                String crTicket = args[0];
                String subEstatus = args[1];
                String comentarios = args[2];

                log.info("   ::: Parámetros a procesar:");

                // Ejecutamos el Bean correspondiente
                ChangeStatusSFBean bean = new ChangeStatusSFBean();
                bean.cambiarEstatus(crTicket, subEstatus, comentarios);

            } catch (Exception ex) {
                String error = "No se puede procesar la información: " + ex.getMessage();
                log.error(error, ex);
                ex.printStackTrace();

            }

        } else {
            log.error("No se están recibiendo los parametros a procesar correctamente.");
        }
    }

}
