package br.com.confidencecambio.javabasico.service;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloServiceTest {

    private HelloService service;

    @Before
    public void init(){
         service = new HelloService();
    }

    @Test
    public void quandoPassarUmNomeQueroEleDeResposta(){
        var nome = "Wenner";
        String valorValido = service.retornaValorValido(nome);
        assertEquals(nome,valorValido);
    }

    @Test
    public void quandoPassarNuloQueroOPadrao(){

        String valorValido = service.retornaValorValido(null);
        assertEquals("Mundo",valorValido);
    }

    @Test
    public void quandoPassarUmValorMaiusculoQueroMinusculo(){

        String valorValido = service.retornaValorValido("MUNDO").toLowerCase();
        assertEquals("mundo",valorValido);
    }

    @Test
    public void quandoPassarUmValorQueroTamanhoDele(){

        String valorValido = service.retornaValorValido("Mundo");
        int tamanhoValor= valorValido.length();
        assertEquals(5,tamanhoValor);
    }
    
}