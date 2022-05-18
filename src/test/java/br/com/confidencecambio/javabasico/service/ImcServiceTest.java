package br.com.confidencecambio.javabasico.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ImcServiceTest {

    private ImcService service;

    @Before
    public void init() {
        service = new ImcService();
    }

    @Test
    public void quandoPassarAlturaPesoQueroValor() {
        assertEquals(24.508945765204302, service.calculaIMC(70.0, 1.69));
    }

    @Test
    public void quandoPassarAlturaPesoQueroValorPersonalizado() {
        assertEquals("24.51", service.retornaIMCpersonalizado(service.calculaIMC(70.0, 1.69)));
    }
}
