@echo off
setlocal EnableDelayedExpansion
SET WinAppDriver_EXEFILE=C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe
SET MOSAIQ_INSTALL_PATH=C:\MOSAIQ\2022.10\2022.10.032\IMPAC\MOSAIQ_APP
if exist %WinAppDriver_EXEFILE%
	echo 'found WinAppDriver exe file'
copy WinAppDriver_EXEFILE  MOSAIQ_INSTALL_PATH