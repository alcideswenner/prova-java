package br.com.confidencecambio.javabasico.controllers;

import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.confidencecambio.javabasico.service.ImcService;

@RestController
@Validated
public class ImcRs {
    private ImcService service;

    public ImcRs(final ImcService service) {
        this.service = service;
    }

    @GetMapping("/calcula-imc")
    public ResponseEntity<String> calculaTeste(
            @RequestParam("altura") @NotNull Double altura,
            @RequestParam("peso") @NotNull Double peso) {

        String mensagemIMC = service.exibiMensagemIMC(service.calculaIMC(peso, altura));
        return ResponseEntity.ok().body(mensagemIMC);
    }
}
