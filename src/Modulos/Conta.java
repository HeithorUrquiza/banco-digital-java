package Modulos;

abstract class Conta implements IConta{
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    // Retorna informacoes da conta
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Abstrai as funcoes basicas de uma conta bancaria
    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public void sacar(double valor) throws Exception {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
        }
        else {
            throw new Exception("Saldo insuficiente");
        }
    }

    @Override
    public void transferir(Conta conta, double valor) throws Exception {
        if (this.getSaldo() >= valor) {
            conta.depositar(valor);
            this.setSaldo(this.getSaldo() - valor);
        }
        else {
            throw new Exception("Saldo insuficiente");
        }

    }

    @Override
    public double consultarSaldo() {
        return this.getSaldo();
    }
}
