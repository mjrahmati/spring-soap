package ir.piana.edu.soap.client;

import ir.piana.edu.soap.dto.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.xml.namespace.QName;

@Service
public class SoapClientService {
    private final WebServiceTemplate webServiceTemplate;

    private static final String Login_URL = "http://192.168.102.105:8080/services/AAAService/login?wsdl";
    private static final String Logout_URL = "http://192.168.102.105:8080/services/AAAService/logout?wsdl";

    public SoapClientService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public LoginResult login(String username, String password, Channel channel, int domainId) {
        LoginRequestDto request = new LoginRequestDto();
        request.setUserName(username);
        request.setPassword(password);
        request.setChannel(channel);
        request.setDomainId(domainId);

        Login login = new Login();
        login.setLoginRequestDto(request);

        try {
            JAXBElement<Login> loginJaxb
                    = new JAXBElement<Login>(new QName("http://dto.soap.edu.piana.ir", "login"),
                    Login.class, login);

            JAXBElement jaxbElement = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                    Login_URL, loginJaxb);
            return ((LoginResponse) jaxbElement.getValue()).getReturn();
        } catch (SoapFaultClientException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void logout(String token) {
        Logout logout = new Logout();
        logout.setToken(token);
        try {
            JAXBElement<Logout> logoutJaxb
                    = new JAXBElement<>(new QName("http://dto.soap.edu.piana.ir", "logout"),
                    Logout.class, logout);

            JAXBElement jaxbElement = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                    Login_URL, logoutJaxb);
            LogoutResponse logoutResponse = ((LogoutResponse) jaxbElement.getValue());
        } catch (SoapFaultClientException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
