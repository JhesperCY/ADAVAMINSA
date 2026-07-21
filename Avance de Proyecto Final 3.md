L 

i 

(= TecnoldgicaUniversidad del Peru 



<!-- Start of picture text -->
|<br><!-- End of picture text -->

Analisis y Diseno de Sistemas de Informacién r) Ys ., yy » J) wie ) INISSISON, SECC. = 18170 LRMORN DRANIIY yy 8 . . ye ,*P, » YD. mE . Set \ EQUIPO NUTT iW " : TONN ¢ ; } CABALLERO YALI, Jhesper } Sa l || . rs a y ly [a i Julio César DD IN “oN > h \ I (i :) | " = OSORESOSCAR GRANDA' < _s=a “aeig a ee l» ENRIQUE m Pog ‘Ss Ege) 



<!-- Start of picture text -->
Z,<br><!-- End of picture text -->

## **ÍNDICE** 

|INTRODUCCIÓN.................................................................................................................6|
|---|
|JUSTIFICACIÓN...................................................................................................................6|
|OBJETIVOS GENERALES Y ESPECIFICOS.............................................................................6|
|<br>OBJETIVO GENERAL...............................................................................................6|
|<br>OBJETIVOS ESPECIFICOS........................................................................................6|
|ASPECTOS DE LA ORGANIZACIÓN......................................................................................7|
|<br>MISIÓN...................................................................................................................7|
|<br>VISIÓN....................................................................................................................7|
|<br>DESCRIPCIÓN DE LA EMPRESA..............................................................................7|
|1.<br>ÁMBITO DEL PROYECTO.............................................................................................7<br><br>|
|1.1.<br>ÁREA..................................................................................................................7|
|1.2.<br>RECURSOS HUMANOS PARA LA ELABORACIÓN DEL PROYECTO.......................8|
|1.3.<br>SOFTWARE.........................................................................................................9|
|1.4.<br>HARDWARE........................................................................................................9|
|1.5.<br>CRONOGRAMA DE ACTIVIDADES....................................................................10|
|2.<br>FASE DE INICIO.........................................................................................................12|
|2.1.<br>MODELADO DEL NEGOCIO..............................................................................12|
|2.1.1.<br>MODELADO DEL PROCESO DE NEGOCIO................................................12|
|2.1.2.<br>MODELO DEL ANALISIS DE NEGOCIO......................................................13|
|2.1.3.<br>RECOPILACION DE REQUERIMIENTOS.....................................................14|
|2.2.<br>MATRIZ DE REQUERIMIENTO..........................................................................15|
|3.<br>FASE DE ELABARACIÓN............................................................................................16|
|3.1.<br>CASOS DE USO.................................................................................................16|
|3.2.<br>ESPECIFICACIONES DEL CASO DE USO.............................................................17<br>|
|3.2.1.<br>CUS-01: Validar acceso al sistema (Login)...............................................17|
|3.2.2.<br>CUS-02: Registrar ingreso de donación médica......................................18|
|3.2.3.<br>CUS-04: Realizar registro masivo de lotes...............................................19|
|3.2.4.<br>CUS-05: Registrar voluntario nuevo........................................................19|
|3.2.5.<br>CUS-06: Buscar voluntarios por especialidad..........................................20|
|3.2.6.<br>CUS-07: Asignar tareas asistenciales.......................................................21|



|3.2.7.<br>CUS-08: Generar reporte de stock para hospitales.................................22|
|---|
|3.3.<br>ANÁLISIS DEL SISTEMA....................................................................................23|
|3.3.1.<br>Paquete de Análisis..................................................................................23|
|3.3.2.<br>Clases de Entdad.....................................................................................23|
|3.3.3.<br>Realizaciones de Caso de Uso..................................................................25|
|3.3.4.<br>Diagrama de comunicación.....................................................................27|
|3.3.5.<br>Diagrama de secuencia............................................................................28|
|3.4.<br>MODELO CONCEPTUAL O DIAGRAMA DE CLASE............................................30|
|3.5.<br>MODELO LÓGICO.............................................................................................31|
|3.6.<br>MODELO FÍSICO...............................................................................................32|
|3.7.<br>TARJETA CRC DE CADA CLASE..........................................................................32|
|1)<br>Tarjeta 01: Clase Medicina...............................................................................32|
|2)<br>Tarjeta 02: Clase Voluntario.............................................................................32|
|3)<br>Tarjeta 03: Clase Donatvo...............................................................................33|
|4)<br>Tarjeta 04: Clase Tarea.....................................................................................33|
|5)<br>Tarjeta 05: Clase Usuario.................................................................................33|
|3.8.<br>DISEÑO DEL SISTEMA......................................................................................34|
|3.8.1.<br>Patrón de diseño......................................................................................34|
|3.8.2.<br>Diagrama de estructura compuesta........................................................35|
|3.8.3.<br>Diagrama de tempo................................................................................36|
|3.8.4.<br>Diagrama de despliegue..........................................................................36|
|3.8.5.<br>Diagrama de componentes.....................................................................36|
|3.9.<br>APLICATIVO......................................................................................................37<br>|
|3.9.1.<br>Pantallazos del Sofware..........................................................................37|
|3.9.2.<br>Descripción de la Implementación..........................................................37|
|3.9.3.<br>Pruebas y Formatos de Validación..........................................................37|
|CONCLUSION...................................................................................................................37|
|RECOMENDACIONES.......................................................................................................37|
|BIBLIOGRAFÍA..................................................................................................................37|



## **_ÍNDICE DE ILUSTRACIÓNES_** 

|_Ilustración 1..................................................................................................................................11_|
|---|
|_Ilustración 2..................................................................................................................................11_|
|_Ilustración 3..................................................................................................................................12_|
|_Ilustración 4..................................................................................................................................12_|
|_Ilustración 5..................................................................................................................................13_|
|_Ilustración 6..................................................................................................................................13_|
|**_Ilustración 7_**_Diagrama de Casos de Uso del Sistema - ADAVAMINSA........................................16_|
|**_Ilustración 8_**_Arquitectura de Análisis - ADAVAMINSA................................................................22_|
|**_Ilustración 9_**_Representacion Grafca de Clases para ADAVAMINSA...........................................24_|
|**_Ilustración 10_**_Diagrama de CUS-02.............................................................................................25_|
|**_Ilustración 11_**_Diagrama de CUS-05.............................................................................................26_|
|**_Ilustración 12_**_Diagrama de Comunicación..................................................................................27_|
|**_Ilustración 13_**_Diagrama de Secuencia........................................................................................28_|
|**_Ilustración 14_**_Diagrama de Clase de ADAVAMISA......................................................................29_|
|**_Ilustración 15_**_Modelo Logico de ADAVAMISA.............................................................................30_|
|**_Ilustración 16_**_Modelo Fisico de ADAVAMISA...............................................................................31_|



