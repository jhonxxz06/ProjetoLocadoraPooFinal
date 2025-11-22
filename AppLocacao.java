package org.ucsal.poo.pf20252.br;
import java.util.Scanner;
public class AppLocacao {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner ler = new Scanner(System.in);
                String nome, cpf;
                int idade;
                System.out.println("\n-- Bem vindo ao sistema de Locação de véiculos UCSAL!");
                System.out.println("\nPrimeiro vamos iniciar seu cadastro... \n Qual seu nome? ");
                nome = ler.nextLine();

                System.out.println("Agora por favor seu cpf");
                cpf = ler.next();
                System.out.println("Por fim me informe qual sua idade");
                idade = ler.nextInt();

                Cliente cliente = new Cliente(nome, cpf, idade);


                Carro carro1 = new Carro("2222", "FordKA", 120.40);
                Carro carro2 = new Carro("DEF-5678", "Toyota Corolla", 220.0);
                Carro carro3 = new Carro("GHI-9012", "Volkswagen Gol", 150.0);

                Moto moto1 = new Moto("JKL-3456", "Honda CG 160", 80.0);
                Moto moto2 = new Moto("MNO-7890", "Yamaha Fazer 250", 120.0);
                Moto moto3 = new Moto("PQR-1122", "Honda Biz 125", 60.0);


                Caminhao caminhao1 = new Caminhao("STU-3344", "Volvo FH 540", 500.0);
                Caminhao caminhao2 = new Caminhao("VWX-5566", "Mercedes Actros 2651", 650.0);
                Caminhao caminhao3 = new Caminhao("YZA-7788", "Scania R450", 600.0);

                while (true) {
                    int op, qntdeDia;
                    System.out.println("== MENU ==");
                    System.out.println("Deseja locar qual tipo de veículo? \n 1 - Carro \n 2 - Moto \n 3 - Caminhao \n Se quiser sair digite 4");
                    op = ler.nextInt();
                    switch (op) {
                        case 1:
                            System.out.println("Quais de Nossos carros deseja locar?");
                            System.out.println("1 - Modelo: " + carro1.getModelo() + " | Valor de diária de: R$" + carro1.getValorDiaria());
                            System.out.println("2 - Modelo: " + carro2.getModelo() + " | Valor de diária de: R$" + carro2.getValorDiaria());
                            System.out.println("3 - Modelo: " + carro3.getModelo() + " | Valor de diária de: R$" + carro3.getValorDiaria());
                            op = ler.nextInt();
                            System.out.println("Quantos dias pretende locar?");
                            qntdeDia = ler.nextInt();
                            if (qntdeDia <= 0) {
                                throw new RuntimeException("A quantidade de dias para locação não podem ser inferiores a 0!!");
                            }
                            switch (op) {
                                case 1:
                                    Locacao locacao = new Locacao(cliente, carro1, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao.iniciarLocacao();
                                    locacao.finalizarLocacao();
                                    continue;
                                case 2:
                                    Locacao locacao2 = new Locacao(cliente, carro2, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao2.iniciarLocacao();
                                    locacao2.finalizarLocacao();
                                    continue;
                                case 3:
                                    Locacao locacao3 = new Locacao(cliente, carro3, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao3.iniciarLocacao();
                                    locacao3.finalizarLocacao();
                                    continue;
                                default:
                                    System.out.println("A opção escolhida para o modelo está fora do escopo!");
                                    continue;
                            }
                        case 2:
                            System.out.println("Quais de Nossas Motos deseja locar?");
                            System.out.println("1 - Modelo: " + moto1.getModelo() + " | Valor de diária de: R$" + moto1.getValorDiaria());
                            System.out.println("2 - Modelo: " + moto2.getModelo() + " | Valor de diária de: R$" + moto2.getValorDiaria());
                            System.out.println("3 - Modelo: " + moto3.getModelo() + " | Valor de diária de: R$" + moto3.getValorDiaria());
                            op = ler.nextInt();
                            System.out.println("Quantos dias pretende locar?");

                            qntdeDia = ler.nextInt();
                            if (qntdeDia <= 0) {
                                throw new RuntimeException("A quantidade de dias para locação não podem ser inferiores a 0!!");
                            }
                            switch (op) {
                                case 1:
                                    Locacao locacao = new Locacao(cliente, moto1, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao.iniciarLocacao();
                                    locacao.finalizarLocacao();
                                    continue;
                                case 2:
                                    Locacao locacao2 = new Locacao(cliente, moto2, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao2.iniciarLocacao();
                                    locacao2.finalizarLocacao();
                                    continue;
                                case 3:
                                    Locacao locacao3 = new Locacao(cliente, moto3, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao3.iniciarLocacao();
                                    locacao3.finalizarLocacao();
                                    continue;
                                default:
                                    System.out.println("A opção escolhida para o modelo está fora do escopo!");
                                    continue;
                            }
                        case 3:
                            System.out.println("Quais de Nossos caminhões desejam locar?");
                            System.out.println("1 - Modelo: " + caminhao1.getModelo() + " | Valor de diária de: R$" + caminhao1.getValorDiaria());
                            System.out.println("2 - Modelo: " + caminhao2.getModelo() + " | Valor de diária de: R$" + caminhao2.getValorDiaria());
                            System.out.println("3 - Modelo: " + caminhao3.getModelo() + " | Valor de diária de: R$" + caminhao3.getValorDiaria());
                            op = ler.nextInt();
                            System.out.println("Quantos dias pretende locar?");
                            qntdeDia = ler.nextInt();
                            if (qntdeDia < 1) {
                                throw new RuntimeException("A quantidade de dias para locação não podem ser inferiores a 1!!");
                            }
                            switch (op) {
                                case 1:
                                    Locacao locacao = new Locacao(cliente, caminhao1, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao.iniciarLocacao();
                                    locacao.finalizarLocacao();
                                    continue;
                                case 2:
                                    Locacao locacao2 = new Locacao(cliente, caminhao2, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao2.iniciarLocacao();
                                    locacao2.finalizarLocacao();
                                    continue;
                                case 3:
                                    Locacao locacao3 = new Locacao(cliente, caminhao3, "14/11/2025", "30/11/2025", qntdeDia);
                                    locacao3.iniciarLocacao();
                                    locacao3.finalizarLocacao();
                                    continue;
                                default:
                                    System.out.println("A opção escolhida para o modelo está fora do escopo!");
                                    continue;
                            }
                        case 4:
                            System.out.println("Saindo..");
                            break;
                        default:
                            System.out.println("Fora do escopo informe outro");
                            continue;

                    }
                    break;
                }
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


