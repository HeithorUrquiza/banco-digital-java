package Modulos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta{
    private double rendimentoMensal;
    private LocalDate dataDeposito;

    public ContaPoupanca(int numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
        this.rendimentoMensal = 0.7;
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
        // Comeca a contar os dias após o saldo
        dataDeposito = LocalDate.now();
    }

    public double calcularRendimento(int meses) {
        return this.getSaldo() + (this.getSaldo() * this.rendimentoMensal * meses);
    }

    public void somarRendimento() {
        var dias = ChronoUnit.DAYS.between(LocalDate.now(), dataDeposito);
        if (this.getSaldo() > 0) {
            if (dias == 30) {
                this.setSaldo(this.getSaldo() + (this.getSaldo() * this.rendimentoMensal));
            }
        }
    }
}
