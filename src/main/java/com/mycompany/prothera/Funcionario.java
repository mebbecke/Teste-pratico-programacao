package com.mycompany.prothera;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Period;
import java.util.Locale;

public class Funcionario extends Pessoa {
    protected BigDecimal salario;
    protected String funcao;
    
    // Construtor de Funcionario
    public Funcionario(String nome, LocalDate nasc, BigDecimal salario, String funcao) {
        this.nome = nome;
        this.nasc = nasc;
        this.salario = salario;
        this.funcao = funcao;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    public BigDecimal getSalario() {
        return salario;
    }
    
    public String getFuncao() {
        return funcao;
    }
    
    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(nasc, hoje);
        return idade.getYears();
    }
    
    public String getNome() {
        return nome;
    }
    
    // Método para imprimir os funcionários e seus atributos
    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormatter = NumberFormat.getInstance(new Locale("pt", "BR"));
        numberFormatter.setMinimumFractionDigits(2);
        numberFormatter.setMaximumFractionDigits(2);
        
        return "Nome: " + nome + " / " + "Data de nascimento: " + nasc.format(dateFormatter) + " / " + 
                "Salário: " + numberFormatter.format(salario) + " / " + "Funcão: " + funcao;
    }
}
