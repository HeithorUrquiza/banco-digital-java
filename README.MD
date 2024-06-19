# 📝 Projeto Banco Digital - Documentação 
## 📌 Visão Geral
Este projeto simula operações bancárias básicas, incluindo criação de contas, depósitos, saques, transferências e consulta de saldo. Ele foi desenvolvido em Java e utiliza conceitos de Programação Orientada a Objetos (POO).

---

## 📌 Estrutura do Projeto
O projeto está organizado em pacotes e contém as seguintes classes principais:

`Banco`<br>
``Cliente``<br>
``Conta``<br>
``ContaCorrente``<br>
``ContaPoupanca``<br>
``IConta``<br>

---

## 📌 Classes e Seus Papéis
### Banco 
Representa um banco e gerencia várias contas bancárias.

#### Atributos
- ``nome``: Nome do banco.
- ``contas``: Lista de contas associadas ao banco.

#### Métodos
- ``Banco(String nome)``: Construtor que inicializa o banco com um nome e uma lista vazia de contas.
- ``void adicionarCliente(Cliente cliente, int numeroConta)``: Adiciona uma nova conta corrente para o cliente.
- ``void criarContaPoupanca(Cliente cliente, int numeroConta)``: Cria uma nova conta poupança para o cliente.
- ``Optional<Conta> obterConta(int numeroConta)``: Retorna a conta com o número especificado.
- ``void depositar(int numeroConta, double valor)``: Deposita um valor na conta especificada.
- ``void sacar(int numeroConta, double valor)``: Saca um valor da conta especificada.
- ``void transferir(int numeroContaRemetente, int numeroContaDestinatario, double valor)``: Transfere um valor de uma conta para outra.
- ``void consultarSaldo(int numeroConta)``: Consulta o saldo da conta especificada.

<br>

### Cliente
Representa um cliente do banco.

#### Atributos
- ``nome``: Nome do cliente.
- ``cpf``: CPF do cliente.
- ``endereco``: Endereço do cliente.

#### Métodos
- ``Cliente(String nome, String cpf, String endereco)``: Construtor que inicializa o cliente com nome, CPF e endereço.
- ``String getNome()``: Retorna o nome do cliente.
- `` String getCpf()``: Retorna o CPF do cliente.
- ``String getEndereco()``: Retorna o endereço do cliente.

<br>

### Conta
Classe abstrata que representa uma conta bancária.

#### Atributos
- ``numero``: Número da conta.
- ``saldo``: Saldo da conta.
- ``cliente``: Cliente associado à conta.

#### Métodos
- ``Conta(int numero, double saldo, Cliente cliente)``: Construtor que inicializa a conta com número, saldo e cliente.
- ``int getNumero()``: Retorna o número da conta.
- ``double getSaldo()``: Retorna o saldo da conta.
- ``void setSaldo(double saldo)``: Define o saldo da conta.
- ``Cliente getCliente()``: Retorna o cliente associado à conta.
- ``void depositar(double valor)``: Deposita um valor na conta.
- ``void sacar(double valor) throws Exception``: Saca um valor da conta, se o saldo for suficiente.
- ``void transferir(Conta conta, double valor) throws Exception``: Transfere um valor para outra conta, se o saldo for suficiente.
- ``double consultarSaldo()``: Consulta o saldo da conta.

<br>

### ContaCorrente
Representa uma conta corrente.

#### Atributos
- ``limiteChequeEspecial``: Limite do cheque especial.

#### Métodos
- ``ContaCorrente(int numero, double saldo, Cliente cliente)``: Construtor que inicializa a conta corrente com número, saldo, cliente e limite de cheque especial.
- ``double usarChequeEspecial()``: Retorna o limite do cheque especial.

<br>

### ContaPoupanca
Representa uma conta poupança.

#### Atributos
- ``rendimentoMensal``: Taxa de rendimento mensal.
- ``dataDeposito``: Data do último depósito.

#### Métodos
- ``ContaPoupanca(int numero, double saldo, Cliente cliente)``: Construtor que inicializa a conta poupança com número, saldo, cliente e rendimento mensal.
- ``void depositar(double valor)``: Deposita um valor na conta e define a data do depósito.
- ``double calcularRendimento(int meses)``: Calcula o rendimento da conta após um certo número de meses.
- ``void somarRendimento()``: Adiciona o rendimento mensal ao saldo da conta se um mês tiver passado desde o último depósito.

<br>

### IConta
Interface que define operações básicas de uma conta bancária.

#### Métodos
- ``void depositar(double valor)``: Deposita um valor na conta.
- ``void sacar(double valor) throws Exception``: Saca um valor da conta.
- ``void transferir(Conta conta, double valor) throws Exception``: Transfere um valor para outra conta.
- ``double consultarSaldo()``: Consulta o saldo da conta.

---

## 📌 Como Executar

### Criação do Banco:

``` java
Banco banco = new Banco("Meu Banco");
```

### Criação de Clientes:

```java
Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "Rua A, 123");
Cliente cliente2 = new Cliente("Maria Oliveira", "987.654.321-00", "Avenida B, 456");
```

### Adição de Contas:

```java
banco.adicionarCliente(cliente1, 1001); // Conta Corrente
banco.criarContaPoupanca(cliente2, 1002); // Conta Poupança
```

### Operações Bancárias:

- **Depósito**:
```java
banco.depositar(1001, 500.0);
```

- **Saque**:
```java
banco.sacar(1001, 100.0);
```

- **Transferência**:
```java
banco.transferir(1001, 1002, 50.0);
```

- **Consulta de Saldo**:
```java
banco.consultarSaldo(1001);
```

---

## 📌 Considerações Finais
Este projeto é uma simulação simplificada de operações bancárias. Para aplicações reais, seriam necessárias diversas outras considerações, como segurança, persistência de dados, concorrência e muito mais.