package org.ucsal.poo.pf20252.br;

/**
 * Classe que armazena os dados daquele que está realizando a locação do veículo
 */
public class Cliente {
    private String nome;
    private String Cpf;
    private int idade;

    /**
     * Construtor para instanciar o objeto cliente da classe
     * @param nome Nome do Cliente, possui regra de negócio de no mínimo 6 caracteres
     * @param cpf CPF segue o padrão fixo de 11 caracteres (ignorando os traços e pontos)
     * @param idade Idade do cliente, deve ser igual ou superior a 18 para prosseguir
     */
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
