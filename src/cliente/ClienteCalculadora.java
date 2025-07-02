package cliente;

import comum.Calculadora;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ClienteCalculadora {
    
    private static final String NOME_SERVICO = "CalculadoraService";
    private static final int PORTA_RMI = 1099;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Digite o IP do servidor (ou 'localhost' para local): ");
            String ipServidor = scanner.nextLine().trim();
            if (ipServidor.isEmpty()) {
                ipServidor = "localhost";
            }
            
          
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Conectando ao servidor RMI em " + ipServidor + ":" + PORTA_RMI);
            Registry registry = LocateRegistry.getRegistry(ipServidor, PORTA_RMI);
            
            
            Calculadora calculadora = (Calculadora) registry.lookup(NOME_SERVICO);
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Conectado com sucesso ao serviço " + NOME_SERVICO);
            
            
            exibirMenu();
            
            while (true) {
                System.out.print("\nDigite a operação desejada: ");
                String operacao = scanner.nextLine().trim().toLowerCase();
                
                if (operacao.equals("sair")) {
                    System.out.println("[" + LocalDateTime.now().format(formatter) + "] Encerrando cliente...");
                    break;
                }
                
                if (operacao.equals("menu")) {
                    exibirMenu();
                    continue;
                }
                
             
                if (isOperacaoValida(operacao)) {
                    processarOperacao(calculadora, operacao, scanner);
                } else {
                    System.out.println("Operação inválida! Digite 'menu' para ver as opções disponíveis.");
                }
            }
            
        } catch (Exception e) {
            System.err.println("[" + LocalDateTime.now().format(formatter) + "] Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    
    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("     CALCULADORA DISTRIBUÍDA RMI");
        System.out.println("=".repeat(50));
        System.out.println("Operações disponíveis:");
        System.out.println("  soma      - Adição de dois números");
        System.out.println("  subtracao - Subtração de dois números");
        System.out.println("  multiplicacao - Multiplicação de dois números");
        System.out.println("  divisao   - Divisão de dois números");
        System.out.println("  menu      - Exibir este menu novamente");
        System.out.println("  sair      - Encerrar o programa");
        System.out.println("=".repeat(50));
    }
    
   
    private static boolean isOperacaoValida(String operacao) {
        return operacao.equals("soma") || operacao.equals("subtracao") || 
               operacao.equals("multiplicacao") || operacao.equals("divisao");
    }
    
    
    private static void processarOperacao(Calculadora calculadora, String operacao, Scanner scanner) {
        try {
           
            System.out.print("Digite o primeiro número: ");
            double a = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Digite o segundo número: ");
            double b = Double.parseDouble(scanner.nextLine());
            
            
            double resultado = 0;
            String simbolo = "";
            
            switch (operacao) {
                case "soma":
                    resultado = calculadora.somar(a, b);
                    simbolo = "+";
                    break;
                case "subtracao":
                    resultado = calculadora.subtrair(a, b);
                    simbolo = "-";
                    break;
                case "multiplicacao":
                    resultado = calculadora.multiplicar(a, b);
                    simbolo = "*";
                    break;
                case "divisao":
                    resultado = calculadora.dividir(a, b);
                    simbolo = "/";
                    break;
            }
            
          
            System.out.println("\n" + "-".repeat(30));
            System.out.println("Resultado: " + a + " " + simbolo + " " + b + " = " + resultado);
            System.out.println("-".repeat(30));
            
        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, digite números válidos.");
        } catch (ArithmeticException e) {
            System.out.println("Erro matemático: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro na comunicação com o servidor: " + e.getMessage());
        }
    }
}