## **_ÍNDICE DE TABLAS_** 

|_Tabla 1...........................................................................................................................................................7_|
|---|
|_Tabla 2...........................................................................................................................................................7_|
|_Tabla 3...........................................................................................................................................................9_|
|**_Tabla 4_**_Matriz de requerimientos para ADAVAMINSA................................................................................14_|
|**_Tabla 5_**_Relación de Casos de Uso vs. Actores.............................................................................................15_|
|**_Tabla 6_**_Tabla CUS-01...................................................................................................................................16_|
|**_Tabla 7_**_Tabla CUS-02...................................................................................................................................17_|
|**_Tabla 8_**_Tabla CUS-04...................................................................................................................................18_|
|**_Tabla 9_**_Tabla CUS-05...................................................................................................................................19_|
|**_Tabla 10_**_Tabla CUS-06.................................................................................................................................19_|
|**_Tabla 11_**_Tabla CUS-07.................................................................................................................................20_|
|**_Tabla 12_**_Tabla CUS-08.................................................................................................................................21_|
|**_Tabla 13_**_Tabla de Clases para ADAVAMINSA..............................................................................................23_|
|**_Tabla 14_**_Tabla de Tarjeta 01.......................................................................................................................31_|
|**_Tabla 15_**_Tabla de Tarjeta 02.......................................................................................................................32_|
|**_Tabla 16_**_Tabla de Tarjeta 03.......................................................................................................................32_|
|**_Tabla 17_**_Tabla de Tarjeta 04.......................................................................................................................32_|
|**_Tabla 18_**_Tabla de Tarjeta 05.......................................................................................................................33_|



## **_VIDEO Y PPT_** 

**_<u>Análisis y Diseño de Sistemas de Información APF3</u>_** 

## INTRODUCCIÓN 

En la actualidad la transformación digital se ha vuelto un factor determinante para el éxito y la sostenibilidad de las organizaciones, especialmente aquellas dedicadas a la asistencia social. El uso de sistemas de información modernos permite optimizar procesos críticos, garantizando que los recursos y el apoyo humano lleguen a sus beneficiarios de manera oportuna, transparente y eficiente. 

El presente proyecto se enfoca en la Asociación de Damas Voluntarias y Amigas del Ministerio de Salud (ADAVAMINSA), una organización con más de dos décadas de trayectoria dedicada a canalizar donaciones de medicinas, materiales quirúrgicos entre otros para pacientes de escasos recursos en la red de hospitales del MINSA a nivel nacional. A pesar de su impacto social, la asociación enfrenta retos operativos debido a que la gestión de su red de voluntarios y el control de los donativos recibidos se realizan de forma manual, lo que limita su capacidad de respuesta y trazabilidad. 

Ante esta situación, se plantea el desarrollo de una solución tecnológica integral que automatice la captación de recursos y la acreditación de personal voluntario. Con la implementación de este sistema, se busca eliminar los cuellos de botella informativos y asegurar que el soporte humanitario se gestione bajo estándares de calidad y rapidez. De este modo, el proyecto no solo busca modernizar la estructura operativa de ADAVAMINSA, sino también fortalecer el sistema de salud pública en el Perú, generando un impacto positivo en la vida de miles de pacientes en situación de vulnerabilidad. 

## JUSTIFICACIÓN 

El presente proyecto surge ante la necesidad de automatizar la gestión de donaciones y la acreditación de voluntarios en ADAVAMINSA, procesos que actualmente se realizan de forma manual. Esta situación genera una falta de trazabilidad en tiempo real de los insumos médicos y demoras en la asignación de apoyo humano, limitando la capacidad de respuesta de la asociación ante casos sociales urgentes. 

La implementación de este sistema permitirá centralizar la información y agilizar los flujos operativos, garantizando que la ayuda humanitaria y las medicinas lleguen a los pacientes de escasos recursos de la red MINSA con mayor rapidez y eficiencia. Al optimizar estos procesos en una organización de alcance nacional, se busca fortalecer el soporte asistencial y asegurar que los recursos se gestionen de manera transparente para beneficio directo de la salud pública en el país 

## OBJETIVOS GENERALES Y ESPECIFICOS 

- OBJETIVO GENERAL 

Diseñar un modelo de sistema de información para la Asociación de Damas Voluntarias y Amigas del Ministerio de Salud (ADAVAMINSA) que permita automatizar y centralizar la gestión de donaciones y el registro de voluntarios, con la finalidad de optimizar la respuesta asistencial y garantizar la trazabilidad de los recursos a nivel nacional 

- OBJETIVOS ESPECIFICOS 

1. Identificar y modelar los procesos actuales de la asociación mediante diagramas de casos de uso (vista externa e interna) para detectar cuellos de botella en la gestión manual. 

2. Recopilar y documentar los requerimientos funcionales y no funcionales de los usuarios clave (coordinadoras y personal de almacén) para mitigar riesgos en el diseño de la solución tecnológica. 

3. Reducir el tiempo de acreditación y capacitación de nuevos voluntarios en un 20% mediante la digitalización del flujo de registro para el cierre del año 2026. 

4. Optimizar el control de inventario de medicinas y materiales quirúrgicos en un 15% respecto al semestre anterior, permitiendo una consulta de stock en tiempo real para evitar desabastecimientos en los hospitales del MINSA. 

5. Elaborar el modelo de análisis de sistemas que incluya la definición de trabajadores, entidades y realizaciones de negocio para estructurar la arquitectura técnica del futuro software. 

## ASPECTOS DE LA ORGANIZACIÓN 

##  MISIÓN 

Ser una asociación de acción social de garantía y prestigio, que brinde una mayor cobertura de atención en problemas sociales, desarrollando acciones de atención, prevención y promoción de la salud, para el personal activo, cesante del Ministerio de Salud y para la población en general. (Ministerio de Salud, s.f.) 

##  VISIÓN 

Desarrollar una labor oportuna con eficiencia y eficacia, utilizando los recursos y donaciones que le permitan responder a la demanda de las necesidades del personal activo, cesante del MINSA y población en general en situación de riesgo social, orientando las acciones a la prevención, promoción y recuperación de las personas, familia y la comunidad, con la participación activa de las damas voluntarias, el personal técnico y profesional de ADAVAMINSA y otras redes de apoyo social. (Ministerio de Salud, s.f.) 

##  DESCRIPCIÓN DE LA EMPRESA 

