package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ServidorCalculadora {
    
    private static final int PORTA_RMI = 1099;
    private static final String NOME_SERVICO = "CalculadoraService";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String[] args) {
        try {
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Iniciando servidor de calculadora RMI...");
            
            
            CalculadoraImpl calculadora = new CalculadoraImpl();
            
          
            Registry registry = LocateRegistry.createRegistry(PORTA_RMI);
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Registro RMI criado na porta " + PORTA_RMI);
            
            
            registry.rebind(NOME_SERVICO, calculadora);
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Serviço '" + NOME_SERVICO + "' registrado no RMI");
            
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Servidor está pronto e aguardando conexões...");
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Para conectar use: rmi://localhost:" + PORTA_RMI + "/" + NOME_SERVICO);
            System.out.println("[" + LocalDateTime.now().format(formatter) + "] Pressione Ctrl+C para parar o servidor");
            
           
            while (true) {
                Thread.sleep(1000);
            }
            
        } catch (Exception e) {
            System.err.println("[" + LocalDateTime.now().format(formatter) + "] Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
