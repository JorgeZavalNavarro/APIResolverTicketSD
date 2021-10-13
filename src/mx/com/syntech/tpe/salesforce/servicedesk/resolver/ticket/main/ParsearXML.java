package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import org.apache.log4j.Category;

/**
 *
 * @author Jorge Zavala Navarro
 */
public class ParsearXML {

    // propiedades 7
    private static Category log = Category.getInstance(ParsearXML.class);

    String pretorno = "<processResponse xmlns=\"http://soa.totalplay.com/ServiceDesk/UpdateInfoTicketSF/BPELUpdateInfoTicketSF\">\n"
            + "<IdResult>2311775</IdResult>\n"
            + "<Result>1</Result>\n"
            + "<ResultDescription>Operacion fallida</ResultDescription>\n"
            + "</processResponse>";

    public static String parsearDescripcion(String cadXml) {
        log.info("Obtener la descripcion de: " + cadXml);
        int posIniDesc = cadXml.indexOf("<ResultDescription>");
        int posFinDesc = cadXml.indexOf("</ResultDescription>");
        log.info("Pos. inicial Desc: " + posIniDesc);
        log.info("Pos. final Desc: " + posFinDesc);
        log.info("Longitud total: " + cadXml);
        String retorno = cadXml.substring(posIniDesc + "<ResultDescription>".length(), posFinDesc);
        return retorno;
    }

    public static String parsearResultado(String cadXml) {
        log.info("Obtener resultado de: " + cadXml);

        int posIniResultado = cadXml.indexOf("<Result>");
        int posFinResultado = cadXml.indexOf("</Result>");
        log.info("Pos. inicial Resultado: " + posIniResultado);
        log.info("Pos. final Resultado: " + posFinResultado);
        log.info("Longitud total: " + cadXml);
        return cadXml.substring(posIniResultado + "<Result>".length(), posFinResultado);
    }

    public static void main(String[] params) {
        String pretorno = "<processResponse xmlns=\"http://soa.totalplay.com/ServiceDesk/UpdateInfoTicketSF/BPELUpdateInfoTicketSF\">\n"
                + "   <IdResult>2311550</IdResult>\n"
                + "   <Result>1</Result>\n"
                + "   <ResultDescription>Operacion fallida</ResultDescription>\n"
                + "</processResponse>";
        System.out.println("XML: " + pretorno);
        System.out.println("Descripcion: " + parsearDescripcion(pretorno));
        System.out.println("Resultado: " + parsearResultado(pretorno));
    }

}
