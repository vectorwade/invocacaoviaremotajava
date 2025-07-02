@echo off
echo Iniciando Servidor de Calculadora RMI...
echo.

REM Verificar se os arquivos foram compilados
if not exist "build\servidor\ServidorCalculadora.class" (
    echo ✗ Arquivos não compilados! Execute compilar.bat primeiro.
    pause
    exit /b 1
)

echo Executando servidor na porta 1099...
echo Para parar o servidor, pressione Ctrl+C
echo.

REM Executar o servidor
cd build
java servidor.ServidorCalculadora
