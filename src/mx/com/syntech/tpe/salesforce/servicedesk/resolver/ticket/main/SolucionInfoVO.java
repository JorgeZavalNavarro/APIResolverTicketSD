package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import java.util.List;

/**
 * 
 * @author Jorge Zavala Navarro
 */
public class SolucionInfoVO {
    
    // Propiedades de la clase
    private Integer claveSolucion = null;
    private String descripcion = null;
    private String sistema = null;
    private String solucion = null;
    private Integer eliminado = null;

    // Métodos getters y setters
    public Integer getClaveSolucion() {
        return claveSolucion;
    }

    public void setClaveSolucion(Integer claveSolucion) {
        this.claveSolucion = claveSolucion;
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

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
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
        sbuilder.append("\"claveSolucion\"").append(" : \"").append(this.claveSolucion).append("\",");
        sbuilder.append("\"descripcion\"").append(" : \"").append(this.descripcion).append("\",");
        sbuilder.append("\"eliminado\"").append(" : \"").append(this.eliminado).append("\",");
        sbuilder.append("\"sistema\"").append(" : \"").append(this.sistema).append("\",");
        sbuilder.append("\"solucion\"").append(" : \"").append(this.solucion).append("\"");
        sbuilder.append("}");
        retorno = sbuilder.toString();
        return retorno;
    }

    public static String json(List<SolucionInfoVO> list) {
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
        return "SolucionInfoVO{" + "claveSolucion=" + claveSolucion + ", descripcion=" + descripcion + ", sistema=" + sistema + ", solucion=" + solucion + ", eliminado=" + eliminado + '}';
    }
    
    
    

}
