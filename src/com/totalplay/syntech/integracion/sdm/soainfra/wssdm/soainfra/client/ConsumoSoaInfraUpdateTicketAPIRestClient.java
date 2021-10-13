/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.update.UpdateTicketBean;
import org.apache.log4j.Category;

/**
 *
 * @author dell
 */
public class ConsumoSoaInfraUpdateTicketAPIRestClient {
    

    Category log = Category.getInstance(ConsumoSoaInfraChangeStatusAPIRestClient.class);

    public String callWS(
           UpdateTicketBean.UpdateInfoVO infoVO) throws ConsumoSoaInfraAPIRestException {
        String retorno = null;
        try {
            
            // Cambiar el la cadena de justificación de doble comilla a una sola comilla
            String urlWS = AppPropsBean.getPropsVO().getUrlTpeUpdateticketWs();
            log.info("   ::: URL = " + urlWS);
            infoVO.setBandeja(infoVO.getBandeja().replaceAll("\"", "'"));
            String params
                    = "{ \"numeroTicket\": \"" + infoVO.getNumeroTicketSF()+ "\" ,"
                    +   "\"Status\": \"" + infoVO.getEstatusTicket()+ "\" ,"
                    +   "\"areaResolutora\": \"" + 
                            (infoVO.getNombreAreaResolutora()==null ? "" : infoVO.getNombreAreaResolutora().replaceAll("\"", "'")) + "\", "
                    +   "\"motivo\": \"" + 
                            (infoVO.getNombreDiagnostico()==null ? "" : infoVO.getNombreDiagnostico().replaceAll("\"", "'")) + "\" ,"
                    +   "\"TipoSolucion\": \"" + 
                            (infoVO.getNombreTipoSolucion()==null ? "" : infoVO.getNombreTipoSolucion().replaceAll("\"", "'")) + "\", "
                    +   "\"Justificacion\": \"" + 
                            (infoVO.getDescripcionJustificacion()==null ? "" : infoVO.getDescripcionJustificacion().replaceAll("\"", "'")) + "\", "
                    +   "\"diagFinal\": \"" + 
                            (infoVO.getNombreDiagnostico()==null ? "" : infoVO.getNombreDiagnostico().replaceAll("\"", "'")) + "\" ,"
                    +   "\"Bandeja\": \"" + 
                            (infoVO.getBandeja() == null ? "" : infoVO.getBandeja().replaceAll("\"", "'")) + "\" }";
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

}
