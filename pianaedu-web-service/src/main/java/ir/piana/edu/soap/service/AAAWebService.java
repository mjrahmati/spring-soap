package ir.piana.edu.soap.service;

import ir.piana.edu.soap.dto.LoginRequestDto;
import ir.piana.edu.soap.dto.LoginResult;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.PayloadRoots;

@WebService(serviceName = "AAAService", targetNamespace = "http://dto.soap.edu.piana.ir")
public interface AAAWebService {
    @WebMethod(operationName = "login")
    @PayloadRoots({
            @PayloadRoot(namespace = "http://dto.soap.edu.piana.ir", localPart = "login"),
            @PayloadRoot(namespace = "http://dto.soap.edu.piana.ir", localPart = "loginResponse")
    })
    LoginResult login(
            @WebParam(name = "loginRequestDto") LoginRequestDto loginRequestDto
    );

    @WebMethod(operationName = "logout")
    @PayloadRoots({
            @PayloadRoot(namespace = "http://dto.soap.edu.piana.ir", localPart = "logout"),
            @PayloadRoot(namespace = "http://dto.soap.edu.piana.ir", localPart = "logoutResponse")
    })
    void logout(@WebParam(name = "token") String token);
}
