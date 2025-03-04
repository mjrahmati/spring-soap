package ir.piana.edu.soap;

import ir.piana.edu.soap.service.AAAWebService;
import jakarta.servlet.Servlet;
import jakarta.xml.ws.WebServiceContext;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.context.WebServiceContextImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {
    @Bean
    WebServiceContext webServiceContext() {
        return new WebServiceContextImpl();
    }

    @Bean
    public EndpointImpl endpoint(SpringBus springBus, AAAWebService aaaWebService) {
        EndpointImpl endpoint = new EndpointImpl(springBus, aaaWebService);
        endpoint.publish("/AAAService");
        return endpoint;
    }

    @Bean
    public ServletRegistrationBean<Servlet> wsServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/services/*");
    }
}
