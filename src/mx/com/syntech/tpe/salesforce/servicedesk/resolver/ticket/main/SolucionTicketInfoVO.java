package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Jorge Zavala Navarro
 */
public class SolucionTicketInfoVO {

    // Propiedades de la clase
    private String actividadesRealizadas = null;
    private String diagnosticoInicial = null;
    private Integer claveDiagnostico = null;
    private Integer claveSolucion = null;
    private String timeFechaSolucion = null;
    private Timestamp fechaSolucion = null;
    private String claveAreaResolutora = null;
    private Integer idTicket = null;
    private String folioTicket = null;   //--> num_ref
    private String persIdTicket = null;
    private String ticketSalesforce = null;  // zfolio_dbw_sf
    

    // Elementos relacionados a la solución del ticket
    private DiagnosticoInfoVO diagnosticoVO = null;
    private SolucionInfoVO solucionVO = null;
    private AreaResolutoraInfoVO areaResolutoraVO = null;

    public String getActividadesRealizadas() {
        return actividadesRealizadas;
    }

    public void setActividadesRealizadas(String actividadesRealizadas) {
        this.actividadesRealizadas = actividadesRealizadas;
    }

    public String getDiagnosticoInicial() {
        return diagnosticoInicial;
    }

    public void setDiagnosticoInicial(String diagnosticoInicial) {
        this.diagnosticoInicial = diagnosticoInicial;
    }

    public Integer getClaveDiagnostico() {
        return claveDiagnostico;
    }

    public void setClaveDiagnostico(Integer claveDiagnostico) {
        this.claveDiagnostico = claveDiagnostico;
    }

    public Integer getClaveSolucion() {
        return claveSolucion;
    }

    public void setClaveSolucion(Integer claveSolucion) {
        this.claveSolucion = claveSolucion;
    }

    public String getTimeFechaSolucion() {
        return timeFechaSolucion;
    }

    public void setTimeFechaSolucion(String timeFechaSolucion) {
        this.timeFechaSolucion = timeFechaSolucion;
    }

    public Timestamp getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Timestamp fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public String getClaveAreaResolutora() {
        return claveAreaResolutora;
    }

    public void setClaveAreaResolutora(String claveAreaResolutora) {
        this.claveAreaResolutora = claveAreaResolutora;
    }

    public DiagnosticoInfoVO getDiagnosticoVO() {
        return diagnosticoVO;
    }

    public void setDiagnosticoVO(DiagnosticoInfoVO diagnosticoVO) {
        this.diagnosticoVO = diagnosticoVO;
    }

    public SolucionInfoVO getSolucionVO() {
        return solucionVO;
    }

    public void setSolucionVO(SolucionInfoVO solucionVO) {
        this.solucionVO = solucionVO;
    }

    public AreaResolutoraInfoVO getAreaResolutoraVO() {
        return areaResolutoraVO;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getFolioTicket() {
        return folioTicket;
    }

    public void setFolioTicket(String folioTicket) {
        this.folioTicket = folioTicket;
    }

    public String getPersIdTicket() {
        return persIdTicket;
    }

    public void setPersIdTicket(String persIdTicket) {
        this.persIdTicket = persIdTicket;
    }

    public String getTicketSalesforce() {
        return ticketSalesforce;
    }

    public void setTicketSalesforce(String ticketSalesforce) {
        this.ticketSalesforce = ticketSalesforce;
    }
    
    

    public void setAreaResolutoraVO(AreaResolutoraInfoVO areaResolutoraVO) {
        this.areaResolutoraVO = areaResolutoraVO;
    }

    public String json() {
        String retorno = null;
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("{");
        sbuilder.append("\"idTicket\"").append(" : \"").append(this.idTicket).append("\",");
        sbuilder.append("\"folioTicket\"").append(" : \"").append(this.folioTicket).append("\",");
        sbuilder.append("\"persIdTicket\"").append(" : \"").append(this.persIdTicket).append("\",");
        sbuilder.append("\"ticketSalesforce\"").append(" : \"").append(this.ticketSalesforce).append("\",");
        sbuilder.append("\"actividadesRealizadas\"").append(" : \"").append(this.actividadesRealizadas).append("\",");
        sbuilder.append("\"areaResolutoraVO\"").append(" : \"").append(this.areaResolutoraVO).append("\",");
        sbuilder.append("\"claveAreaResolutora\"").append(" : \"").append(this.claveAreaResolutora).append("\",");
        sbuilder.append("\"claveDiagnostico\"").append(" : \"").append(this.claveDiagnostico).append("\",");
        sbuilder.append("\"claveSolucion\"").append(" : \"").append(this.claveSolucion).append("\",");
        sbuilder.append("\"diagnosticoInicial\"").append(" : \"").append(this.diagnosticoInicial).append("\",");
        sbuilder.append("\"diagnosticoVO\"").append(" : \"").append(this.diagnosticoVO).append("\",");
        sbuilder.append("\"fechaSolucion\"").append(" : \"").append(this.fechaSolucion).append("\",");
        sbuilder.append("\"solucionVO\"").append(" : \"").append(this.solucionVO).append("\",");
        sbuilder.append("\"timeFechaSolucion\"").append(" : \"").append(this.timeFechaSolucion).append("\"");
        sbuilder.append("}");
        retorno = sbuilder.toString();
        return retorno;
    }

    public static String json(List<SolucionTicketInfoVO> list) {
        String retorno = null;
        StringBuilder sbuilder = new StringBuilder();
        if (list != null && list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sbuilder.append("[").append(list.get(i).json());
                } else {
                    sbuilder.append(",").append(list.get(i).json());
                }
            }

            sbuilder.append("]");
        } else {
            sbuilder.append("sin informacion");
        }

        retorno = sbuilder.toString();
        return retorno;
    }

    @Override
    public String toString() {
        return "SolucionTicketInfoVO{" + "actividadesRealizadas=" + actividadesRealizadas + ", diagnosticoInicial=" + diagnosticoInicial + ", claveDiagnostico=" + claveDiagnostico + ", claveSolucion=" + claveSolucion + ", timeFechaSolucion=" + timeFechaSolucion + ", fechaSolucion=" + fechaSolucion + ", claveAreaResolutora=" + claveAreaResolutora + ", idTicket=" + idTicket + ", folioTicket=" + folioTicket + ", persIdTicket=" + persIdTicket + ", ticketSalesforce=" + ticketSalesforce + ", diagnosticoVO=" + diagnosticoVO + ", solucionVO=" + solucionVO + ", areaResolutoraVO=" + areaResolutoraVO + '}';
    }

    
}
