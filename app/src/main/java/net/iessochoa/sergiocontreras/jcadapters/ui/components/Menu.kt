package net.iessochoa.sergiocontreras.jcadapters.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.jcadapters.ui.theme.JCAdaptersTheme

/**
 * Project: JC Adapters
 * From: net.iessochoa.sergiocontreras.jcadapters.ui.components
 * Created by: Contr
 * On: 12/10/2025 at 23:57
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Preview(showBackground = true)
@Composable
private fun LocalPreview() {
    JCAdaptersTheme {
        SpinnerPan()
    }
}

@Composable
fun SpinnerPan(
    modifier: Modifier = Modifier,
    label: String = "",
    items: List<String> = listOf()
) {
    var selectedText by remember { mutableStateOf("") }
    var isExpanded by remember {mutableStateOf(false)}
    Column {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            label = { Text(text = label) },
            trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = null) },
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false}
        ) {
            items.forEach {
                DropdownMenuItem(
                    text = { Text(text = it) },
                    onClick = {
                        selectedText = it
                        isExpanded = false
                    }
                )
            }
        
        }

    }
}