La Asociación de Damas Voluntarias y Amigas del Ministerio de Salud (ADAVAMINSA) es una asociación civil afín al Ministerio de Salud, fundada el 22 de febrero del año 2000 con el objetivo de desarrollar actividades promocionales, preventivas y de bienestar social a favor del personal del ministerio y sus familias (Ministerio de Salud, s.f.). Asimismo, la organización canaliza donaciones de instituciones públicas y privadas para resolver casos sociales y fortalecer los establecimientos de salud a nivel nacional (Ministerio de Salud, s.f.). 

## 1. ÁMBITO DEL PROYECTO 

## 1.1. ÁREA 

El presente proyecto se implementará en la sede central de la Asociación de Damas Voluntarias y Amigas del Ministerio de Salud (ADAVAMINSA), ubicada dentro de las instalaciones del Ministerio de Salud en el distrito de Jesús María, Lima (Ministerio de Salud, s.f.). 

De manera específica, el sistema de información impactará en las siguientes áreas operativas: 

- **Área de Coordinación de Voluntariado:** Encargada de la convocatoria, registro, acreditación y asignación de roles de los ciudadanos que desean apoyar la labor social de la asociación. 

- **Departamento de Logística y Almacén de Donativos:** Responsable de la recepción, clasificación y control de inventario de las medicinas y materiales quirúrgicos que son canalizados hacia los pacientes de la red de hospitales del MINSA a nivel nacional. 

## 1.2. RECURSOS HUMANOS PARA LA ELABORACIÓN DEL PROYECTO 

_Tabla 1 Definición de Roles del Proyecto_ 

|**Cargo**|**Descripción de Funciones**|**Estado**|
|---|---|---|
|**Líder de Proyecto / Analista de**<br>**Negocio**|Responsable de la planifcación,<br>gestón de tempos y de<br>asegurar que los objetvos del<br>sistema se alineen con la<br>misión de ADAVAMINSA.|Asignado|
|**Analista de Sistemas**|Responsable de realizar el<br>levantamiento de información,<br>identfcar los requerimientos<br>de los usuarios y modelar los<br>procesos de negocio actuales y<br>futuros.|Asignado|
|**Diseñador de Sofware**|Encargado de defnir la<br>arquitectura del sistema, el<br>modelo de datos (entdades) y<br>la interfaz de usuario para la<br>gestón de voluntarios y<br>donaciones.|Asignado|
|**Programador / Desarrollador**|Responsable de la futura<br>implementación de los<br>componentes lógicos, la<br>creación de la base de datos y<br>el mantenimiento del código<br>del sistema.|Asignado|
|**Especialista en QA (Tester)**|Encargado de planifcar y<br>ejecutar las pruebas de<br>sofware para garantzar que el<br>sistema cumpla con los<br>requisitos de ADAVAMINSA y<br>no presente errores.|Asignado|



_Nota: Elaboración propia. Los roles corresponden a las funciones necesarias para el desarrollo del sistema propuesto para ADAVAMINSA._ 

_Tabla 2_ 

_Asignación del responsable del Proyecto_ 

|**Apellidos y Nombres**|**Código UTP**|**Roles Asumidos**|
|---|---|---|
|**Caballero Yali, Jhesper Julio**<br>**César**|U23252499|Líder de Proyecto / Analista /<br>Diseñador/ Programador /<br>QA|



Nota: _Elaboración propia. Asignación de roles_ 

## 1.3. SOFTWARE 

Para asegurar la calidad técnica y la escalabilidad de la solución propuesta para ADAVAMINSA, se han seleccionado las siguientes herramientas tecnológicas: 

















- **Visual Paradigm:** Herramienta esencial para el modelado y diseño de software. Se utilizará para la creación de los diagramas UML, incluyendo el modelado de negocio (vista externa e interna) y los diagramas de casos de uso. Su uso permite unificar la comunicación técnica mediante diagramas claros y estandarizados que facilitan la planificación del sistema. 

- **Figma:** Plataforma de diseño de interfaces y prototipado colaborativo. Se empleará para la creación de maquetas de alta fidelidad, permitiendo generar prototipos de las pantallas del sistema para que los usuarios (stakeholders) realicen observaciones tempranas antes de iniciar el desarrollo. Esta técnica es vital para explorar requerimientos y mitigar riesgos de usabilidad en una etapa inicial. 

- **NetBeans IDE:** Entorno de desarrollo integrado gratuito y de código abierto para aplicaciones Java. Se empleará para la futura codificación de los módulos lógicos y la creación de la interfaz de escritorio del sistema de gestión de ADAVAMINSA. **PostgreSQL:** Sistema de gestión de bases de datos relacionales de alto rendimiento y código abierto. Se ha seleccionado por su gran capacidad de escalabilidad y robustez, características indispensables para un sistema que aspira a tener un impacto nacional al manejar un padrón extenso de voluntarios e inventarios médicos complejos. **Canva:** Aplicación de diseño gráfico que se utilizará para la elaboración de la presentación de sustentación y el diseño de material visual estratégico. Su uso está alineado con las sugerencias de la rúbrica de evaluación respecto a la calidad de la presentación del proyecto. 

- **Microsoft Word:** Software de procesamiento de textos necesario para la redacción de la documentación técnica y el presente informe. Se utilizará para garantizar el cumplimiento de las normas APA 7 y el formato Calibri 11 solicitado por la universidad. **Zoom:** Servicio de videoconferencia basado en la nube que se empleará como medio principal para la coordinación y la grabación de la sustentación oral exigida en la fase de inicio. 

- **WhatsApp:** Aplicación de mensajería instantánea utilizada como canal complementario para la comunicación rápida de requerimientos y la coordinación logística durante la fase de levantamiento de información. 

## 1.4. HARDWARE 

Para garantizar el soporte físico del sistema de información y el resguardo seguro de la data de ADAVAMINSA, se han definido requerimientos de hardware que priorizan la autonomía operativa y la alta disponibilidad. Los elementos tangibles que componen el sistema son: 

##  **Estación de Trabajo:** 

`o` Laptop: 

- Procesador: Intel Core i7 o superior con una frecuencia base de 3.0 GHz para el manejo fluido de herramientas de modelado y entornos de desarrollo. 

- Memoria RAM: 16 GB DDR4 (configurada en Dual-Channel) para optimizar el rendimiento en multitarea. 

- Almacenamiento: Unidad de Estado Sólido (SSD) de 512 GB para garantizar tiempos mínimos de carga del sistema operativo y aplicaciones de ingeniería. 

- Pantalla: Se recomienda una de 14 pulgadas con resolución Full HD para una visualización clara de las interfaces diseñadas en Figma y Canva. 

