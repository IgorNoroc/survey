<h2>Rest Api для опроса пользователей!</h2></br>
При создании приложения использованы технологии:</br>
<ul>
<li>Spring(Boot, Data, Security, SpringFox, Web)</li>
<li>Swagger2</li>
<li>VCS Git</li>
<li>Java 14</li>
<li>Apache Maven</li>
<li>PostgreSQL</li>
<li>Hibernate</li>
<li>Lombok</li>
</ul>

Для запуска проекта нужно иметь на локальном компютере:</br>
jdk(выше 8 версии), базу данных PostgreSql, среда разработки(любая что поддерживает работу с Spring-Framework).</br></br>
Клонируем проект в среду разработки, после, в <b><i>application.properties</i></b></br>
не забываем задать свои имя и пароль для базы данных:</br>
<i>spring.datasource.username=ваше имя пользователя PostgreSql, </br>
spring.datasource.password=ваш пароль для базы данных.</i></br>
Предварительно нужно создать базу данных : <i>survey_database</i>. </br></br>
<b>Внимание!</b>
после запуска программы, нужно выполнить скрипт data.sql так как сервис не умеет создавать админа и его роли.</br>
<b>Более подробная документция будет доступна после запуска по : http://localhost:8080/swagger-ui.html </b></br>


![Image alt]((https://github.com/IgorNoroc/survey/blob/master/src/main/resources/img/rest-docs.png))


