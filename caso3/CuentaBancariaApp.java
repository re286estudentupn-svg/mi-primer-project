import java.util.Scanner;

class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = Math.max(0, saldoInicial);
    }

    public double getSaldo() { return saldo; }
    public String getTitular() { return titular; }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido.");
            return;
        }
        saldo += monto;
        System.out.println("Deposito exitoso. Saldo: " + saldo);
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido.");
            return;
        }
        if (monto > saldo) {
            System.out.println("Fondos insuficientes. Saldo: " + saldo);
            return;
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Saldo: " + saldo);
    }
}

public class CuentaBancariaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Titular: ");
        String titular = sc.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();

        CuentaBancaria cuenta = new CuentaBancaria(titular, saldo);

        int opcion;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Monto: ");
                    cuenta.depositar(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Monto: ");
                    cuenta.retirar(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Saldo actual: " + cuenta.getSaldo());
                    break;
                case 0:
                    System.out.println("Adios.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
