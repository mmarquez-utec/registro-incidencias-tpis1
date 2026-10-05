package sv.edu.utec.etps1.registroincidencias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sv.edu.utec.etps1.registroincidencias.ui.theme.RegistroIncidenciasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroIncidenciasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegistroAsistenciaScreen()
                }
            }
        }
    }
}

@Composable
fun RegistroAsistenciaScreen() {
    var titulo by rememberSaveable { mutableStateOf("") }
    var descripcion by rememberSaveable { mutableStateOf("") }
    var estadoAsistencia by rememberSaveable { mutableStateOf("") }
    val mensajeInicial = stringResource(R.string.feedback_initial)
    var mensaje by rememberSaveable { mutableStateOf(mensajeInicial) }

    val formularioCompleto = titulo.isNotBlank() &&
        descripcion.isNotBlank() &&
        estadoAsistencia.isNotBlank()
    val context = LocalContext.current
    val opcionesEstado = listOf(
        stringResource(R.string.status_present) to "estadoPresenteChip",
        stringResource(R.string.status_absent) to "estadoAusenteChip",
        stringResource(R.string.status_excused) to "estadoJustificadoChip"
    )
    val focusManager: FocusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.screen_title),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(R.string.screen_instruction),
            style = MaterialTheme.typography.bodyLarge
        )

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tituloInput"),
            label = { Text(stringResource(R.string.field_title)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("descripcionInput"),
            label = { Text(stringResource(R.string.field_description)) },
            minLines = 3,
            maxLines = 4,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )

        Text(
            text = stringResource(R.string.attendance_status_title),
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            opcionesEstado.forEach { (estado, etiquetaPrueba) ->
                FilterChip(
                    selected = estadoAsistencia == estado,
                    onClick = {
                        estadoAsistencia = estado
                        mensaje = context.getString(
                            R.string.feedback_status_selected,
                            estado
                        )
                    },
                    label = { Text(estado) },
                    modifier = Modifier.testTag(etiquetaPrueba)
                )
            }
        }

        Button(
            onClick = {
                mensaje = context.getString(
                    R.string.feedback_report_ready,
                    titulo.trim(),
                    estadoAsistencia
                )
                focusManager.clearFocus()
            },
            enabled = formularioCompleto,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("crearReporteButton")
        ) {
            Text(stringResource(R.string.action_create_report))
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.feedback_heading),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = mensaje,
                    modifier = Modifier.testTag("mensajeEstado")
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroAsistenciasPreview() {
    RegistroIncidenciasTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RegistroAsistenciaScreen()
        }
    }
}
