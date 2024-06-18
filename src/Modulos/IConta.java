package Modulos;

public interface IConta {
    void depositar(double valor);
    void sacar(double valor) throws Exception;
    void transferir(Conta conta, double valor) throws Exception;
    double consultarSaldo();
}
