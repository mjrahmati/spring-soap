package ir.piana.edu.soap.dto;


import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "JAXBDocument")
//@XmlType(name="LoginResponse")
public class LoginResult implements Serializable {
    private int resultCode;
    private UserInfo userInfo;

    public LoginResult() {
    }

    public LoginResult(int resultCode, UserInfo userInfo) {
        this.resultCode = resultCode;
        this.userInfo = userInfo;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


}