##  **Infraestructura de Servidor Local:** 

- Modelo: Servidor NAS QNAP TVS-h1288X, seleccionado por su capacidad de procesamiento de datos y escalabilidad. Al proponer un servidor local por encima de la nube son por razones de rentabilidad para una fundación el pago mensual de un servidor no le convendría. 

- Configuración de Almacenamiento Híbrido: 

   - 8 Unidades HDD de alta capacidad para el almacenamiento masivo de registros históricos de donaciones. 

   - 4 Unidades SSD SATA para el almacenamiento de archivos de acceso frecuente y aplicaciones del sistema. 

   - 2 Unidades M.2 NVMe (internas) para actuar como caché de aceleración, optimizando el rendimiento de la base de datos PostgreSQL. 

##  **Periféricos y Conectividad:** 

- Equipo Multifuncional: Impresora, escáner y fotocopiadora con conexión a red local, indispensable para la digitalización de fichas de voluntarios y la emisión de reportes físicos de inventario. 

- Router de Alta Velocidad: Dispositivo de red con soporte para 50 Mbps o superior, asegurando la conectividad interna y externa para el acceso remoto seguro al servidor local. 

## 1.5. CRONOGRAMA DE ACTIVIDADES 

La planificación del proyecto para ADAVAMINSA se ha estructurado siguiendo las fases del Proceso Unificado Racional (RUP), asegurando un avance gradual y constante desde el análisis de negocio hasta la entrega del sistema integral. 

_Tabla 3_ 

_Cronograma General del Proyecto_ 

|**Fase RUP**|**Actvidad / Hito**|**Duración**|**Inicio**|**Fin**|**Estado**|
|---|---|---|---|---|---|
|**Sistema de**<br>**información**<br>**para**<br>**(ADAVAMINSA**<br>**)**|**-**|**18 sem**|**24/03/2026**|**21/07/26**|**En proceso**|
|**Inicio**|**Levantamiento de**<br>**Información (APF1)**|**5 semanas**|**Sem 1**|**Sem 5**|**Finalizado**|



|• Defnición de<br>problemátca y<br>objetvos SMART|1 sem|Sem 1|Sem 1|Hecho|
|---|---|---|---|---|
|• Modelado de<br>Negocio (Vista<br>Interna y Externa)|2 sem|Sem 2|Sem 3|Hecho|
|• Recopilación de<br>requerimientos<br>(Entrevistas/Figma)|2 sem|Sem 4|Sem 5|Hecho|
|**Elaboración**<br>**Análisis del Sistema**<br>**(APF2)**|**5 semanas**|**Sem 6**|**Sem 10**|**Pendiente**|
|• Diagramas de<br>Casos de Uso y<br>Especifcaciones|2 sem|Sem 6|Sem 7|-|
|• Análisis de<br>Objetos (Secuencia<br>y Comunicación)|2 sem|Sem 8|Sem 9|-|
|• Modelo<br>Conceptual y Lógico<br>de Datos|1 sem|Sem 10|Sem 10|-|
|**Construcción**<br>**Diseño y Desarrollo**<br>**(APF3)**|**5 semanas**|**Sem 11**|**Sem 15**|**Pendiente**|
|• Diseño de<br>Arquitectura y<br>Patrones|1 sem|Sem 11|Sem 11|-|
|• Diseño fsico de<br>Base de Datos<br>(PostgreSQL)|1 sem|Sem 12|Sem 12|-|
|• Codifcación de<br>módulos en Java<br>(NetBeans)|3 sem|Sem 13|Sem 15|-|
|**Transición**<br>**Validación y Cierre**<br>**(Proyecto Final)**|**3 semanas**|**Sem 16**|**Sem 18**|**Pendiente**|
|• Pruebas unitarias<br>y de integración|1 sem|Sem 16|Sem 16|-|
|• Elaboración de<br>Manuales y<br>Capacitación|1 sem|Sem 17|Sem 17|-|
|• Entrega integral y<br>Sustentación Final|1 sem|Sem 18|Sem 18|-|



_Nota: Elaboración propia. El cronograma del proyecto se ha estructurado en base a las fases RUP._ 



<!-- Start of picture text -->
Donante Postulante Instituci6n de Salud<br><!-- End of picture text -->







<!-- Start of picture text -->
<<Business Worker>> <<Business Worker>> <<Business Worker>><br>Coordinadora de Voluntariado Responsable de Almacén Administradora de ADAVAMINSA<br><!-- End of picture text -->



<!-- Start of picture text -->
Ficha de Voluntario Acta de Recepcidn de Donativo Padron de Beneficiarios<br><!-- End of picture text -->



<!-- Start of picture text -->
¢ RCUN: Gestiédnde ) ¢ %&RCUN2: Administracion del » y  RCUN3: Atencionde<br>\ Donaciones Médicas ~ _ Programa de Voluntariado __ ; \ Solicitudes Asistenciales _ /<br>™ =_ — —_—— == — _<br><!-- End of picture text -->

- B. El Cuestionario: Se aplicó un cuestionario digital a 15 voluntarios activos de la red asistencial para medir la eficiencia de la comunicación interna. Los resultados arrojaron que el 80% percibe una demora excesiva en la asignación de tareas debido a que las coordinaciones se realizan únicamente por llamadas o mensajes de texto no centralizados. 

- C. La Observación: Se aplicó la técnica de shadowing (observación en el sitio) en el área de logística. Se observó que el personal dedica aproximadamente 20 minutos en el llenado manual de cada acta de recepción y otros 15 minutos en el archivado físico. Se identificó además una "excepción" crítica: cuando llega una donación masiva, el flujo manual colapsa, generando un retraso de hasta 48 horas en la actualización del stock disponible para los hospitales 

## 2.2. MATRIZ DE REQUERIMIENTO 

**_Tabla 4_** 

_Matriz de requerimientos para ADAVAMINSA_ 

