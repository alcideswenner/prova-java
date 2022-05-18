package br.com.confidencecambio.javabasico.service;

import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.com.confidencecambio.javabasico.models.IdentificacaoNome;

@Component
public class IdentificacaoNomeService {

    private static final String valorPadrao = "Wenner";

    public String retornaValorValido(@Nullable IdentificacaoNome identificacaoNome) {
        if (identificacaoNome.getNome() != null && Optional.of(identificacaoNome.getNome()).isEmpty()) {
            return Optional.of(valorPadrao).get();
        }
        return Optional.ofNullable(identificacaoNome.getNome()).orElse(valorPadrao).trim();
    }

    public String retornaPrimeiroNome(@Nullable IdentificacaoNome identificacaoNome) {
        String nomeValido = retornaValorValido(identificacaoNome);
        String primeiroNome = nomeValido.split(" ")[0];

        return primeiroNome;
    }

    public String retornaNomeTodoMaiusculo(@Nullable IdentificacaoNome identificacaoNome) {
        String nomeValido = retornaValorValido(identificacaoNome);
        String nomeMaiusculo = nomeValido.toUpperCase();

        return nomeMaiusculo;
    }

    public String retornaNomeAbreviado(@Nullable IdentificacaoNome identificacaoNome) {
        String nomeValido = retornaValorValido(identificacaoNome);
        String segundoNome = "";
        String primeiraLetraDoSegundoNome = "";
        String nomeAbreviado= null;
        if (nomeValido.contains(" ")) {
            segundoNome = nomeValido.split(" ")[1];
            primeiraLetraDoSegundoNome = segundoNome.charAt(0) + ".";
            nomeAbreviado = nomeValido.replace(segundoNome, primeiraLetraDoSegundoNome);
        }
        
        return Optional.ofNullable(nomeAbreviado).orElse(nomeValido);
    }

    public String retornarUltimoNome(@Nullable IdentificacaoNome identificacaoNome) {
        String nomeValido = retornaValorValido(identificacaoNome);
        String primeiroNome = "";
        String ultimosNomes = "";

        if (nomeValido.contains(" ")) {
            primeiroNome = nomeValido.split(" ")[0];
            ultimosNomes = nomeValido.replace(primeiroNome+" ", "");
        }
        
        return Optional.ofNullable(ultimosNomes).orElse(nomeValido);
    }
}
