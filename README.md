### Задание с собеседования

  1.  В классе **SelenideTest** - UI тесты, запустятся с использованием команды:
``` bash
gradle testGroups -Pgroups=ui
``` 
***Примечание:*** используемый браузер - это контейнер standalone chrome.
 
  2.  В классе **RestTest** - REST тесты, запустятся с использованием команды:
  ``` bash
  gradle testGroups -Pgroups=rest
  ``` 

Для запуска обеих групп ***test, rest*** использовать команду
``` bash
  gradle testGroups -Pgroups=rest,ui
  ``` 