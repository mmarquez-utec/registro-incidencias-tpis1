package sv.edu.utec.etps1.registroincidencias

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegistroIncidenciaScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun botonPermaneceDeshabilitadoConFormularioIncompleto() {
        composeTestRule.onNodeWithTag("crearReporteButton").assertIsNotEnabled()

        composeTestRule.onNodeWithTag("tituloInput")
            .performTextInput("Falla de impresora")

        composeTestRule.onNodeWithTag("crearReporteButton").assertIsNotEnabled()
    }

    @Test
    fun espaciosNoSeConsideranInformacionValida() {
        composeTestRule.onNodeWithTag("tituloInput").performTextInput("   ")
        composeTestRule.onNodeWithTag("descripcionInput").performTextInput("   ")

        composeTestRule.onNodeWithTag("crearReporteButton").assertIsNotEnabled()
    }

    @Test
    fun crearReporteMuestraRetroalimentacionConElTitulo() {
        composeTestRule.onNodeWithTag("tituloInput")
            .performTextInput("Falla de impresora")
        composeTestRule.onNodeWithTag("descripcionInput")
            .performTextInput("La impresora del área administrativa no responde.")

        composeTestRule.onNodeWithTag("crearReporteButton")
            .assertIsEnabled()
            .performClick()

        composeTestRule.onNodeWithTag("mensajeEstado")
            .assertIsDisplayed()
            .assertTextEquals("Reporte preparado: Falla de impresora")
    }
}
