package org.ucsal.poo.pf20252.br;
import java.text.DecimalFormat;

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

    public  Veiculo(String placa, String modelo, double valorDiaria){


       this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
   }
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
