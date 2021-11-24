package com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
<<<<<<< Updated upstream
 * AGREGAMOS ESTA SENCILLA LINEA DE CÓDIGO
=======
 * prueba de linea de código agregada
 * OTRA LINEA AGREGADA
>>>>>>> Stashed changes
 * @author Jorge Zavala Navarro
 */
public class ConsumoSoaInfraAPIRestClient {

    Category log = Category.getInstance(ConsumoSoaInfraAPIRestClient.class);

    public String callWS(String Justificacion, String Noticket) throws ConsumoSoaInfraAPIRestException {
        String retorno = null;
        try {
            
            // Cambiar el la cadena de justificación de doble comilla a una sola comilla
            

            String urlWS = ""; //AppPropsBean.getPropsVO().getUrlTpeJustificacionWs();
            Justificacion = Justificacion.replaceAll("\"", "'");
            String params
                    = "{\"Justificacion\": \"" + Justificacion + "\","
                    + "\"NoTicket\": \"" + Noticket + "\"}";
            
            URL line_api_url = new URL(urlWS);
            String payload = params;

            HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
            // linec.setDoInput(true);
            linec.setDoOutput(true);
            linec.setRequestMethod("POST");
            linec.setRequestProperty("Content-Type", "application/json");
            // linec.setRequestProperty("Authorization", "Bearer 1djCb/mXV+KtryMxr6i1bXw");
            log.info(payload);
            // OutputStreamWriter writer = new OutputStreamWriter(linec.getOutputStream(), "UTF-8");
            OutputStream os = linec.getOutputStream();
            os.write(payload.getBytes());
            os.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));
            String inputLine;
            retorno = "";

            while ((inputLine = in.readLine()) != null) {
                
                log.info(inputLine);
                retorno = retorno + inputLine;
            }
            in.close();
            linec.disconnect();

            // retorno = "La información se envió al soa-infra satisfactoriamente"; 

        } catch (Exception e) {
            log.info("Exception in NetClientGet:- " + e);
            throw new ConsumoSoaInfraAPIRestException(e);

        }
        return retorno;
    }

    public String callWSTicketUpdate(String ticketSD, String aResolutoria, String causa, String tsolucion, String ticketSalesforce) throws ConsumoSoaInfraAPIRestException {
        String retorno = null;
        try {

            String urlWS = ""; //AppPropsBean.getPropsVO().getUrlTpeJicketupdateWs();
            String params
                    = "{\"numeroTicket\": \"" + ticketSalesforce + "\","
                    + "\"aResolutoria\": \"" + aResolutoria + "\","
                    + "\"causa\": \"" + causa + "\","
                    + "\"tsolucion\": \"" + tsolucion + "\"}";
            String[] details = {};

            log.info(Arrays.toString(details));

            URL line_api_url = new URL(urlWS);
            String payload = params;

            HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
            // linec.setDoInput(true);
            linec.setDoOutput(true);
            linec.setRequestMethod("POST");
            linec.setRequestProperty("Content-Type", "application/json");
            // linec.setRequestProperty("Authorization", "Bearer 1djCb/mXV+KtryMxr6i1bXw");
            log.info(payload);
            // OutputStreamWriter writer = new OutputStreamWriter(linec.getOutputStream(), "UTF-8");
            OutputStream os = linec.getOutputStream();
            os.write(payload.getBytes());
            os.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));
            String inputLine;
            
            retorno = "";
            while ((inputLine = in.readLine()) != null) {
                log.info(inputLine);
                retorno = retorno + inputLine;
            }
            in.close();
            linec.disconnect();

            // retorno = "La información se envió al soa-infra satisfactoriamente";

        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
            throw new ConsumoSoaInfraAPIRestException(e);

        }
        return retorno;
    }
    
    public static void main(String... params) {

        // Probamos el web serevice
        try {
            ConsumoSoaInfraAPIRestClient client = new ConsumoSoaInfraAPIRestClient();
            client.callWS("Alberto Gomez::\"Texto de la \"  \"justificación correspondiente\"", "11256325889");
            
            //client.callWSTicketUpdate("651321541", "SISTEMAS COMO SIEMPRE", "UN PAJARO SE ESTRELLO EN EL SERVIDOR AEREO", "sE COMPRÓ OTRO SERVIDOR AEREO (JA JA JA)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
