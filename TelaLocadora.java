package org.ucsal.poo.pf20252.br;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaLocadora extends JFrame {

    // Componentes da tela
    private JTextField txtNome, txtCpf, txtIdade, txtDias;
    private JComboBox<String> comboTipoVeiculo;
    private JComboBox<String> comboModeloVeiculo;
    private JTextArea areaResultado;

    // Listas de Veículos (Simulando seu banco de dados em memória)
    private List<Carro> carros = new ArrayList<>();
    private List<Moto> motos = new ArrayList<>();
    private List<Caminhao> caminhoes = new ArrayList<>();

    public TelaLocadora() {
        setTitle("Sistema de Locação UCSAL");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        inicializarVeiculos();
        inicializarComponentes();
    }

    private void inicializarVeiculos() {
        carros.add(new Carro("2222", "FordKA", 120.40));
        carros.add(new Carro("DEF-5678", "Toyota Corolla", 220.0));
        carros.add(new Carro("GHI-9012", "Volkswagen Gol", 150.0));

        motos.add(new Moto("JKL-3456", "Honda CG 160", 80.0));
        motos.add(new Moto("MNO-7890", "Yamaha Fazer 250", 120.0));
        motos.add(new Moto("PQR-1122", "Honda Biz 125", 60.0));

        caminhoes.add(new Caminhao("STU-3344", "Volvo FH 540", 500.0));
        caminhoes.add(new Caminhao("VWX-5566", "Mercedes Actros", 650.0));
        caminhoes.add(new Caminhao("YZA-7788", "Scania R450", 600.0));
    }

    private void inicializarComponentes() {
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(80, 20, 300, 25);
        add(txtNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(20, 60, 100, 25);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(80, 60, 150, 25);
        add(txtCpf);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(250, 60, 50, 25);
        add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(300, 60, 80, 25);
        add(txtIdade);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 120, 100, 25);
        add(lblTipo);

        String[] tipos = {"Selecione...", "Carro", "Moto", "Caminhão"};
        comboTipoVeiculo = new JComboBox<>(tipos);
        comboTipoVeiculo.setBounds(80, 120, 150, 25);
        add(comboTipoVeiculo);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(20, 160, 100, 25);
        add(lblModelo);

        comboModeloVeiculo = new JComboBox<>();
        comboModeloVeiculo.setBounds(80, 160, 300, 25);
        add(comboModeloVeiculo);

        comboTipoVeiculo.addActionListener(e -> atualizarModelos());

        JLabel lblDias = new JLabel("Dias:");
        lblDias.setBounds(20, 200, 100, 25);
        add(lblDias);

        txtDias = new JTextField();
        txtDias.setBounds(80, 200, 80, 25);
        add(txtDias);

        JButton btnCalcular = new JButton("Realizar Locação");
        btnCalcular.setBounds(80, 250, 300, 40);
        add(btnCalcular);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setBorder(BorderFactory.createEtchedBorder());

        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBounds(20, 310, 440, 200);
        add(scroll);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLocacao();
            }
        });
    }

    private void atualizarModelos() {
        comboModeloVeiculo.removeAllItems();
        String tipo = (String) comboTipoVeiculo.getSelectedItem();

        if ("Carro".equals(tipo)) {
            for (Carro c : carros) comboModeloVeiculo.addItem(c.getModelo() + " - R$" + c.getValorDiaria());
        } else if ("Moto".equals(tipo)) {
            for (Moto m : motos) comboModeloVeiculo.addItem(m.getModelo() + " - R$" + m.getValorDiaria());
        } else if ("Caminhão".equals(tipo)) {
            for (Caminhao c : caminhoes) comboModeloVeiculo.addItem(c.getModelo() + " - R$" + c.getValorDiaria());
        }
    }

    private void realizarLocacao() {
        try {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            int idade = Integer.parseInt(txtIdade.getText());

            Cliente cliente = new Cliente(nome, cpf, idade);

            int indexSelecionado = comboModeloVeiculo.getSelectedIndex();
            if (indexSelecionado == -1) throw new RuntimeException("Selecione um veículo!");

            String tipo = (String) comboTipoVeiculo.getSelectedItem();
            Veiculo veiculoSelecionado = null;

            if ("Carro".equals(tipo)) veiculoSelecionado = carros.get(indexSelecionado);
            else if ("Moto".equals(tipo)) veiculoSelecionado = motos.get(indexSelecionado);
            else if ("Caminhão".equals(tipo)) veiculoSelecionado = caminhoes.get(indexSelecionado);

            int dias = Integer.parseInt(txtDias.getText());
            if (dias <= 0) {
                throw new RuntimeException("A quantidade de dias para locação não pode ser menor ou igual a 0!");
            }


            Locacao locacao = new Locacao(cliente, veiculoSelecionado, "HOJE", "FUTURO", dias);

            double valor = veiculoSelecionado.calcularValorLocacao(dias);

            areaResultado.setText("=== LOCAÇÃO REALIZADA ===\n");
            areaResultado.append("Cliente: " + nome + "\n");
            areaResultado.append("Veículo: " + veiculoSelecionado.getModelo() + "\n");
            areaResultado.append("Dias: " + dias + "\n");
            areaResultado.append("Valor Total: R$ " + valor + "\n");

            JOptionPane.showMessageDialog(this, "Locação realizada com sucesso!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Verifique se Idade e Dias são números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLocadora().setVisible(true);
        });
    }
}
