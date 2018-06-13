package br.com.s2it.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
	@Bean(name = "calculateC")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema calculateCSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CalculateCPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://s2it.com.br/ws");
		wsdl11Definition.setSchema(calculateCSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema calculateCSchema() {
		return new SimpleXsdSchema(new ClassPathResource("calculateCSchema.xsd"));
	}
	
	@Bean(name = "sumBinaryTree")
	public DefaultWsdl11Definition defaultWsdl12Definition(XsdSchema sumBinaryTreeSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("SumBinaryTreePort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://s2it.com.br/ws");
		wsdl11Definition.setSchema(sumBinaryTreeSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema sumBinaryTreeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("binaryTreeSchema.xsd"));
	}
}
