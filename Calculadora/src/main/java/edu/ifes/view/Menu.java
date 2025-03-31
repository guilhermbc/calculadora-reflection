package edu.ifes.view;
import edu.ifes.controller.ControladorCalculadora;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import edu.ifes.model.Operacao;
import org.reflections.Reflections;

public class Menu {
    public void mostrarOpcoes(List<Operacao> operacoes){
        //Imprimir o menu
        System.out.println("-------CALCULADORA-------");
        for (int i = 0; i < operacoes.size(); i++) {
            System.out.println((i + 1) + ") " + operacoes.get(i).getClass().getSimpleName());
        }
        System.out.println("0) Sair");
    }

    public int lerOpcao(List<Operacao> operacoes, Scanner s){
        //Ler a opção do menu digitada pelo usuário
        int opcao;
        while (true){
            try{
                this.mostrarOpcoes(operacoes);
                System.out.print("\nEscolha o numero correspondente a operacao que "
                        + "deseja realizar: ");
                opcao = s.nextInt();
                if ((opcao >= 0) && (opcao <= operacoes.size() + 1)) return opcao;
                System.out.println("Opcao invalida.");
            }
            catch(InputMismatchException e){
                System.out.println("Valor invalido. Digite um numero inteiro. ");
                s.next();
            }
        }
    }

    public void exibir() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner s = new Scanner(System.in);
        int opcao;
        double num1, num2, resultado;
        Reflections reflections = new Reflections("ifes.edu.br.model");

        //Cria um set com todas as operações do pacote modelo
        Set<Class<? extends Operacao>> classes = reflections.getSubTypesOf(Operacao.class);

        //Cria lista com instâncias das operações
        List<Operacao> operacoes = new ArrayList<>();
        for (Class<? extends Operacao> clazz : classes){
            operacoes.add(clazz.getDeclaredConstructor().newInstance());
        }

        //Ler a opção do menu digitada pelo usuário
        opcao = lerOpcao(operacoes, s);

        while(opcao != 0){
            System.out.print("Digite o primeiro numero: ");
            num1 = s.nextDouble();
            System.out.print("Digite o segundo numero: ");
            num2 = s.nextDouble();

            ControladorCalculadora controlador = new ControladorCalculadora();

            try{
                resultado = controlador.calcular(operacoes, opcao, num1, num2);
                System.out.println("O resultado e " + resultado + "\n");
            }
            catch(ArithmeticException e){
                System.out.println(e.getMessage());
            }

            //Ler a opção do menu digitada pelo usuário
            opcao = lerOpcao(operacoes, s);
        }

        System.out.println("Ate mais!");
    }
}
