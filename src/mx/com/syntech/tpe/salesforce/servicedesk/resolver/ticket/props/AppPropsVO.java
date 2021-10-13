package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props;

/**
 * 
 * @author Jorge Zavala Navarro
 */
public class AppPropsVO {
    
    // Propiedades de la clase
    private String principalAmbiente = null;
    private String urlServicedeskWs = null;
    // private String urltpechangestatusWs = null;
    private String bddClassDriver = null;
    private String bddUrlFabricante = null;
    private String bddConexionServidor = null;
    private String bddConexionPuerto = null;
    private String bddConexionBasedatos = null;
    private String bddConexionUsuario = null;
    private String bddConexionPassword = null;
    private String queryTimeoutSecs = null;
    private String wssdTimeoutConect = null;
    private String wssdTimeoutRead=null;
    private String pathConfigLogs = null;
    private String wssdUsuario = null;
    private String wssdPassword = null;
    // private String urlTpeJustificacionWs = null;
    // private String urlTpeJicketupdateWs = null;
    private String urlTpeUpdateticketWs = null;
    private String chartsetconfig = null;
    private String languajeConfig = null;

    private String wsTpeChangestatusUsuario = null;
    private String wsTpeChangestatusPassword = null;
    
    
    public String getUrlServicedeskWs() {
        return urlServicedeskWs;
    }

    public void setUrlServicedeskWs(String urlServicedeskWs) {
        this.urlServicedeskWs = urlServicedeskWs;
    }

    public String getBddClassDriver() {
        return bddClassDriver;
    }

    public void setBddClassDriver(String bddClassDriver) {
        this.bddClassDriver = bddClassDriver;
    }

    public String getBddUrlFabricante() {
        return bddUrlFabricante;
    }

    public void setBddUrlFabricante(String bddUrlFabricante) {
        this.bddUrlFabricante = bddUrlFabricante;
    }

    public String getBddConexionServidor() {
        return bddConexionServidor;
    }

    public void setBddConexionServidor(String bddConexionServidor) {
        this.bddConexionServidor = bddConexionServidor;
    }

    public String getBddConexionPuerto() {
        return bddConexionPuerto;
    }

    public void setBddConexionPuerto(String bddConexionPuerto) {
        this.bddConexionPuerto = bddConexionPuerto;
    }

    public String getBddConexionBasedatos() {
        return bddConexionBasedatos;
    }

    public void setBddConexionBasedatos(String bddConexionBasedatos) {
        this.bddConexionBasedatos = bddConexionBasedatos;
    }

    public String getBddConexionUsuario() {
        return bddConexionUsuario;
    }

    public void setBddConexionUsuario(String bddConexionUsuario) {
        this.bddConexionUsuario = bddConexionUsuario;
    }

    public String getBddConexionPassword() {
        return bddConexionPassword;
    }

    public void setBddConexionPassword(String bddConexionPassword) {
        this.bddConexionPassword = bddConexionPassword;
    }

    public String getQueryTimeoutSecs() {
        return queryTimeoutSecs;
    }

    public void setQueryTimeoutSecs(String queryTimeoutSecs) {
        this.queryTimeoutSecs = queryTimeoutSecs;
    }

    public String getWssdTimeoutConect() {
        return wssdTimeoutConect;
    }

    public void setWssdTimeoutConect(String wssdTimeoutConect) {
        this.wssdTimeoutConect = wssdTimeoutConect;
    }

    public String getWssdTimeoutRead() {
        return wssdTimeoutRead;
    }

    public void setWssdTimeoutRead(String wssdTimeoutRead) {
        this.wssdTimeoutRead = wssdTimeoutRead;
    }

    public String getPathConfigLogs() {
        return pathConfigLogs;
    }

    public void setPathConfigLogs(String pathConfigLogs) {
        this.pathConfigLogs = pathConfigLogs;
    }

    public String getPrincipalAmbiente() {
        return principalAmbiente;
    }

    public void setPrincipalAmbiente(String principalAmbiente) {
        this.principalAmbiente = principalAmbiente;
    }

    public String getWssdUsuario() {
        return wssdUsuario;
    }

    public void setWssdUsuario(String wssdUsuario) {
        this.wssdUsuario = wssdUsuario;
    }

    public String getWssdPassword() {
        return wssdPassword;
    }

    public void setWssdPassword(String wssdPassword) {
        this.wssdPassword = wssdPassword;
    }

    

    public String getChartsetconfig() {
        return chartsetconfig;
    }

    public void setChartsetconfig(String chartsetconfig) {
        this.chartsetconfig = chartsetconfig;
    }

    public String getLanguajeConfig() {
        return languajeConfig;
    }

    public void setLanguajeConfig(String languajeConfig) {
        this.languajeConfig = languajeConfig;
    }

  
    public String getWsTpeChangestatusUsuario() {
        return wsTpeChangestatusUsuario;
    }

    public void setWsTpeChangestatusUsuario(String wsTpeChangestatusUsuario) {
        this.wsTpeChangestatusUsuario = wsTpeChangestatusUsuario;
    }

    public String getWsTpeChangestatusPassword() {
        return wsTpeChangestatusPassword;
    }

    public void setWsTpeChangestatusPassword(String wsTpeChangestatusPassword) {
        this.wsTpeChangestatusPassword = wsTpeChangestatusPassword;
    }

    public String getUrlTpeUpdateticketWs() {
        return urlTpeUpdateticketWs;
    }

    public void setUrlTpeUpdateticketWs(String urlTpeUpdateticketWs) {
        this.urlTpeUpdateticketWs = urlTpeUpdateticketWs;
    }

    @Override
    public String toString() {
        return "AppPropsVO{" + "principalAmbiente=" + principalAmbiente + ", urlServicedeskWs=" + urlServicedeskWs + ", bddClassDriver=" + bddClassDriver + ", bddUrlFabricante=" + bddUrlFabricante + ", bddConexionServidor=" + bddConexionServidor + ", bddConexionPuerto=" + bddConexionPuerto + ", bddConexionBasedatos=" + bddConexionBasedatos + ", bddConexionUsuario=" + bddConexionUsuario + ", bddConexionPassword=" + bddConexionPassword + ", queryTimeoutSecs=" + queryTimeoutSecs + ", wssdTimeoutConect=" + wssdTimeoutConect + ", wssdTimeoutRead=" + wssdTimeoutRead + ", pathConfigLogs=" + pathConfigLogs + ", wssdUsuario=" + wssdUsuario + ", wssdPassword=" + wssdPassword + ", urlTpeUpdateticketWs=" + urlTpeUpdateticketWs + ", chartsetconfig=" + chartsetconfig + ", languajeConfig=" + languajeConfig + ", wsTpeChangestatusUsuario=" + wsTpeChangestatusUsuario + ", wsTpeChangestatusPassword=" + wsTpeChangestatusPassword + '}';
    }

    
   
}
