@echo off
chcp 65001 >nul
echo 🛠️ Compilando archivos Java...

:: Compila todos los archivos .java en la carpeta actual
javac *.java

:: Verifica si hubo errores
if %errorlevel% neq 0 (
    echo ❌ Error de compilación. Revisa los mensajes arriba.
) else (
    echo ✅ Compilación exitosa.
    echo 🏃 Ejecutando programa...
    java Main
)

pause