call runcrud.bat
if "%ERRORLEVEL%" == "0" goto chrome

:chrome
echo.
echo Starting Chrome Browser....
start "C:\Program Files\Google\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks