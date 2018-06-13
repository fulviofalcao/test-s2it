package br.com.s2it.service.core;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class AbstractWsService {	

	@Autowired
	protected AppPropertiesService appService;
	
	protected Object GET(String path, Class<?> clazz, String...params){
		String url = getUrl(path, params);
		
		ResponseWS responseWS = new RestTemplate().exchange(url, HttpMethod.GET, header(), ResponseWS.class).getBody();
		if(responseWS.getResult() != null){
			if(isArrayList(responseWS)){
				return listConverter((List<?>) responseWS.getResult(), clazz); 
			}
			return Optional.of(converter(responseWS.getResult(), clazz)).orElse(null);
		}
		return null;
	}
	
	private boolean isArrayList(ResponseWS responseWS) {
		return responseWS.getResult().getClass().getTypeName().equals("java.util.ArrayList");
	}

	private List<?> listConverter(List<?> results, Class<?> clazz) {
		return results.stream().map(r -> converter(r, clazz)).collect(Collectors.toList());
	}
	
	private String getUrl(String path, String[] params) {
		String url = appService.getApiBaseUrl() + path;
		url = putParams(url, params);
		return url;
	}
	
	private HttpEntity<String> header(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Token());
		
		return new HttpEntity<String>(headers);
	}
	
	private String putParams(String url, String... params) {
		String joinedParams = Stream.of(params)
				.map(s -> s).collect(Collectors.joining("/"));
		
		return url + joinedParams;
	}
	
	private Object converter(Object object, Class<?> clazz){
		return new ObjectMapper().convertValue(object, clazz);
	}
	
	private String base64Token() {
		byte[] plainCredsBytes = "s2it:s2it".getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		return base64Creds;
	}

}
