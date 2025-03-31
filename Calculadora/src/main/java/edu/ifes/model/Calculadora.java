package edu.ifes.model;
import java.util.List;

public class Calculadora {
    public double calcular(@org.jetbrains.annotations.NotNull List<Operacao> operacoes,
                           int opcao, double num1, double num2){

        try{
            return operacoes.get(opcao - 1).calcular(num1, num2);
        }
        catch(ArithmeticException e){
            throw new ArithmeticException(e.getMessage());
        }

    }
}
