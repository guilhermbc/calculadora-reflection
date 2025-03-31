package edu.ifes.controller;
import edu.ifes.model.Calculadora;
import edu.ifes.model.Operacao;
import java.util.List;

public class ControladorCalculadora {
    public double calcular(List<Operacao> operacoes, int op, double num1, double num2){
        Calculadora calculadora = new Calculadora();
        try{
            return calculadora.calcular(operacoes, op, num1, num2);
        }
        catch(ArithmeticException e){
            throw new ArithmeticException(e.getMessage());
        }
    }
}
