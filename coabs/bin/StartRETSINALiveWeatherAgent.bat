echo off

call setliaisonvars.bat


pushd %LIAISON_CONFIG%\retsina

rem java -cp %RETSINA_LIB%\Infoagent.jar EDU.cmu.softagents.infoagents.InfoAgent.InfoAgent liveweatherCNN.agent_config
java -cp %RETSINA_LIB%\Infoagent.jar EDU.cmu.softagents.infoagents.InfoAgent.InfoAgent liveweatherCNN.agent_config

popd

