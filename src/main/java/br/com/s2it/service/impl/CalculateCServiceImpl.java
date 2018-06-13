package br.com.s2it.service.impl;

/**
 Dados dois numeros inteiros A e B, crie um terceiro inteiro C seguindo as seguintes
regras:
	- O primeiro número de C é o primeiro número de A;
	- O segundo número de C é o primeiro número de B;
	- O terceiro número de C é o segundo número de A;
	- O quarto número de C é o segundo número de B;
	Assim sucessivamente...
	
	- Caso os números de A ou B sejam de tamanhos diferentes, completar C com o restante
dos números do inteiro maior. Ex: A = 10256, B = 512, C deve ser 15012256.
	- Caso C seja maior que 1.000.000, retornar -1

Desenvolva um algoritmo que atenda a todos os requisitos acima.
 
 */
import java.math.BigInteger;

import org.springframework.stereotype.Service;

import br.com.s2it.service.CalculateCService;
import br.com.s2it.service.core.AbstractWsService;
import br.com.s2it.ws.CalculateCResponse;

/**
 * 
 * @author fulvio.falcao
 *
 */
@Service
public class CalculateCServiceImpl extends AbstractWsService implements CalculateCService{

	@Override
	public CalculateCResponse getCalculateC(Integer number1, Integer number2) {
		CalculateCResponse calculateCResponse = new CalculateCResponse();		
		StringBuilder numberC = new StringBuilder();

		char[] arrayNumber1 = Integer.valueOf(number1).toString().toCharArray();
		char[] arrayNumber2 = Integer.valueOf(number2).toString().toCharArray();

		for (int i = 0; i < arrayNumber1.length + arrayNumber2.length; i++) {
			if (arrayNumber1.length > i) {
				numberC.append(arrayNumber1[i]);
			}

			if (arrayNumber2.length > i) {
				numberC.append(arrayNumber2[i]);
			}
		}
		calculateCResponse.setNumberC(BigInteger.valueOf(Integer.parseInt(numberC.toString())> 1000000 ? -1 : Integer.parseInt(numberC.toString())));
		
		return calculateCResponse;
	}

}
