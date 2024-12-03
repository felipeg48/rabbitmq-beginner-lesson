#! /bin/zsh

echo "Starting HTTP Server on 8001 - http://localhost:8001/index.html"
python -m http.server 8001 --directory build/docs/asciidoc > /dev/null 2>&1 &
PID1="$!"

echo "Starting LiveReload Server on 35729"
livereloadx -s ./build/docs/ > /dev/null 2>&1 &
PID2="$!"

echo "Website: HTTP Server PIDs: $PID1 - LiveReload PIDs: $PID2"
echo "Starting Watcher..."
fswatch -o src/ | while read num ; \
do
 reset
 echo "Website: HTTP Server PIDs: $PID1 - LiveReload PIDs: $PID2"
 echo "Converting Docs..."
 ./gradlew clean asciidoctor -b build-html.gradle > /dev/null 2>&1
 ./gradlew clean asciidoctor -b build-revealjs.gradle > /dev/null 2>&1
 echo "Done."
done
