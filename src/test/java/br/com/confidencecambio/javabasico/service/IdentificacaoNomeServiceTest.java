package br.com.confidencecambio.javabasico.service;

import org.junit.Before;
import org.junit.Test;

import br.com.confidencecambio.javabasico.models.Cliente;
import br.com.confidencecambio.javabasico.models.Gerente;
import br.com.confidencecambio.javabasico.models.Robo;

import static org.junit.Assert.assertEquals;

public class IdentificacaoNomeServiceTest {
    
    private IdentificacaoNomeService service;

    @Before
    public void init() {
        service = new IdentificacaoNomeService();
    }

    @Test
    public void quandoPassarUmClienteComNomeNuloQueroPadrao() {
        Cliente cliente=new Cliente(null);
        String valorValido = service.retornaValorValido(cliente);
        assertEquals("Wenner",valorValido);
    }

    @Test
    public void quandoPassarUmGerenteComNomeNuloQueroPadrao() {
        Gerente gerente=new Gerente(null);
        String valorValido = service.retornaValorValido(gerente);
        assertEquals("Wenner",valorValido);
    }

    @Test
    public void quandoPassarUmRoboComNomeNuloQueroPadrao() {
        Robo robo=new Robo(null);
        String valorValido = service.retornaValorValido(robo);
        assertEquals("Wenner",valorValido);
    }
    
    @Test
    public void quandoPassarUmClienteQueroSeuPrimeiroNome() {
        Cliente cliente=new Cliente("Alcides Wenner Ferreira Bastos");
        assertEquals("Alcides",service.retornaPrimeiroNome(cliente));
    }

    @Test
    public void quandoPassarUmGerenteQueroSeuPrimeiroNome() {
        Gerente gerente=new Gerente("João Paulo Lima");
        assertEquals("João",service.retornaPrimeiroNome(gerente));
    }

    @Test
    public void quandoPassarUmRoboQueroSeuPrimeiroNome() {
        Robo robo=new Robo("Andrew Martin");
        assertEquals("Andrew",service.retornaPrimeiroNome(robo));
    }

    @Test
    public void quandoPassarUmClienteQueroNomeTodoMaisculo() {
        Cliente cliente=new Cliente("Alcides Wenner Ferreira Bastos");
        assertEquals("ALCIDES WENNER FERREIRA BASTOS",service.retornaNomeTodoMaiusculo(cliente));
    }

    @Test
    public void quandoPassarUmGerenteQueroNomeTodoMaisculo() {
        Gerente gerente=new Gerente("João Paulo Lima");
        assertEquals("JOÃO PAULO LIMA",service.retornaNomeTodoMaiusculo(gerente));
    }

    @Test
    public void quandoPassarUmRoboQueroNomeTodoMaisculo() {
        Robo robo=new Robo("Andrew Martin");
        assertEquals("ANDREW MARTIN",service.retornaNomeTodoMaiusculo(robo));
    }

    @Test
    public void quandoPassarUmClienteQueroNomeAbreviado() {
        Cliente cliente=new Cliente("Alcides Wenner Ferreira Bastos");
        assertEquals("Alcides W. Ferreira Bastos",service.retornaNomeAbreviado(cliente));
    }

    @Test
    public void quandoPassarUmGerenteQueroNomeAbreviado() {
        Gerente gerente=new Gerente("João Paulo Lima");
        assertEquals("João P. Lima",service.retornaNomeAbreviado(gerente));
    }

    @Test
    public void quandoPassarUmRoboQueroNomeAbreviado() {
        Robo robo=new Robo("Andrew Pow Specter");
        assertEquals("Andrew P. Specter",service.retornaNomeAbreviado(robo));
    }

    
    @Test
    public void quandoPassarUmClienteQueroOsUltimosNomes() {
        Cliente cliente=new Cliente("Alcides Wenner Ferreira Bastos");
        assertEquals("Wenner Ferreira Bastos",service.retornarUltimoNome(cliente));
    }

    @Test
    public void quandoPassarUmGerenteQueroOsUltimosNomes() {
        Cliente cliente=new Cliente("Antonio Bastos Lima");
        assertEquals("Bastos Lima",service.retornarUltimoNome(cliente));
    }

    @Test
    public void quandoPassarUmRoboQueroOsUltimosNomes() {
        Cliente cliente=new Cliente("Google Assistente USA");
        assertEquals("Assistente USA",service.retornarUltimoNome(cliente));
    }
}
