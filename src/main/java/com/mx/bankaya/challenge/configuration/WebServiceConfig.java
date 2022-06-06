package com.mx.bankaya.challenge.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

/**
 * Configuration Class that receives the SOAP request
 * @author Sarahy Ramirez
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Autowired
    private InterceptorEndpoint interceptorEndpoint;

    /**
     * Handles SOAP request
     * @param applicationContext
     * @return servlet
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * Exposes a standard WSDL 1.1 using an XsdSchema
     * @param pokemonSchema
     * @return wsdl11Definition
     */
    @Bean(name = "pokemon")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokemonSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PokemonPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://pokemon/challenge/bankaya-web-service");
        wsdl11Definition.setSchema(pokemonSchema);
        return wsdl11Definition;
    }

    /**
     * Creates a XsdSchema
     * @return XsdSchema
     */
    @Bean
    public XsdSchema pokemonSchema() {
        return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
    }

    /**
     * Register a global interceptor
     * @param interceptors
     */
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(interceptorEndpoint);
    }
}
