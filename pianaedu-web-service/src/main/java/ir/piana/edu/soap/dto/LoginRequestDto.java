package ir.piana.edu.soap.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

@XmlRootElement
@XmlType(name = "LoginRequestDto")
public class LoginRequestDto implements Serializable {
    private String userName;
    private String password;
    private int domainId;
    private Channel channel;
    private String ipAddress;
    private boolean getToken;

    public LoginRequestDto() {
    }

    public LoginRequestDto(String userName, String password, int domainId, Channel channel, String ipAddress, boolean getToken) {
        this.userName = userName;
        this.password = password;
        this.domainId = domainId;
        this.channel = channel;
        this.ipAddress = ipAddress;
        this.getToken = getToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isGetToken() {
        return getToken;
    }

    public void setGetToken(boolean getToken) {
        this.getToken = getToken;
    }
}
