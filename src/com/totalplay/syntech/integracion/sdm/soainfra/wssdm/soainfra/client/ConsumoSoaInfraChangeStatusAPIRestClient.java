package com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client;

import com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client.ConsumoSoaInfraAPIRestException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 *
 * @author Jorge Zavala Navarro
 */
public class ConsumoSoaInfraChangeStatusAPIRestClient {

    Category log = Category.getInstance(ConsumoSoaInfraChangeStatusAPIRestClient.class);

    public String callWS(
           InputWsInfoVO infoVO) throws ConsumoSoaInfraAPIRestException {
        String retorno = null;
        try {
            
            // Cambiar el la cadena de justificación de doble comilla a una sola comilla
            String urlWS = ""; //AppPropsBean.getPropsVO().getUrltpechangestatusWs();
            log.info("   ::: URL = " + urlWS);
            infoVO.setBandeja(infoVO.getBandeja().replaceAll("\"", "'"));
            String params
                    = "{ \"UserId\": \"" + infoVO.getUserId() + "\" ,"
                    + "\"Password\": \"" + infoVO.getPassword() + "\" ,"
                    + "\"Ip\": \"" + infoVO.getIp() + "\", "
                    + "\"NoTicket\": \"" + infoVO.getTicketSF()+ "\", "
                    + "\"Status\": \"" + infoVO.getStatus() + "\", "
                    + "\"SubStatus\": \"" + infoVO.getSubStatus() + "\", "
                    + "\"Comment\": \"" + infoVO.getComment().replaceAll("\"", "'") + "\" ,"
                    + "\"Bandeja\": \"" + infoVO.getBandeja().replaceAll("\"", "'") + "\" }";
            // String[] details = {};
            log.info("   ::: Input = " + params);

            // log.info(Arrays.toString(details));

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

   
    
    public static void main(String... params) {

        // Probamos el web serevice
        try {
            ConsumoSoaInfraChangeStatusAPIRestClient client = new ConsumoSoaInfraChangeStatusAPIRestClient();
            client.callWS(new InputWsInfoVO("servicedesk", "DeskService01", "192.168.241.32", "11563625",
            "WAIT", "NA", "Pruena de comentarios para este caso", "GRUPO DE BANDEJA DE PRUENA", 
                    "00021541-321654000"));
            
            //client.callWSTicketUpdate("651321541", "SISTEMAS COMO SIEMPRE", "UN PAJARO SE ESTRELLO EN EL SERVIDOR AEREO", "sE COMPRÓ OTRO SERVIDOR AEREO (JA JA JA)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
