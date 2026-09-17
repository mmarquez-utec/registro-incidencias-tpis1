# Registro de asistencias

Aplicación Android desarrollada como parte de la materia **Técnicas de Producción Industrial de Software I**. El objetivo del proyecto es evolucionar hacia una herramienta para registrar asistencia de alumnos en horarios definidos y consultar reportes básicos durante el ciclo.

## Funcionalidad implementada

- Captura una identificación breve del registro de asistencia.
- Captura una descripción o detalle del horario en un campo multilínea.
- Mantiene los datos de la pantalla mediante estado de Jetpack Compose.
- Habilita la acción principal únicamente cuando ambos campos contienen información.
- Muestra una confirmación visible al preparar el registro.

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
2. Confirmar que el botón **Preparar asistencia** se habilite.
3. Presionar el botón.
4. Verificar que aparezca el mensaje `Registro preparado: <identificación>`.

Las pruebas locales pueden ejecutarse en Windows con:

```powershell
.\gradlew.bat testDebugUnitTest assembleDebug
```

La prueba de interfaz requiere un dispositivo o emulador conectado:

```powershell
.\gradlew.bat connectedDebugAndroidTest
```

## Estado del proyecto

Actividad evaluada de la semana 7: primer avance del módulo de asistencias y evidencia técnica del proyecto.
