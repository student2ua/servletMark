Servlet 3.0 / EL 2.2 / jsf 2.2 capable container such as Tomcat 7, Glassfish 3, JBoss AS 6 not need to use  javax.faces.model.DataModel

----------------
http://192.168.0.124:8081/mark/
----------------
[SlickGrid](https://github.com/6pac/SlickGrid/blob/master/examples/example-column-group.html)
[handsontable](https://handsontable.com/docs/7.1.1/demo-header-tooltips.html)
----------------
issues:
[html 5 placeholder] (https://stackoverflow.com/questions/40865120/eclipse-cant-find-jsf-2-2-taglibs)
[access jaas ?] (https://github.com/sixthpoint/JAAS-login-module) add user:159753  rolename="TEACHER_MARK"
----------------
<transport-guarantee> — содержит указание уровня защиты передачи данных между клиентом и сервером; допустимые значения:
NONE — значение по-умолчанию — никаких ограничений;
INTEGRAL — данные должны передаваться способом, который гарантирует, что они не могут быть изменены в процессе передачи, например — с использованием контрольных сумм;
**CONFIDENTIAL** — данные должны передаваться способом, который гарантирует, что они не могут быть рассмотрены и/или изменены в процессе передачи (например — SSL);
