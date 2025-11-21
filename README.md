# 🚗 Sistema de Locadora de Veículos

Um programa em **Java** que simula o funcionamento básico de uma **Locadora de Veículos**, permitindo cadastrar, visualizar e editar informações de carros.  
O sistema foi desenvolvido para **praticar conceitos fundamentais de POO**, como classes, objetos, encapsulamento e métodos, além de auxiliar no planejamento de despesas mensais com locações.

A aplicação funciona totalmente via **terminal**, com um menu interativo.

---

## 💻 Tecnologias utilizadas  

- ☕ **Java** (JDK 8+)

---

## 📜 Funcionalidades  

O programa oferece um menu interativo com opções como:

1. 🚘 **Cadastrar veículo** – cria um novo veículo informando nome/modelo e valor
2. ✏️ **Editar veículo** – altera nome/modelo ou valor do veículo escolhido
3. 🧮 **Calcular gasto mensal** – calcula quanto seria gasto com base no valor do veículo selecionado  
4. ❌ **Sair do sistema**

Cada veículo possui:

- **Nome/Modelo**
- **Valor**
- **Métodos getters e setters**
- **Método de exibição formatada**

Essas operações utilizam **conceitos básicos de POO** sem estruturas avançadas, focando em manipular objetos diretamente.

---

## 🚀 Como executar  

### Pré-requisitos  

- Ter o **Java JDK** instalado  
- Opcional: configurar a variável de ambiente `JAVA_HOME`  

### Passos para execução

```bash
# Clone o repositório
git clone https://github.com/jhonxxz06/ProjetoLocadoraPooFinal.git

# Acesse a pasta do projeto
cd ProjetoLocadoraPooFinal/src

# Compile os arquivos
javac locadora/*.java

# Execute o programa
java locadora.LocadoraApp
