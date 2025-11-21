package org.ucsal.poo.pf20252.br;
import java.text.DecimalFormat;

/**
 * Classe que contém os atributos base que devem está presentes em qualquer tipo de veículo que venha a se tornar locável
 */
public abstract class Veiculo {
    private String placa;
    private String modelo;
    private double valorDiaria;

    DecimalFormat df = new DecimalFormat("#.##");

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Construtor base para todos os novos tipos de veículo que vierem a surgir e que serão instanciados
     * @param placa Preenche-se a placa no padrão MercoSul LLLNLNN ou no padrão antigo Brasileiro LLLNNNN
     * @param modelo Preenche com o modelo que o tipo de veículo possui ex: xre 300 caso fosse uma moto, ford KA caso fosse um carro
     */
    public  Veiculo(String placa, String modelo, double valorDiaria){


       this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
   }

    /**
     * Método utilizado para calcular o valor da locacao, é sobrescrito em todas as subclasses adicionando o percentual pelo tipo de veículo
     * @param dias parametro que indica por quantos dias o usuário prentende utilizar o veículo
     * @return Retorna o valor a ser pago, já com os adicionais do tipo de veículo
     */
    public abstract double calcularValorLocacao(int dias);

}


class Carro extends Veiculo {

    public Carro(String placa, String modelo, double valorDiaria) {

        super(placa, modelo, valorDiaria);
    }
    @Override
    public double calcularValorLocacao(int dias){

        double valor = (getValorDiaria() * dias) * 1.1;
        System.out.println("O valor da locação de um carro para " + dias + " dias é de R$ " + df.format( valor));
        return valor;
    }
}

class Moto extends Veiculo {
    public Moto(String placa, String modelo, double valorDiaria) {
        super(placa, modelo, valorDiaria);
    }
    @Override
    public double calcularValorLocacao(int dias){
        double valor = getValorDiaria() * dias;
        System.out.println("O valor da locação de uma moto para " + dias + " dias é de R$ " + df.format( valor));
        return valor;
    }
}

class Caminhao extends Veiculo {

    public Caminhao(String placa, String modelo, double valorDiaria) {
        super(placa, modelo, valorDiaria);
    }

    @Override
    public double calcularValorLocacao(int dias){
        double valor = (getValorDiaria() * dias) * 1.15;

        System.out.println("O valor da locação  de um caminhão para " + dias + " dias é de R$ " + df.format( valor));
        return valor;
    }
}
