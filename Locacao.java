package org.ucsal.poo.pf20252.br;

public class Locacao implements Locavel {
   private String dataInicio;
   private String dataFim;
   private double valorTotal;
   private Cliente cliente;
   private Veiculo veiculo;

   /**
    * Construtor utilizado similiarmente como uma tabela associativa, armazena todas as informações referentes a locação
    * @param inicio Data em que a locacão se inicia
    * @param fim Data em que a locacao deve se encerrar
    */


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