|**ID Req.**|**Descripción del**<br>**Requerimiento**|**Objetvo**<br>**de**<br>**Negocio**|**Módulo del**<br>**Sistema**|**Casos**<br>**de**<br>**Prueba**|**Estado**|**Prioridad**|**Responsable**|**Comentarios**|
|---|---|---|---|---|---|---|---|---|
|RF001|El sistema debe<br>permitr el<br>registro de<br>ingresos de<br>donaciones<br>médicas.|OBJ01|Gestón de<br>Inventario|TC001|Identfcado|Alta|Jhesper<br>Caballero|Reemplaza el<br>llenado<br>manual de<br>actas.|
|RF002|El sistema debe<br>generar alertas<br>visuales para<br>medicinas<br>próximas a<br>vencer.|OBJ01|Gestón de<br>Inventario|TC002|Identfcado|Alta|Jhesper<br>Caballero|Solicitado por<br>la<br>Coordinadora<br>en entrevista.|
|RF003|El sistema debe<br>permitr el<br>registro masivo<br>de lotes de<br>medicina.|OBJ03|Gestón de<br>Inventario|TC003|Identfcado|Media|Jhesper<br>Caballero|Mitga el<br>colapso ante<br>donaciones<br>masivas.|
||El sistema debe<br>permitr la|||||||Necesidad|
|RF004|<br>búsqueda de<br>voluntarios por<br>especialidad<br>médica.|OBJ02|Gestón de<br>Voluntariado|TC004|Identfcado|Alta|Jhesper<br>Caballero|crítca<br>detectada en<br>ofcina.|
|RF005|El sistema debe<br>centralizar la<br>asignación de<br>tareas a los<br>voluntarios.|OBJ02|Gestón de<br>Voluntariado|TC005|Identfcado|Alta|Jhesper<br>Caballero|Resuelve la<br>demora del<br>80% en<br>comunicación.|
||El sistema debe||||||||
|RF006|generar<br>reportes de<br>stock disponible<br>en tempo real.|OBJ03|Consultas y<br>Reportes|TC006|Identfcado|Media|Jhesper<br>Caballero|Mejora la<br>trazabilidad de<br>los recursos.|



_Nota: Elaboración propia._ 

3. FASE DE ELABARACIÓN 

3.1. CASOS DE USO 

a) Identificación de Actores del Sistema 

   - I. Administrador: Encargado del control total del inventario de medicinas y la generación de reportes. 

   - II. Coordinadora de Voluntariado: Responsable de gestionar el padrón de voluntarios y asignarles tareas. 

   - III. Sistema: Actor de soporte que automatiza el envío de alertas de caducidad y backups. 

- b) Tabla de Casos de Uso 

## **_Tabla 5_** 

_Relación de Casos de Uso vs. Actores_ 

|**Código**|**Caso de Uso del Sistema**|**Actor(es)**|
|---|---|---|
|CUS-01|Validar acceso al sistema<br>(Login)|Administrador /<br>Coordinadora|
|CUS-02|Registrar ingreso de<br>donación médica|Administrador|
|CUS-03|Gestonar alertas de<br>caducidad|Sistema / Administrador|
|CUS-04|Realizar registro masivo de<br>lotes|Administrador|
|CUS-05|Registrar voluntario nuevo|Coordinadora|
|CUS-06|Buscar voluntarios por<br>especialidad|Coordinadora|
|CUS-07|Asignar tareas asistenciales|Coordinadora|
|CUS-08|Generar reporte de stock<br>para hospitales|Administrador|



_Nota: Elaboración propia._ 

c) Diagrama de casos de uso 



<!-- Start of picture text -->
Administradora de ADAVAMINSA<br>Responsable de Aimacén Sistema<br>Coordinadora de Voluntariado<br>inity Edition @<br><!-- End of picture text -->

7. El sistema verifica el nivel de permisos (rol) del actor. 

8. El sistema muestra el mensaje "Bienvenido [Nombre]" y redirige al menú principal. 

## **Flujos Alternos y de Excepción** 

- 4.a. Credenciales incorrectas: Si los datos no coinciden, el sistema muestra el mensaje "Error: Usuario o contraseña inválidos" y limpia los campos para un nuevo intento. 

- 4.b. Usuario bloqueado: Si el usuario excede 3 intentos fallidos, el sistema deshabilita la cuenta temporalmente por seguridad. 

_Nota: Elaboración propia._ 

3.2.2. CUS-02: Registrar ingreso de donación médica 

## **_Tabla 7_** 

_Tabla CUS-02_ 

|**Campo**|**Detalle Técnico**|
|---|---|
|Código/Nombre|CUS-02: Registrar ingreso de donación médica|
||Permite el registro digital de los insumos médicos recibidos,<br>|
|Descripción|reemplazando el llenado manual de actas fsicas y actualizando el<br>stock en tempo real.|
|Actores|Responsable de Almacén, Administradora.|
|Precondición|El actor debe haber superado el CUS-01 (Login) y tener el acta de<br>recepción fsica a la mano.|
|Postcondición|Los datos de la medicina se guardan en el inventario y se actualiza<br>la tabla de stock disponible para hospitales|



## **Flujo Básico** 

1. El actor selecciona la opción "Inventario" y luego el botón "Nuevo Ingreso". 

2. El sistema despliega el formulario de registro de donaciones. 

3. El actor ingresa el nombre de la medicina y el número de lote. 

4. El actor selecciona la fecha de vencimiento del producto en el calendario. 

5. El actor ingresa la cantidad recibida y el donante de origen. 

6. El actor presiona el botón "Validar y Guardar". 

7. El sistema confirma que los datos son consistentes y graba el registro en PostgreSQL. 

8. El sistema muestra el mensaje: "Donación registrada exitosamente. Stock actualizado." 

## **Flujos Alternos** 

- 4.a. Alerta de Caducidad (Extensión CUS-03): Si la fecha de vencimiento ingresada es menor a 3 meses, el sistema activa automáticamente una alerta visual roja (emergente) notificando que el producto debe priorizarse para 

salida inmediata. 

- 5.a. Medicamento nuevo: Si el nombre de la medicina no existe en el catálogo, el sistema abre una ventana emergente para registrar primero la categoría y descripción del nuevo fármaco antes de continuar. 

_Nota: Elaboración propia._ 

- 3.2.3. CUS-04: Realizar registro masivo de lotes 

## **_Tabla 8_** _Tabla CUS-04_ 

|**Campo**|**Detalle Técnico**|
|---|---|
|Código/Nombre|CUS-04: Realizar registro masivo de lotes|
|Descripción|Permite la carga simultánea de múltples ítems médicos mediante la<br>importación de un archivo (Excel/CSV), optmizando el tempo de<br>respuesta ante donaciones masivas.|
|Actores|Administradora, Responsable de Almacén.|
|Precondición|El actor debe estar autentcado y poseer el archivo digital con el formato<br>de plantlla estandarizado por ADAVAMINSA.|
|Postcondición|El sistema procesa los datos, actualiza el inventario global y genera un<br>reporte de inconsistencias si las hubiera.|



## **Flujo Básico** 

1. El actor selecciona la opción "Carga Masiva" en el módulo de Inventario. 

2. El sistema muestra la interfaz de carga y un enlace para descargar la plantilla oficial. 

3. El actor selecciona el archivo preparado desde su almacenamiento local. 4. El actor presiona el botón "Previsualizar Datos". 

