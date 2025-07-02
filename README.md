# Calculadora Distribuída RMI

Este projeto implementa uma calculadora distribuída em Java usando RMI (Remote Method Invocation), permitindo que clientes remotos executem operações matemáticas em um servidor centralizado.

## 📋 Descrição

O sistema é composto por:
- **Servidor**: Executa as operações matemáticas e mantém o serviço RMI
- **Cliente**: Interface de usuário para solicitar cálculos remotamente
- **Interface Comum**: Define o contrato entre cliente e servidor

## 🎯 Funcionalidades

- ✅ Operações matemáticas básicas (soma, subtração, multiplicação, divisão)
- ✅ Suporte a múltiplos clientes simultâneos
- ✅ Tratamento de erros (divisão por zero, entrada inválida)
- ✅ Logging detalhado com timestamps
- ✅ Interface de usuário intuitiva
- ✅ Comunicação via RMI na porta padrão (1099)

## 🏗️ Estrutura do Projeto

```
trabalho/
├── src/
│   ├── comum/
│   │   └── Calculadora.java           # Interface remota
│   ├── servidor/
│   │   ├── CalculadoraImpl.java       # Implementação das operações
│   │   └── ServidorCalculadora.java   # Servidor RMI principal
│   └── cliente/
│       └── ClienteCalculadora.java    # Aplicação cliente
├── compilar.bat                       # Script de compilação
├── executar_servidor.bat             # Script para executar servidor
├── executar_cliente.bat              # Script para executar cliente
└── README.md                         # Este arquivo
```

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- Sistema Windows (ou adaptar scripts para Linux/Mac)

### Passo 1: Compilação
Execute o script de compilação:
```cmd
compilar.bat
```

### Passo 2: Executar o Servidor
Em um terminal, execute:
```cmd
executar_servidor.bat
```

O servidor será iniciado e ficará aguardando conexões na porta 1099.

### Passo 3: Executar o Cliente
Em outro terminal, execute:
```cmd
executar_cliente.bat
```

### Passo 4: Usar a Calculadora
1. Digite o IP do servidor (ou `localhost` para uso local)
2. Escolha uma operação: `soma`, `subtracao`, `multiplicacao`, `divisao`
3. Digite os dois números quando solicitado
4. Veja o resultado calculado pelo servidor
5. Digite `sair` para encerrar o cliente

## 💻 Exemplo de Uso

```
Digite o IP do servidor (ou 'localhost' para local): localhost
[2025-06-30 19:30:15] Conectando ao servidor RMI em localhost:1099
[2025-06-30 19:30:15] Conectado com sucesso ao serviço CalculadoraService

==================================================
     CALCULADORA DISTRIBUÍDA RMI
==================================================
Operações disponíveis:
  soma      - Adição de dois números
  subtracao - Subtração de dois números
  multiplicacao - Multiplicação de dois números
  divisao   - Divisão de dois números
  menu      - Exibir este menu novamente
  sair      - Encerrar o programa
==================================================

Digite a operação desejada: soma
Digite o primeiro número: 15
Digite o segundo número: 25

------------------------------
Resultado: 15.0 + 25.0 = 40.0
------------------------------
```

## 🔧 Compilação Manual (Alternativa)

Se preferir compilar manualmente:

```cmd
# Criar diretório build
mkdir build

# Compilar arquivos
javac -d build src\comum\*.java src\servidor\*.java src\cliente\*.java

# Executar servidor
cd build
java servidor.ServidorCalculadora

# Executar cliente (em outro terminal)
cd build
java cliente.ClienteCalculadora
```

## 🌐 Uso em Rede

Para usar em computadores diferentes:

1. **No servidor**: Execute `executar_servidor.bat`
2. **No cliente**: Digite o IP real do servidor quando solicitado
3. **Firewall**: Certifique-se de que a porta 1099 está liberada

## 🛠️ Características Técnicas

- **Protocolo**: Java RMI
- **Porta**: 1099 (padrão RMI Registry)
- **Nome do Serviço**: "CalculadoraService"
- **Arquitetura**: Cliente-Servidor distribuído
- **Concorrência**: Suporte a múltiplos clientes simultâneos
- **Tratamento de Erros**: Exceções específicas para cada tipo de erro

## 📝 Logs do Servidor

O servidor gera logs detalhados das operações:

```
[2025-06-30 19:30:10] Iniciando servidor de calculadora RMI...
[2025-06-30 19:30:10] CalculadoraImpl inicializada
[2025-06-30 19:30:10] Registro RMI criado na porta 1099
[2025-06-30 19:30:10] Serviço 'CalculadoraService' registrado no RMI
[2025-06-30 19:30:10] Servidor está pronto e aguardando conexões...
[2025-06-30 19:30:25] Cliente solicitou: 15.0 + 25.0 = 40.0
```

## 🤝 Contribuição

Este é um projeto acadêmico para demonstrar conceitos de sistemas distribuídos usando Java RMI.

## 📄 Licença

Projeto desenvolvido para fins educacionais.
