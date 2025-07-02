<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

# Calculadora Distribuída RMI - Instruções para o Copilot

Este é um projeto Java que implementa uma calculadora distribuída usando RMI (Remote Method Invocation).

## Estrutura do Projeto

- `src/comum/` - Interface remota compartilhada entre cliente e servidor
- `src/servidor/` - Implementação do servidor RMI
- `src/cliente/` - Aplicação cliente que se conecta remotamente

## Características Técnicas

- **Java RMI**: Comunicação entre sistemas distribuídos
- **Porta padrão**: 1099 (RMI Registry)
- **Nome do serviço**: "CalculadoraService"
- **Operações suportadas**: soma, subtração, multiplicação, divisão
- **Suporte a múltiplos clientes**: Sim, simultaneamente

## Diretrizes de Desenvolvimento

1. Sempre usar `throws RemoteException` em métodos da interface remota
2. Implementar logging detalhado com timestamps
3. Tratar exceções específicas (ex: divisão por zero)
4. Manter interface de usuário amigável no cliente
5. Seguir convenções de nomenclatura Java
6. Documentar métodos com JavaDoc

## Compilação e Execução

- Compilar todos os arquivos .java na raiz do projeto
- Executar primeiro o servidor, depois o(s) cliente(s)
- Servidor deve estar sempre disponível para múltiplas conexões
