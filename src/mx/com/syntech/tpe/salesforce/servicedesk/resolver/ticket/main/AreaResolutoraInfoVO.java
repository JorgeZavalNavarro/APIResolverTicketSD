package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import java.util.List;

/**
 * 
 * @author Jorge Zavala Navarro
 */
public class AreaResolutoraInfoVO {
    
    private String claveAreaResolutora = null;
    private String descripcion = null;
    private String sistema = null;
    private Integer eliminado = null;

    public String getClaveAreaResolutora() {
        return claveAreaResolutora;
    }

    public void setClaveAreaResolutora(String claveAreaResolutora) {
        this.claveAreaResolutora = claveAreaResolutora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public Integer getEliminado() {
        return eliminado;
    }

    public void setEliminado(Integer eliminado) {
        this.eliminado = eliminado;
    }
    
    public String json() {
        String retorno = null;
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("{");
        sbuilder.append("\"claveAreaResolutora\"").append(" : \"").append(this.claveAreaResolutora).append("\",");
        sbuilder.append("\"descripcion\"").append(" : \"").append(this.descripcion).append("\",");
        sbuilder.append("\"eliminado\"").append(" : \"").append(this.eliminado).append("\",");
        sbuilder.append("\"sistema\"").append(" : \"").append(this.sistema).append("\"");
        sbuilder.append("}");
        retorno = sbuilder.toString();
        return retorno;
    }

    public static String json(List<AreaResolutoraInfoVO> list) {
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
        return "AreaResolutoraInfoVO{" + "claveAreaResolutora=" + claveAreaResolutora + ", descripcion=" + descripcion + ", sistema=" + sistema + ", eliminado=" + eliminado + '}';
    }

    

}
