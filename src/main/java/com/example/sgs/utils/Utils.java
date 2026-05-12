package com.example.sgs.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    public static String formatarCPFOuCNPJ(String CPFOuCNPJ) {
        String numero = CPFOuCNPJ.replaceAll("\\D", "");

        if (numero.length() == 11) {
            return numero.replaceFirst(
                    "(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
                    "$1.$2.$3-$4"
            );
        }
        if (numero.length() == 14) {
            return numero.replaceFirst(
                    "(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})",
                    "$1.$2.$3/$4-$5"
            );
        }

        throw new RuntimeException("CPF OU CNPJ inválido");
    }

    public static String formatarMoeda(BigDecimal valor) {
        if (valor == null) {
            return "R$ 0,00";
        }

        NumberFormat formato = NumberFormat.
                getCurrencyInstance(Locale.of("pt", "BR"));

        return formato.format(valor);
    }
}
