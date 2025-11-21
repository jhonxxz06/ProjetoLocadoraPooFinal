package org.ucsal.poo.pf20252.br;

public class Cliente {
    private String nome;
    private String Cpf;
    private int idade;

    public Cliente(String nome, String cpf, int idade){
        if(nome.length() <= 5){
            throw new RuntimeException("Erro! Cliente informou um numero de caracteres insuficientes para seu nome, insira pelo menos 6!");
        }
        else if(cpf.length() != 11){
            throw new RuntimeException("CPF inválido!! insira dentro do limite fixo de 11 caracteres");
        }
        else if(idade < 18){
            throw new RuntimeException("Sua idade não te dá permissão para realizar a locacao de um veículo, mínimo 18 anos!!");
        }
        this.nome = nome;
        this.Cpf = cpf;
        this.idade = idade;
    }
}
