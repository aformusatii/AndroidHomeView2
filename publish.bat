call gradlew assembleDebug

scp -o StrictHostKeyChecking=no app\build\outputs\apk\debug\app-debug.apk pi@pithree:/var/www/protected/apps/homeview2-app-debug.apk