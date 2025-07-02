# Calculadora Distribuída RMI

Este projeto implementa uma calculadora distribuída em Java usando RMI (Remote Method Invocation), permitindo que clientes remotos executem operações matemáticas em um servidor centralizado.

##  Autoria

victor dias carvalho, ifg, campus goiania


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


