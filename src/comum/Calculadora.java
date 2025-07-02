package comum;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota para operações de calculadora
 * Define os métodos que podem ser invocados remotamente via RMI
 */
public interface Calculadora extends Remote {
    
    /**
     * Realiza a soma de dois números
     * @param a primeiro operando
     * @param b segundo operando
     * @return resultado da soma
     * @throws RemoteException em caso de erro na comunicação remota
     */
    double somar(double a, double b) throws RemoteException;
    
    /**
     * Realiza a subtração de dois números
     * @param a primeiro operando (minuendo)
     * @param b segundo operando (subtraendo)
     * @return resultado da subtração
     * @throws RemoteException em caso de erro na comunicação remota
     */
    double subtrair(double a, double b) throws RemoteException;
    
    /**
     * Realiza a multiplicação de dois números
     * @param a primeiro operando
     * @param b segundo operando
     * @return resultado da multiplicação
     * @throws RemoteException em caso de erro na comunicação remota
     */
    double multiplicar(double a, double b) throws RemoteException;
    
    /**
     * Realiza a divisão de dois números
     * @param a primeiro operando (dividendo)
     * @param b segundo operando (divisor)
     * @return resultado da divisão
     * @throws RemoteException em caso de erro na comunicação remota
     * @throws ArithmeticException se o divisor for zero
     */
    double dividir(double a, double b) throws RemoteException, ArithmeticException;
}
