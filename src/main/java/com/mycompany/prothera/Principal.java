package com.mycompany.prothera;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.text.DecimalFormat;

public class Principal {

    public static void main(String[] args) {
        
        // Criando a lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        
        // Instanciando os funcionários
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador");
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente");
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente");
        
        // Inserindo os funcionários na lista
        funcionarios.add(maria);
        funcionarios.add(joao);
        funcionarios.add(caio);
        funcionarios.add(miguel);
        funcionarios.add(alice);
        funcionarios.add(heitor);
        funcionarios.add(arthur);
        funcionarios.add(laura);
        funcionarios.add(heloisa);
        funcionarios.add(helena);
        
        // Removendo o funcionário João
        funcionarios.remove(joao);
        
        // Imprimindo os funcionários
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
        
        // Atualizando os salários
        for (Funcionario funcionario : funcionarios) {
            double aumento = 1.10;
            double salarioDouble = funcionario.salario.doubleValue();
            double novoSalario = aumento * salarioDouble;
            
            funcionario.setSalario(new BigDecimal(novoSalario));
        }
        
        // Agrupando os funcionários com MAP
        Map<String, List<Funcionario>> agrupamento = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            if (!agrupamento.containsKey(funcionario.getFuncao())) {
                agrupamento.put(funcionario.getFuncao(), new ArrayList<>());
            }
            agrupamento.get(funcionario.getFuncao()).add(funcionario);
        }
        
        // Imprimindo os funcionários agrupados por função
        System.out.println("Funcionários agrupados por função: " + agrupamento);
        
        // Imprimindo quem faz aniversário no mês 10 e 12
        for (Funcionario funcionario : funcionarios) {
            int mes = funcionario.nasc.getMonthValue();
            if (mes == 10 || mes == 12){
                System.out.println(funcionario.toString());
            }
        }
        
        // Obtendo e imprimindo o funcionário com maior idade, seu nome e idade
        Comparator<Funcionario> comparadorIdade = new Comparator<Funcionario>() {
            public int compare(Funcionario f1, Funcionario f2) {
                return Integer.compare(f1.getIdade(), f2.getIdade());
            }
        };
        Funcionario maisVelho = Collections.max(funcionarios, comparadorIdade);
        System.out.println("Funcionário mais velho: " + maisVelho.nome + " / " 
                                    + maisVelho.getIdade() + " anos de idade.");

        // Imprimindo os funcionários por ordem alfabética
        Collections.sort(funcionarios, (f1, f2) -> f1.getNome().compareTo(f2.getNome()));

        System.out.println("Funcionários em ordem alfabética: ");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
        
        // Imprimindo o total dos salários dos funcionários
        BigDecimal soma = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            soma = soma.add(funcionario.getSalario());
        }
        System.out.println("Soma de todos os salários: " + soma.setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        
        // Imprimindo quantos salários mínimos cada funcionário ganha
        System.out.println("Quantos salários mínimos cada funcionário ganha: ");
        for (Funcionario funcionario : funcionarios) {
            double salDouble = funcionario.salario.doubleValue();
            double salMin = salDouble / 1212.00;
            String salMinFormatado = String.format("%.1f", salMin);
            System.out.println(funcionario.nome + " ganha " + salMinFormatado + " salários mínimos.");
        }
        
    }   
}
