package br.com.confidencecambio.javabasico.service;

import java.text.DecimalFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ImcService {
    private Double imc = 0.0;

    public Double calculaIMC(@Nullable Double peso,@Nullable Double altura) {
        imc = peso / (Math.pow(altura, 2));
        return imc;
    }

    public String exibiMensagemIMC(Double imc) {
        String imcFormatado = retornaIMCpersonalizado(imc);
        StringBuilder mensagemIMC=new StringBuilder();
        mensagemIMC.append("O seu IMC é: ");
        mensagemIMC.append(imcFormatado);
        mensagemIMC.append("\nClassificação: " + retornaClassificacaoImc());
        mensagemIMC.append("\nPara mais detalhes baixe meu aplicativo na Play Store");
        mensagemIMC.append("\nPara calcular o seu imc! Foi feito com o framework Flutter");
        mensagemIMC.append("\nBaixe em: https://play.google.com/store/apps/details?id=com.alcideswenner.flutter_app");
        return mensagemIMC.toString();
    }

    public String retornaClassificacaoImc() {
        if (imc < 18.5) {
            return "Baixo Peso";
        } else if (imc > 18.5 && imc < 24.9) {
            return "Peso Normal";
        } else if (imc > 25.0 && imc < 29.9) {
            return "Excesso de Peso";
        } else if (imc > 30.0 && imc < 34.9) {
            return "Obesidade de Classe 1";
        } else if (imc > 35.0 && imc < 39.9) {
            return "Obesidade de Classe 2";
        } else if (imc >= 40.0) {
            return "Obesidade de Classe 3";
        } else {
            return "Digite um valor válido";
        }
    }

    public String retornaIMCpersonalizado(Double imc){
        DecimalFormat formater = new DecimalFormat("0.00");
        String imcFormatado = formater.format(imc).replace(",", ".");
        return imcFormatado;
    }
}
