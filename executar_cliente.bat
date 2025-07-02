@echo off
echo Iniciando Cliente de Calculadora RMI...
echo.

REM Verificar se os arquivos foram compilados
if not exist "build\cliente\ClienteCalculadora.class" (
    echo ✗ Arquivos não compilados! Execute compilar.bat primeiro.
    pause
    exit /b 1
)

echo Conectando ao servidor RMI...
echo.

REM Executar o cliente
cd build
java cliente.ClienteCalculadora

pause
