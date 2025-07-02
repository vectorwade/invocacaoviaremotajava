package servidor;

import comum.Calculadora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    
    public CalculadoraImpl() throws RemoteException {
        super();
        System.out.println("[" + LocalDateTime.now().format(formatter) + "] CalculadoraImpl inicializada");
    }
    
    @Override
    public double somar(double a, double b) throws RemoteException {
        double resultado = a + b;
        System.out.println("[" + LocalDateTime.now().format(formatter) + "] Cliente solicitou: " + a + " + " + b + " = " + resultado);
        return resultado;
    }
    
    @Override
    public double subtrair(double a, double b) throws RemoteException {
        double resultado = a - b;
        System.out.println("[" + LocalDateTime.now().format(formatter) + "] Cliente solicitou: " + a + " - " + b + " = " + resultado);
        return resultado;
    }
    
    @Override
    public double multiplicar(double a, double b) throws RemoteException {
        double resultado = a * b;
        System.out.println("[" + LocalDateTime.now().format(formatter) + "] Cliente solicitou: " + a + " * " + b + " = " + resultado);
        return resultado;
    }
    
    @Override
    public double dividir(double a, double b) throws RemoteException, ArithmeticException {
        if (b == 0) {
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Cliente tentou dividir por zero: " + a + " / " + b);
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        double resultado = a / b;
        System.out.println("[" + LocalDateTime.now().format(formatter) + "] Cliente solicitou: " + a + " / " + b + " = " + resultado);
        return resultado;
    }
}
