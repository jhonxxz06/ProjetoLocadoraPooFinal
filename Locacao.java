package org.ucsal.poo.pf20252.br;
import java.util.Scanner;
/**
 * Classe responsável por conter todos os dados referentes a locaço de um veículo
 */
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
      System.out.println("========\nLocação Iniciada com sucesso!!!\n========");
   }

   @Override
   public void finalizarLocacao(){
      System.out.println("========\nLocação Finalizada\n========");
   }

   /**
    * Metodo utilizado para o sistema confirmar se o cliente aprova a locação e se pode enfim chamar a interface finalizarLocacao ou se retornar ao menu de escolhas
    * @return Retorna um dado booleano para ser lido por estruturas condicionais
    */
   public boolean confirmarLocacao() {
      Scanner ler = new Scanner(System.in);
      int confirmacao;
      while (true) {
         System.out.println("Cliente confirma a locacão do veículo? \n 1 - Sim  \n 2 - Não");
         confirmacao = ler.nextInt();
         switch (confirmacao) {
            case 1:
               return true;
             case 2:
               return false;
            default:
               System.out.println("Opção inválida tente novamente!");
               continue;
         }
      }
   }
}
