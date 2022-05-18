package br.com.confidencecambio.javabasico.service;

import org.junit.Before;
import org.junit.Test;

public class ImcServiceTest {

    private ImcService service;

    @Before
    public void init() {
        service = new ImcService();
    }

    @Test
    public void quandoPassarUmNomeQueroEleDeResposta() {
        System.out.println(service.calculaIMC(70.0, 1.69));
    }
}
