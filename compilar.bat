@echo off
echo Compilando projeto Calculadora RMI...
echo.

REM Criar diretório para arquivos compilados
if not exist "build" mkdir build

REM Compilar todos os arquivos Java
echo Compilando arquivos fonte...
javac -d build src\comum\*.java src\servidor\*.java src\cliente\*.java

if %ERRORLEVEL% == 0 (
    echo.
    echo ✓ Compilação concluída com sucesso!
    echo   Arquivos compilados salvos em: build\
    echo.
    echo Para executar:
    echo   1. Servidor: executar_servidor.bat
    echo   2. Cliente:  executar_cliente.bat
) else (
    echo.
    echo ✗ Erro na compilação!
)

pause