5. El sistema lee el archivo y muestra una tabla temporal con los nombres, lotes y vencimientos detectados. 

6. El actor revisa que la información sea correcta y presiona "Procesar Carga". 

7. El sistema valida la integridad de cada registro y los inserta en la base de datos PostgreSQL. 

8. El sistema finaliza mostrando el mensaje: "Carga finalizada: [X] registros importados con éxito". 

## **Flujos Alternos y de Excepción** 

- 3.a. Formato de archivo incorrecto: Si el archivo no es .xlsx o .csv, el sistema muestra un error de "Formato no soportado" y bloquea el botón de previsualización. 

- 7.a. Datos incompletos en el archivo: Si faltan campos obligatorios (como el Lote), el sistema resalta las filas en rojo y permite al usuario corregirlas manualmente en la tabla temporal antes de procesar. 

## _Nota: Elaboración propia._ 

3.2.4. CUS-05: Registrar voluntario nuevo 

## **_Tabla 9_** 

_Tabla CUS-05_ 

|**Campo**|**Detalle Técnico**|
|---|---|
|Código/Nombre|CUS-05: Registrar voluntario nuevo|
||Permite a la coordinadora ingresar los datos personales, especialidad|
|Descripción|médica y disponibilidad de los ciudadanos que desean unirse a la<br>asociación como voluntarios acreditados.|
|Actores|Coordinadora de Voluntariado.|
|Precondición|La coordinadora debe haber iniciado sesión (CUS-01) y contar con la<br>documentación fsica o digital del postulante.|
|Postcondición|Se crea un nuevo registro en la tabla Voluntario de la base de datos<br>PostgreSQL y el estado del voluntario cambia a "Actvo".|



## **Flujo Básico** 

1. La coordinadora ingresa al módulo de "Gestión de Voluntarios". 

2. La coordinadora hace clic en el botón "Nuevo Voluntario". 

3. El sistema despliega el formulario digital de la Ficha de Voluntario. 

4. La coordinadora ingresa el número de DNI y los datos de contacto del postulante. 

5. La coordinadora selecciona la especialidad médica y los días de disponibilidad. 

6. La coordinadora adjunta la documentación de acreditación escaneada (PDF). 

7. La coordinadora presiona el botón "Finalizar Registro". 

8. El sistema valida que los campos obligatorios estén llenos, guarda la información y muestra el mensaje: "Voluntario registrado con éxito". 

## **Flujos Alternos y de Excepción** 

- 4.a. DNI Duplicado: Si el DNI ya existe en la base de datos, el sistema muestra una alerta indicando que el voluntario ya está registrado y redirige a la vista de edición. 

- 6.a. Archivo no válido: Si el documento adjunto excede el tamaño permitido o no es PDF, el sistema muestra un mensaje de error y permite reintentar la subida. 

## _Nota: Elaboración propia._ 

- 3.2.5.CUS-06: Buscar voluntarios por especialidad 

## **_Tabla 10_** 

_Tabla CUS-06_ 

|**Campo**|**Detalle Técnico**|
|---|---|
|Código/Nombre|CUS-06: Buscar voluntarios por especialidad|
||Permite fltrar y localizar rápidamente a los voluntarios registrados según<br>|
|Descripción|su perfl médico para facilitar la asignación de tareas en los hospitales del<br>MINSA.|
|Actores|Coordinadora de Voluntariado.|



Precondición El usuario debe estar autenticado en el sistema. 

El sistema muestra en pantalla una lista de voluntarios disponibles que Postcondición cumplen con el criterio de especialidad solicitado. 

## **Flujo Básico** 

1. La coordinadora selecciona la opción "Búsqueda Avanzada" en el menú de voluntarios. 

2. El sistema muestra un menú desplegable con el catálogo de especialidades médicas (ej. Pediatría, Enfermería). 

3. La coordinadora selecciona la especialidad requerida para la atención asistencial. 

4. La coordinadora presiona el botón "Filtrar". 

5. El sistema realiza la consulta en la base de datos PostgreSQL filtrando por el campo Especialidad. 

6. El sistema despliega una tabla con los nombres, teléfonos y disponibilidad actual de los voluntarios encontrados. 

7. La coordinadora revisa la lista para iniciar la coordinación externa. 

8. El sistema permite descargar el resultado en formato PDF si la coordinadora lo solicita. 

## **Flujos Alternos y de Excepción** 

- 5.a. Sin coincidencias: Si no existen voluntarios con esa especialidad, el sistema muestra el mensaje: "No se encontraron voluntarios registrados en esta especialidad" y ofrece limpiar los filtros. 

- 7.a. Ver detalles: La coordinadora hace doble clic en un registro de la lista para abrir la ficha completa del voluntario y ver sus antecedentes de servicio. 

_Nota: Elaboración propia._ 

3.2.6. CUS-07: Asignar tareas asistenciales 

|**_Tabla 11_**||
|---|---|
|_Tabla CUS-07_||
|**Campo**|**Detalle Técnico**|
|Código/Nombre|CUS-07: Asignar tareas asistenciales|
|Descripción|Permite a la coordinadora vincular a un voluntario acreditado con una<br>solicitud de apoyo específca en un hospital de la red MINSA.|
|Actores|Coordinadora de Voluntariado.|
|Precondición|La coordinadora debe estar autentcada y el voluntario debe estar en<br>estado "Actvo".|
|Postcondición|La tarea queda registrada en el cronograma del sistema y el estado del<br>voluntario se actualiza a "Asignado".|
|**Flujo Básico**||



1. La coordinadora selecciona el módulo "Gestión de Tareas" en el menú principal. 

2. El sistema muestra la lista de solicitudes de apoyo pendientes de los hospitales. 

3. La coordinadora selecciona una solicitud y presiona el botón "Asignar Voluntario". 

4. El sistema despliega la lista de voluntarios filtrados previamente por especialidad (CUS-06). 

5. La coordinadora elige al voluntario idóneo para la labor asistencial. 

6. El sistema solicita definir el horario y la fecha de inicio de la actividad. 

7. La coordinadora ingresa los detalles y presiona el botón "Confirmar Asignación". 

8. El sistema registra la orden de servicio en la base de datos PostgreSQL y emite una notificación de éxito. 

## **Flujos Alternos y de Excepción** 

- 5.a. Voluntario no disponible: Si el voluntario seleccionado ya tiene otra tarea en el mismo horario, el sistema bloquea la asignación y muestra un mensaje de "Conflicto de Horario". 

- 7.a. Cancelar proceso: Si la coordinadora decide no realizar la asignación, presiona "Cancelar" y el sistema regresa al listado de solicitudes del paso 2. 

