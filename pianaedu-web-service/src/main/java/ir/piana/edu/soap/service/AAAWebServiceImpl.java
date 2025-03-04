package ir.piana.edu.soap.service;

import ir.piana.edu.soap.dto.LoginRequestDto;
import ir.piana.edu.soap.dto.LoginResult;
import ir.piana.edu.soap.dto.UserInfo;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@WebService
public class AAAWebServiceImpl implements AAAWebService {
    @WebMethod(operationName = "login")
    public LoginResult login(
            @WebParam(name = "loginRequest") LoginRequestDto loginRequestDto
    ) {
        System.out.println("login called");
        return new LoginResult(0, new UserInfo(UUID.randomUUID().toString()));
    }

    @WebMethod(operationName = "logout")
    public void logout(@WebParam(name = "token") String token) {
        System.out.println("logout called");
    }
}
