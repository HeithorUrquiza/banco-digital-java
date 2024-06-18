import Modulos.Banco;
import Modulos.Cliente;

public class Main {
    public static void main(String[] args) {
        var cliente = new Cliente("Eduardo", "12345678900", "Vale dos Sonhos - GO");
        var bancoBB = new Banco("Best Bill");

        bancoBB.adicionarCliente(cliente, 12345);
        bancoBB.criarContaPoupanca(cliente, 12346);

        bancoBB.depositar(12345, 300.0);
        bancoBB.sacar(12345, 100.0);
        bancoBB.transferir(12345, 12346, 108.2);
        bancoBB.consultarSaldo(12345);
        bancoBB.consultarSaldo(12346);

        System.out.println("\nTestando falhas\n");
        bancoBB.depositar(12347, 300.0);
        bancoBB.sacar(12347, 100.0);
        bancoBB.sacar(12345, 1000.0);
        bancoBB.transferir(12347, 12346, 108.2);
        bancoBB.transferir(12345, 12347, 108.2);
        bancoBB.transferir(12345, 12346, 400);
        bancoBB.consultarSaldo(12347);
        bancoBB.consultarSaldo(12349);

    }
}
