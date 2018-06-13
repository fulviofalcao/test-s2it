package br.com.s2it.service.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@ConfigurationProperties(prefix="app")
public class AppPropertiesService {

	@Getter @Setter
	private String apiBaseUrl;
	
	@Getter @Setter
	private String soapAddress;
}