_Nota: Elaboración propia._ 

3.2.7. CUS-08: Generar reporte de stock para hospitales 

|**_Tabla 12_**<br>_Tabla CUS-08_||
|---|---|
|**Campo**|**Detalle Técnico**|
|Código/Nombre|CUS-08: Generar reporte de stock para hospitales|
|Descripción|El sistema consolida la información de las medicinas disponibles en el<br>inventario para emitr un documento ofcial destnado a los hospitales<br>receptores.|
|Actores|Administradora, Responsable de Almacén.|
|Precondición|El actor debe haber iniciado sesión y debe existr al menos un ingreso de<br>donación registrado.|
|Postcondición|El sistema genera un archivo digital descargable (PDF/Excel) con el<br>inventario valorizado y actualizado.|



## **Flujo Básico** 

1. El actor ingresa al módulo de "Reportes y Consultas". 

2. El actor selecciona la opción "Inventario para Hospitales". 

3. El sistema solicita filtrar la información por Categoría de Medicina o Fecha de Vencimiento. 

4. El actor define los parámetros de búsqueda y presiona "Previsualizar". 

5. El sistema realiza la consulta en la base de datos y muestra una tabla resumen con el stock actual. 

6. El actor selecciona el formato de salida requerido (preferentemente PDF para 



<!-- Start of picture text -->
Capa Especifica (Modulos de Negocio)<br>' D — SSS D<br>\ nn ee en<br>---------4 ry<br>1 ry<br>1 ry<br>1 iy<br>Capa General (Soporte) it i<br>''<br>1ie<br>y1 Wwaig!<br>aa<br><!-- End of picture text -->

**_Tabla 13_** 

_Tabla de Clases para ADAVAMINSA_ 

|Categoría|Nombre de la Clase|Descripción / Responsabilidad|
|---|---|---|
|**Boundar**<br>**y**|FrmLogin|Interfaz para la validación de credenciales de<br>usuario.|
|**Boundar**<br>**y**|FrmRegistroDonacion|Formulario para el ingreso de medicinas e insumos<br>médicos.|
|**Boundar**<br>**y**|FrmGestonVoluntarios|Pantalla para la acreditación y búsqueda por<br>especialidad.|
|**Boundar**<br>**y**|FrmReporteStock|Interfaz para la generación de documentos para<br>hospitales.|
|**Control**|ControladorSeguridad|Gestona la sesión y niveles de acceso de los<br>usuarios.|
|**Control**|ControladorInventario|Procesa las entradas de stock y dispara alertas de<br>caducidad.|
|**Control**|ControladorVoluntariado|Administra el padrón y la asignación de tareas<br>asistenciales.|
|**Entty**|Usuario|Almacena datos de acceso y roles (Administradora,<br>Almacén).|
|**Entty**|Medicina|Contene información del fármaco, lote y fecha de<br>vencimiento.|
|**Entty**|Voluntario|Almacena datos personales, especialidad y<br>disponibilidad.|
|**Entty**|Donatvo|Registra el historial de ingresos y el donante de<br>origen.|



_Nota: Elaboración propia._ 

III. Representación gráfica 



<!-- Start of picture text -->
Gestion de Inventario<br>FrmRegistroDonacion Controladorinventario<br>Donative<br>Seguridad<br>(mo) ControladorSequridad (om<br>Gestion de Voluntariado<br>FrmGestionVoluntartos ControladorVoluntanado (=)<br>Consultas y Reportes<br>FimReportestock Controladorinventario<br>Donative<br>Powered ByO'Visual Paradigm Conmknunity Editign to<br><!-- End of picture text -->



<!-- Start of picture text -->
Medicina<br>FrmRegistroDonacion |———»-|_ Controladorinventario<br>Responsable Donative<br>de Almacen Pormeted ByOVisual Paradigm Gommunty Edition $4<br><!-- End of picture text -->



<!-- Start of picture text -->
| FrmGestionVoluntarios ControladorVoluntariado<br>Coordinadora<br>Voluntariadode Powered ByOVisual Paradigm Community Edition ct<br><!-- End of picture text -->



<!-- Start of picture text -->
3: validarDatosM edicina()<br>= a: Medicina2<br>§: actualizarStock()<br>><br>1: ingresarDatos(lote, medicina, cant) 2: procesarRegistro()<br>a<br>6: mostrarConfirmacion()<br>Responsable de Aimacén : FrmRegistroDonacion 4 : Controladorinventario<br>4: crearRegistroDonativo()<br>><br>Powered By’ Visual Paradigm Communi, Eeliti<br><!-- End of picture text -->



<!-- Start of picture text -->
k -—@ ©)<br>Coordinadora de Voluntariado : Frm Gestion Voluntarios : ControladorVeluntariade<br>||<br>|| |<br>1: solicitarFormularia{||<br>|<br>1.1: mostrarinterfaz{) ! ||<br>——--------------- | |<br>| |<br>2: enviarDatos(dni, especialidad|||<br>||<br>3: procesarRegistro() | |<br>|<br>| |<br>| 4: validarDNi(dni): :<br>|<br>|<br>| |<br>| 5: <<create>><br>~-------------><br>: Voluntario<br>! |<br>| & confirmarRegistro() |<br>7: notificarEx itot }<br>&: mostrarConfirmacion(} | | |<br>|<br>||<br>||<br>|<br>i<br><!-- End of picture text -->



<!-- Start of picture text -->
-id_donante -id_medicina<br>-nombre_institucion- 4 we gonae pombre_generico<br>-contacto 2 1.7] -fecha_recepcion 1*= egistra -num_lote<br>-cantidad_total 1) fecha_vencimiento<br>-tipo_donante<br>-observaciones ~stock_disponible<br>J] +generarActaRecepcion() *actualizarStock()<br>+validarVigencia()<br>-id_usuario<br>-nombre_usuario -dni_voluntario<br>-password -nombres_apellidos<br>tol 4 administ -especialidad_medica u ejecuta<br>0.4 °<br>~<br>+validarAcceso() -estado_acreditacion<br>+recuperarContrasefnia()oe +acreditarPersonal() 0.4] id tarea<br>+cambiarEstado() -descripcion_labor<br>-fecha_programada<br>-estado_tarea<br>+asignarVoluntario()<br>-id_hospital<br>QO°*) +finalizarTarea()<br>-nombre_hospital 1 solicita<br>-ted_minsa<br>-ubicacion<br><!-- End of picture text -->



