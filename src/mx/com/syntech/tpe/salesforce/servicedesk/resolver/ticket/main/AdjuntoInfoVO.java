package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

/**
 * Clase co la información del documento adjunto que se va a eliminar
 * @author Jorge Zavala Navarro
 */
public class AdjuntoInfoVO {
    
    // propiedades de la clase
    private String persIdAdjunto = null;            // ID Persistente del adjunto
    private Integer claveAdjunto = null;            // Llave principal de la tabla de adjuntos: attmnt
    private Integer claveRelacion = null;           // Llave principal de la tabla de la relación de los adjuntos y los tickets
    private Integer claveTicket = null;             // Llave principal de la tabla de los tickets
    private String persidTicket = null;             // ID Persistente del Ticket
    private String numeroTicket = null;             // Numero de ticket (tabla: call_req, campo:ref_num)
    private String carpetaRepositorio = null;       // Carpeta del repositorio en donde se encuentra el adjunto
    private String banderaBorrarAdjunto = null;     // Valor de la bandera para borra el adjunto
    private String nombreArchivoOriginal = null;    // Nombre del archivo original del adjunto
    private String nombreArchivoRepositorio = null; // Nombre del archivo en el repositorio
    private String banderaComprimido = null;        // Bandera que indica si el archivo se encuentra comprimido
    private String estatusArchivo = null;           // Indica el estado del archivo (INSTALLED: El archivo se encuentra fisicamente en la carpeta especificada, LINK_ONLY: Solo es una referencia, pero se valida si el archivo existe o no)
    private String descripcionAdjunto = null;       // Descripción del adjunto, mediante el valor de este campo vamos a saver si el adjunto proviene de salesforce por la cadena:   :::ARCHIVO REPLICADO EN SALESFORCE:::  
    private String creadoPor = null;                // UUID del que genero el registro del adjunto

    public Integer getClaveAdjunto() {
        return claveAdjunto;
    }

    public void setClaveAdjunto(Integer claveAdjunto) {
        this.claveAdjunto = claveAdjunto;
    }

    public Integer getClaveRelacion() {
        return claveRelacion;
    }

    public void setClaveRelacion(Integer claveRelacion) {
        this.claveRelacion = claveRelacion;
    }

    public Integer getClaveTicket() {
        return claveTicket;
    }

    public void setClaveTicket(Integer claveTicket) {
        this.claveTicket = claveTicket;
    }

    public String getPersidTicket() {
        return persidTicket;
    }

    public void setPersidTicket(String persidTicket) {
        this.persidTicket = persidTicket;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getCarpetaRepositorio() {
        return carpetaRepositorio;
    }

    public void setCarpetaRepositorio(String carpetaRepositorio) {
        this.carpetaRepositorio = carpetaRepositorio;
    }

    public String getBanderaBorrarAdjunto() {
        return banderaBorrarAdjunto;
    }

    public void setBanderaBorrarAdjunto(String banderaBorrarAdjunto) {
        this.banderaBorrarAdjunto = banderaBorrarAdjunto;
    }

    public String getNombreArchivoOriginal() {
        return nombreArchivoOriginal;
    }

    public void setNombreArchivoOriginal(String nombreArchivoOriginal) {
        this.nombreArchivoOriginal = nombreArchivoOriginal;
    }

    public String getNombreArchivoRepositorio() {
        return nombreArchivoRepositorio;
    }

    public void setNombreArchivoRepositorio(String nombreArchivoRepositorio) {
        this.nombreArchivoRepositorio = nombreArchivoRepositorio;
    }

    public String getBanderaComprimido() {
        return banderaComprimido;
    }

    public void setBanderaComprimido(String banderaComprimido) {
        this.banderaComprimido = banderaComprimido;
    }

    public String getEstatusArchivo() {
        return estatusArchivo;
    }

    public void setEstatusArchivo(String estatusArchivo) {
        this.estatusArchivo = estatusArchivo;
    }

    public String getDescripcionAdjunto() {
        return descripcionAdjunto;
    }

    public void setDescripcionAdjunto(String descripcionAdjunto) {
        this.descripcionAdjunto = descripcionAdjunto;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getPersIdAdjunto() {
        return persIdAdjunto;
    }

    public void setPersIdAdjunto(String persIdAdjunto) {
        this.persIdAdjunto = persIdAdjunto;
    }
    
    

}
