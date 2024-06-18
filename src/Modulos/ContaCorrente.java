package Modulos;

public class ContaCorrente extends Conta{
    private double limiteChequeEspecial;

    public ContaCorrente(int numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
        this.limiteChequeEspecial = 500;
    }

    public double usarChequeEspecial() {
        return limiteChequeEspecial;
    }
}
