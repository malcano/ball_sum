#!/bin/bash
if [ $# -ne 1 ]
then
    echo "Usage: ./runTest.sh [TargetClassName]"
    echo "e.g., ./runTest.sh Ball"
    exit
fi

if [[ "$OSTYPE" == "linux-gnu"* || "$OSTYPE" == "darwin"* ]]; then 
    echo "Linux or MacOS"
    CLASSPATH="target:lib/solution.jar:lib/tester.jar"
elif [[ "$OSTYPE" == "cygwin" || "$OSTYPE" == "msys" ]];then
    echo "Windows"
    CLASSPATH="target;lib/solution.jar;lib/tester.jar"
fi

java -XX:MaxJavaStackTraceDepth=1 -jar lib/junit-platform-console-standalone-1.9.0.jar -class-path $CLASSPATH \
--select-class "test.$1Test" --disable-banner --details=tree --details-theme=ascii