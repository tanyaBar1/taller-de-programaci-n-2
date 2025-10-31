@echo off
set ROOT=%~dp0
mkdir "%ROOT%src"
mkdir "%ROOT%bin"
mkdir "%ROOT%resources"
mkdir "%ROOT%doc"
mkdir "%ROOT%ejecutable"
mkdir "%ROOT%lib"
if not exist "%ROOT%README.txt" echo (Escribe aqui la descripcion de tu proyecto) > "%ROOT%README.txt"
pause
