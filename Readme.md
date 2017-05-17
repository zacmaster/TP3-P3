Programación III - Universidad Nacional de General Sarmiento
Trabajo Práctico 3: Al SUM de la biblioteca
El objetivo del trabajo práctico es implementar una aplicación para asignar automáticamente
aulas a materias en una universidad, con el objetivo de respetar restricciones de horarios.
Se tiene un listado de materias que se van a dictar en un día de la semana, incluyendo para
cada materia su nombre, código, hora de inicio y hora de finalización. Suponemos que las
horas de inicio y finalización son números enteros. Este listado de materias se debe leer desde
un archivo con formato JSON o XML, a criterio del grupo. La aplicación implementada debe
preguntar el nombre del archivo, leer los datos del archivo, y presentar al usuario en una
tabla una asignación factible de aulas a materias, informando la cantidad de aulas totales
necesarias para la asignación.
No es necesario identificar las aulas ni tener un listado de aulas previamente cargado, sino
que se pueden indicar las aulas como “Aula 1”, “Aula 2”, etc. Se puede suponer que tenemos
disponible una cantidad arbitrariamente grande de aulas disponibles. Para resolver el problema
de asignación de aulas, se debe implementar un algoritmo goloso. La única restricción
que se debe respetar es que no se pueden asignar a una misma aula dos materias con horarios
que se superponen.
Como objetivos opcionales no obligatorios, se pueden contemplar los siguientes elementos:
1. Mostrar un calendario por aula, que especifique qué materia tiene asignada en cada
hora (o bien que está libre en ese horario).
2. Mostrar estadísticas de la resolución, como por ejemplo cantidad promedio de horas
utilizadas por aula, cantidad de materias promedio asignadas por aula, cantidad de
aulas con menos de 5 horas asignadas en el día, etc.
3. Permitir que el usuario realice cambios manuales en la asignación de aulas, informando
si esos cambios generan conflictos por superposiciones horarias.
Condiciones de entrega: El trabajo práctico se debe entregar por mail a los docentes
de la materia. Además del código, se debe incluir un documento en el que se describa la
implementación y se detallen las decisiones tomadas durante el desarrollo. Todas las clases de
la capa de negocio deben incluir un conjunto adecuado de tests unitarios. El trabajo práctico
se puede hacer en grupos de hasta tres personas.
Fecha de entrega: Martes 13 de junio.