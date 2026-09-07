# Registro de incidencias

Aplicación Android desarrollada como parte de la materia **Técnicas de Producción Industrial de Software I**. Esta versión convierte la pantalla inicial en un formulario capaz de reaccionar a la información ingresada por el usuario.

## Funcionalidad implementada

- Captura el título de una incidencia.
- Captura una descripción breve en un campo multilínea.
- Mantiene los datos de la pantalla mediante estado de Jetpack Compose.
- Habilita la acción principal únicamente cuando ambos campos contienen información.
- Muestra una confirmación visible al preparar el reporte.

> Esta versión trabaja solamente con estado local. Los reportes todavía no se guardan en una base de datos.

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
2. Confirmar que el botón **Crear reporte** se habilite.
3. Presionar el botón.
4. Verificar que aparezca el mensaje `Reporte preparado: <título>`.

Las pruebas locales pueden ejecutarse en Windows con:

```powershell
.\gradlew.bat testDebugUnitTest assembleDebug
```

La prueba de interfaz requiere un dispositivo o emulador conectado:

```powershell
.\gradlew.bat connectedDebugAndroidTest
```

## Estado del proyecto

Actividad evaluada de la semana 6: interfaz con estado y evidencia en GitHub.
