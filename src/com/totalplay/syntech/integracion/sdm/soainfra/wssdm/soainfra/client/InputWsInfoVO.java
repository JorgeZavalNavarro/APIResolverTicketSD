package com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client;

/**
 *
 * @author dell
 */
public class InputWsInfoVO {

    // Propiedades de la clase
    private String UserId = null;
    private String Password = null;
    private String Ip = null;
    private String NoTicket = null;
    private String Status = null;
    private String SubStatus = null;
    private String Comment = null;
    private String Bandeja = null;
    private String ticketSF = null;

    public InputWsInfoVO() {
    }

    public InputWsInfoVO(String UserId, String Password, String Ip, String NoTicket,
            String Status, String SubStatus, String Comment, String Bandeja, String ticketSF) {
        this.UserId = UserId;
        this.Password = Password;
        this.Ip = Ip;
        this.NoTicket = NoTicket;
        this.Status = Status;
        this.SubStatus = SubStatus;
        this.Comment = Comment;
        this.Bandeja = Bandeja;
        this.ticketSF = ticketSF;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String Ip) {
        this.Ip = Ip;
    }

    public String getNoTicket() {
        return NoTicket;
    }

    public void setNoTicket(String NoTicket) {
        this.NoTicket = NoTicket;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSubStatus() {
        return SubStatus;
    }

    public void setSubStatus(String SubStatus) {
        this.SubStatus = SubStatus;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getBandeja() {
        return Bandeja;
    }

    public void setBandeja(String Bandeja) {
        this.Bandeja = Bandeja;
    }

    public String getTicketSF() {
        return ticketSF;
    }

    public void setTicketSF(String ticketSF) {
        this.ticketSF = ticketSF;
    }

    
    
    
    @Override
    public String toString() {
        return "InputWsInfoVO{" + "UserId=" + UserId + ", Password=" + Password + ", Ip=" + Ip + ", NoTicket=" + NoTicket + ", Status=" + Status + ", SubStatus=" + SubStatus + ", Comment=" + Comment + ", Bandeja=" + Bandeja + ", ticketSF=" + ticketSF + '}';
    }
    
    
    
    
}
