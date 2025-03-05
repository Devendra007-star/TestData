@echo off
echo Terminating all ChromeDriver instances...

taskkill /f /im chromedriver.exe

if %ERRORLEVEL% EQU 0 (
    echo Successfully terminated all ChromeDriver instances.
) else (
    echo No ChromeDriver instances were found running.
)

pause
