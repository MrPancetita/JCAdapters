package net.iessochoa.sergiocontreras.jcadapters.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Project: JC Adapters
 * From: net.iessochoa.sergiocontreras.jcadapters.ui.components
 * Created by: Contr
 * On: 20/10/2025 at 09:54
 * Creado en Settings -> Editor -> File and Code Templates
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicSelectTextField(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            readOnly = true, // El campo de texto no se edita directamente
            value = selectedValue,
            onValueChange = {}, // Vacío porque es readOnly
            label = { Text(text = label) },
            trailingIcon = {
                // Icono que indica si el menú está desplegado o no
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = OutlinedTextFieldDefaults.colors(), // Colores por defecto
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryEditable, false) // Ancla el menú al TextField
                .fillMaxWidth()
        )
        // El menú desplegable en sí
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false } // Acción al cerrar el menú
        ) {
            // Itera sobre las opciones para crear cada item del menú
            options.forEach { option: String ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        expanded = false // Cierra el menú
                        onValueChangedEvent(option) // Llama al callback con la opción seleccionada
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun EjemploDropdownMenu() {
    val options = listOf("Manzana", "Plátano", "Fresa", "Naranja")
    // Estado para guardar la selección actual
    var (seleccion, onValueChanged) = remember { mutableStateOf(options[0]) } // Opción por defecto

    Column(modifier = Modifier.padding(16.dp)) {
        DynamicSelectTextField(
            selectedValue = seleccion,
            options = options,
            label = "Fruta favorita",
            onValueChangedEvent = onValueChanged // Actualiza el estado al seleccionar
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Has seleccionado: $seleccion") // Muestra la selección actual
    }
}