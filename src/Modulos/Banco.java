package Modulos;

import java.util.*;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente, int numeroConta) {
        this.contas.add(new ContaCorrente(numeroConta, 0.0, cliente));
    }

    public void criarContaPoupanca(Cliente cliente, int numeroConta) {
        this.contas.add(new ContaPoupanca(numeroConta, 0.0, cliente));
    }

    public Optional<Conta> obterConta(int numeroConta) {
        return this.contas.stream()
                .filter(conta -> conta.getNumero() == numeroConta)
                .findAny();
    }

    public void depositar(int numeroConta, double valor) {
        var conta = this.obterConta(numeroConta);
        if (conta.isPresent()) {
            conta.get().depositar(valor);
        }
        else {
            System.out.println("Conta não encontrada");
        }
    }

    public void sacar(int numeroConta, double valor) {
        var conta = this.obterConta(numeroConta);
        if (conta.isPresent()) {
            try {
                conta.get().sacar(valor);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Conta não encontrada");
        }
    }

    public void transferir(int numeroContaRemetente, int numeroContaDestinatario, double valor) {
        var contaRemetente = this.obterConta(numeroContaRemetente);
        var contaDestinatario = this.obterConta(numeroContaDestinatario);
        if (contaRemetente.isPresent()) {
           if (contaDestinatario.isPresent()) {
               try {
                contaRemetente.get().transferir(contaDestinatario.get(), valor);
               }
               catch (Exception e) {
                   System.out.println(e.getMessage());
               }
           }
           else {
               System.out.println("Conta destinatária não encontrada");
           }
        }
        else {
            System.out.println("Conta remetente não encontrada");
        }
    }

    public void consultarSaldo(int numeroConta) {
        var conta = this.obterConta(numeroConta);
        if (conta.isPresent()) {
            try {
                System.out.printf("Conta: %d%nSaldo: R$%.2f%n", conta.get().getNumero(), conta.get().consultarSaldo());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Conta não encontrada");
        }
    }
}
