# Makefile para Calculadora RMI
# Para sistemas Linux/Mac

SRCDIR = src
BUILDDIR = build
JAVAFILES = $(shell find $(SRCDIR) -name "*.java")

# Compilar o projeto
compile:
	@echo "Compilando projeto Calculadora RMI..."
	@mkdir -p $(BUILDDIR)
	javac -d $(BUILDDIR) $(JAVAFILES)
	@echo "✓ Compilação concluída!"

# Executar servidor
servidor: compile
	@echo "Iniciando servidor RMI..."
	cd $(BUILDDIR) && java servidor.ServidorCalculadora

# Executar cliente
cliente: compile
	@echo "Iniciando cliente RMI..."
	cd $(BUILDDIR) && java cliente.ClienteCalculadora

# Limpar arquivos compilados
clean:
	@echo "Limpando arquivos compilados..."
	rm -rf $(BUILDDIR)
	@echo "✓ Limpeza concluída!"

# Ajuda
help:
	@echo "Comandos disponíveis:"
	@echo "  make compile  - Compila o projeto"
	@echo "  make servidor - Executa o servidor"
	@echo "  make cliente  - Executa o cliente"
	@echo "  make clean    - Remove arquivos compilados"
	@echo "  make help     - Exibe esta ajuda"

.PHONY: compile servidor cliente clean help