<!-- Start of picture text -->
= femme id_donante nombre_generico<br>nombre_institucion aliza Og ‘contiene: =|<br>- ‘pesonans i observ:<br>VOLUNTARIO<br>moc<br>ss nombres_apellidos | ejecuta<br>especialidad<br>estado hy = | usuario<br>id_usuario<br>FK nombre_usuario.<br>id_hospital FK string |password<br>HOSPITAL<br>— revere " solicita O {Adate |fecha_prog<br>nombre_hospital<br><!-- End of picture text -->



<!-- Start of picture text -->
MEDICINA<br>[ionaneE— es—<C*sisSCisdY DOWATND su oem me<br>“= “ee eomne | ues me me<br>VARCHAR(150)VARCHAR(30) oe|nombre_institucion fe ealiza—OG INTEGERone emee | FK ontiene —4<] VARCHAR(100)wees) mee |nombre_generico |<br>| tipo_donante a one omen |<br>meee me<br>VOLUNTARIO<br>ween) sve fee |<br>VARCHAR(150) |nombres_apellidos | | ejecuta<br>VARCHAR(50) _ | especialidad O<br>y TAREA<br>oe mm “ae nme ss<br>ween) “eet sme |<br>weer  Je fe wee) someon | |<br>rer lero fe<br>HOSPITAL foe VARCHAR(20) | rol<br>TIMESTAMP | fecha_prog<br>VARCHAR(100)SERIAL |id_hospitalnombre_hospital ~a solicita O<br>ween wm |<br><!-- End of picture text -->

**_Tabla 15_** _Tabla de Tarjeta 02_ 

## **Nombre de la Clase: Voluntario** 

Responsabilidades 

1. Mantener el perfil personal, DNI y datos de contacto. 

2. Registrar la especialidad médica y días de disponibilidad. 

3. Cambiar el estado del voluntario (Activo / Asignado / Inactivo). 

|Colaboradores<br>Tarea<br>ControladorVoluntariado|
|---|



4. Almacenar el historial de horas de servicio cumplidas. 

_Nota: Elaboración propia._ 

3) Tarjeta 03: Clase Donativo 

## **_Tabla 16_** 

_Tabla de Tarjeta 03_ 

## **Nombre de la Clase: Donativo** 

|Respon|sabilidades|Colaboradores|
|---|---|---|
|1.<br>2.<br>3.|Registrar la fecha de recepción y el donante de origen.<br>Vincular los ítems recibidos con sus respectvos lotes.<br>Generar el acta de recepción digital para archivo<br>administratvo.|Donante<br>Medicina<br>ResponsableAlmacen|



_Nota: Elaboración propia._ 

4) Tarjeta 04: Clase Tarea 

## **_Tabla 17_** 

_Tabla de Tarjeta 04_ 

## **Nombre de la Clase: Tarea** 

- Responsabilidades Colaboradores 1. Programar la fecha, hora y descripción de la labor asistencial. Voluntario 

- 2. Vincular la solicitud de apoyo con un hospital específico. Hospital 

- 3. Notificar el estado de cumplimiento de la misión (Pendiente / Coordinadora 

- Finalizada). 

_Nota: Elaboración propia._ 

5) Tarjeta 05: Clase Usuario 

## **_Tabla 18_** 

_Tabla de Tarjeta 05_ 

|**Nombr**|**e de la Clase: Usuario**||
|---|---|---|
|Respon|sabilidades|Colaboradores|
|1.|Validar las credenciales de acceso (Login).<br>||
|2.|Identfcar el rol del usuario (Administradora, Almacén,<br>Coordinadora).<br>|ControladorSeguridad|
|3.|Registrar los logs de auditoría sobre modifcaciones en la<br>base de datos.||



_Nota: Elaboración propia._ 

## 3.8. DISEÑO DEL SISTEMA 

## 3.8.1.Patrón de diseño 

Para el desarrollo del aplicativo de escritorio de ADAVAMINSA en el IDE NetBeans, se ha implementado una arquitectura basada en el patrón de diseño Modelo-VistaControlador (MVC), integrada con el patrón DAO (Data Access Object) y una organización por N-Capas. Esta combinación garantiza la separación de responsabilidades, facilitando el mantenimiento y la escalabilidad del sistema de trazabilidad médica y gestión asistencial. 

# **A. Capa de Presentación (Vista)** 

Esta capa es la encargada de generar la interfaz gráfica (GUI) con la que interactúan los usuarios de la asociación (Administradora, Responsable de Almacén y Coordinadora). Se han desarrollado formularios utilizando Java Swing (JFrame) que permiten capturar los valores de ingreso y visualizar los resultados del procesamiento de datos. 

Componentes: FrmLogin, FrmPrincipal, FrmDonaciones, FrmInventario, FrmVoluntarios, FrmReportes. 

# **B. Capa de Lógica de Negocio (Controlador)** 

Actúa como el intermediario fundamental entre la Vista y el Modelo. Captura las acciones del usuario (pulsación de botones, selección de menús) y ejecuta la lógica necesaria para procesar los registros de ADAVAMINSA antes de su persistencia. 

Componentes: LoginController, InventarioController, VoluntarioController. 

# **C. Capa de Datos (Modelo y DAO)** 

Esta capa gestiona la persistencia y la interacción con la base de datos relacional PostgreSQL. 

Modelo (Entidades): Clases Java que representan los objetos de negocio del dominio, tales como Medicina, Donativo, Voluntario y Usuario. 



<!-- Start of picture text -->
<US6>> <<use>><br>Powarad By Visual P<br><!-- End of picture text -->



<!-- Start of picture text -->
om Pomeredty;viese Peretgmconmavyctr @<br><!-- End of picture text -->



<!-- Start of picture text -->
0 2 8 10 14 15 opto enn<br><!-- End of picture text -->



<!-- Start of picture text -->
TCP/IP (JDBC)<br>°<br><!-- End of picture text -->



## 3.9. APLICATIVO 

- 3.9.1.Pantallazos del Software 

3.9.2.Descripción de la Implementación 

3.9.3.Pruebas y Formatos de Validación 

## CONCLUSION 

## RECOMENDACIONES 

## BIBLIOGRAFÍA 

Karen Zerpa. (10 de marzo de 2021). _TABLAS NORMAS APA SÉPTIMA EDICIÓN_ . Youtube: https://youtu.be/7Qx5NenVJTY 

Ministerio de Salud. (s.f.). _ADAVAMINSA_ . .: Adavaminsa :. Asociación de Damas Voluntarias y Amigas del Ministerio de Salud - Ministerio de Salud: http://www.minsa.gob.pe/adavaminsa/ 

XperTek. (23 de septiembre de 2023). _UML en 120 minutos, del Análisis y Diseño a la Implementación._ Youtube: https://youtu.be/TQdf2lsfqEc 

