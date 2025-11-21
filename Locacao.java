package org.ucsal.poo.pf20252.br;

public class Locacao implements Locavel {
   private String dataInicio;
   private String dataFim;
   private double valorTotal;
   private Cliente cliente;
   private Veiculo veiculo;

   public Locacao(Cliente cliente, Veiculo veiculo, String inicio, String fim, int dias) {
      this.cliente = cliente;
      this.veiculo = veiculo;
      dataInicio = inicio;
      dataFim = fim;
      this.valorTotal = veiculo.calcularValorLocacao(dias);
   }

   @Override
   public void iniciarLocacao(){
      System.out.println("Locação Iniciada com sucesso!!!");
   }

   @Override
   public void finalizarLocacao(){
      System.out.println("Locação Finalizada");
   }
}
