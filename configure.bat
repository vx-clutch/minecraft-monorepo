@echo off

set RESET=
set GREEN=[32m
set YELLOW=[33m
set RED=[31m

:exists
echo %YELLOW%===> Checking for %1%RESET%
where %1 >nul 2>&1
if %errorlevel% neq 0 (
    echo %RED%  failure to configure: cannot find %1 in user path.%RESET%
    set action=true
) else (
    echo %GREEN%  found %1%RESET%
)
exit /b

set "depends_on=java gradlew"
set action=false

:: Check dependencies
for %%c in (%depends_on%) do (
    call :exists %%c
)

if "%action%"=="true" (
    echo %RED%Some checks failed.%RESET% Install the needed binaries before continuing to compilation.
) else (
    echo %GREEN%All checks pass!%RESET% You can now run 'make' to compile the project.
)
