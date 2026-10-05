# Registro de asistencias

Aplicación Android desarrollada como parte de la materia **Técnicas de Producción Industrial de Software I**. El objetivo del proyecto es evolucionar hacia una herramienta para registrar asistencia de alumnos en horarios definidos y consultar reportes básicos durante el ciclo.

## Funcionalidad implementada

- Captura una identificación breve del registro de asistencia.
- Captura una descripción o detalle del horario en un campo multilínea.
- Configura el teclado contextual con capitalización por oración y acciones IME **Next** / **Done**.
- Permite seleccionar mediante toque el estado de asistencia: **Presente**, **Ausente** o **Justificado**.
- Mantiene los datos de la pantalla mediante estado de Jetpack Compose.
- Habilita la acción principal únicamente cuando los campos contienen información y existe un estado seleccionado.
- Muestra retroalimentación visible al seleccionar un estado y al preparar el registro.

> Esta versión trabaja solamente con estado local. Todavía no guarda datos en base de datos ni administra catálogos reales de alumnos, horarios o materias.

## Visión del proyecto

En próximas versiones, la aplicación podrá incorporar:

- Registro y consulta de alumnos.
- Definición de horarios de clase.
- Marcación de asistencia por horario.
- Reportería básica para revisar asistencia por alumno, fecha u horario.

## Tecnologías

- Kotlin
- Jetpack Compose
- Material 3
- Gradle
- Android SDK 37

## Requisitos

- Android Studio
- JDK configurado por Android Studio
- Dispositivo o emulador con Android 7.0 (API 24) o superior

## Ejecución

1. Clonar o descargar este repositorio.
2. Abrir la carpeta del proyecto en Android Studio.
3. Esperar a que finalice la sincronización de Gradle.
4. Conectar un teléfono con la depuración USB habilitada o iniciar un emulador.
5. Seleccionar el dispositivo y presionar **Run app**.

## Comprobación

1. Escribir un título y una descripción.
2. Seleccionar un estado de asistencia mediante toque.
3. Confirmar que el botón **Preparar asistencia** se habilite.
4. Presionar el botón.
5. Verificar que aparezca el mensaje `Registro preparado: <identificación> - Estado: <estado>`.

Las pruebas locales pueden ejecutarse en Windows con:

```powershell
.\gradlew.bat testDebugUnitTest assembleDebug
```

La prueba de interfaz requiere un dispositivo o emulador conectado:

```powershell
.\gradlew.bat connectedDebugAndroidTest
```

## Estado del proyecto

Actividad evaluada de la semana 10: teclado contextual e interacción táctil en el prototipo de registro de asistencias.

El avance actual demuestra entrada de texto, acción del teclado, selección táctil y retroalimentación en pantalla. La persistencia de datos, los catálogos y la reportería real quedan fuera de esta versión.
