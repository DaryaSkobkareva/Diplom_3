# Diplom_3
Команда для запуска maven в командной строке (пути заменить на актуальные):

CHROME
mvn -Dwebdriver.chrome.driver=src/main/resources/chromedriver118 test

YANDEX
mvn -Dwebdriver.yandex.driver=src/main/resources/chromedriver116 \
-Dwebdriver.yandex.binary=C:/Users/DASHA/AppData/Local/Yandex/YandexBrowser/Application/browser.exe \
-Dbrowser=yandex test