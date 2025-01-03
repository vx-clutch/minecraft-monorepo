@echo off
:: Define colors
set RESET=
set GREEN=[32m
set YELLOW=[33m
set RED=[31m

:: Function to check if a command exists
:exists
echo %YELLOW%===> Checking for %1%RESET%
where %1 >nul 2>nul
if errorlevel 1 (
    echo %RED%  failure to configure: cannot find %1 in user path.%RESET%
    set action=true
) else (
    echo %GREEN%  found %1%RESET%
)
goto :eof

:: Define dependencies
set depends_on=java gradlew
set action=false

:: Loop through dependencies
for %%i in (%depends_on%) do call :exists %%i

:: Check results
if "%action%"=="true" (
    echo %RED%Some checks failed.%RESET% Install the needed binaries before continuing to compilation.
) else (
    echo %GREEN%All checks pass!%RESET% You can now run 'make' to compile the project.
)
