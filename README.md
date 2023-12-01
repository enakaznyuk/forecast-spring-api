# forecast-spring-api

# Описание:
1) Приложение подключается к https://rapidapi.com/weatherapi/api/weatherapi-com через класс AsyncService.

2) Данные преобразуются и сохраняются в базу данных в классе AsyncController.
Метод fillingTheDatabase обращается к API раз в сутки благодаря аннотации @Scheduled(cron = "@daily").
3) Для обращения к базе данных предусмотрен класс ForecastController.
   http://localhost:8080/demo/forecast — для того чтобы получить все данные из БД.
   http://localhost:8080/demo/forecast/current — для того чтобы получить наиболее акутальную погоду.
   
   http://localhost:8080/demo/forecast/avg?localDateStart=?&localDateFinish=? — для получения средних значений погоды за промежуток дат от до.
4) В конфигурационном файле application.properties описывается подключение к Бд и логгирование
5) Лог-файл myapplication.log содержит журнал работы приложения

# Запуск приложения:
Запускается приложение через метод main в классе DemoApplication



# Description:
1) The application connects to https://rapidapi.com/weatherapi/api/weatherapi-com via the AsyncService class.

2) Data is converted and saved to a database in the AsyncController class.
   The fillingTheDatabase method accesses the API once a day thanks to the @Scheduled(cron = "@daily") annotation.
3) The ForecastController class is provided to access the database.
   http://localhost:8080/demo/forecast - to get all data from the database.
   http://localhost:8080/demo/forecast/current - to get the most actual weather.

   http://localhost:8080/demo/forecast/avg?localDateStart=?&localDateFinish=? - to get the average weather values for the date interval from to.
4) The configuration file application.properties describes the connection to the database and logging.
5) The log file myapplication.log contains the log of the application's operation

# Starting the application:
The application is started via the main method in the DemoApplication class
