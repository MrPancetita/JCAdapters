package net.iessochoa.sergiocontreras.jcadapters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.jcadapters.ui.components.ItemListAdvance
import net.iessochoa.sergiocontreras.jcadapters.ui.components.ItemListBasic
import net.iessochoa.sergiocontreras.jcadapters.ui.components.SpinnerPan
import net.iessochoa.sergiocontreras.jcadapters.ui.theme.JCAdaptersTheme

/**
 * Project: JC Adapters
 * From: net.iessochoa.sergiocontreras.jcadapters
 * Created by: Contr
 * On: 13/10/2025 at 12:57
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    JCAdaptersTheme {
        MainView(Modifier
            .padding(top=24.dp),
            onSelectedItem = {})
    }
}



@Composable
fun MainView(modifier: Modifier, onSelectedItem: (Food) -> Unit) {
    val countries = getAllCountries()
    val friends = getAllFriends()
    val foods = getAllFoods()

    val buttons = listOf(
        stringResource(R.string.section_friends),
        stringResource(R.string.section_foods)
    )
    var selectedIndex by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.padding(vertical = dimensionResource(R.dimen.common_padding_default))) {
        SpinnerPan(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.common_padding_default)),
            label = stringResource(R.string.hint_country),
            items = countries
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            SingleChoiceSegmentedButtonRow(
                Modifier.padding(vertical = dimensionResource(R.dimen.common_padding_min))
            ) {
                buttons.forEachIndexed { index, label ->
                    SegmentedButton(
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = buttons.size
                        ),
                        onClick = { selectedIndex = index },
                        selected = selectedIndex == index,
                        label = {
                            Text(label)
                        })

                }
            }

        }


        if (selectedIndex== 0) {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                friends.forEach { friend ->
                    ItemListBasic(friend)
                }

            }
        }


        if (selectedIndex== 1) {
            LazyColumn {
                items(foods.size) { index ->
                    val food = foods[index]
                    ItemListAdvance(
                        modifier = Modifier.clickable {
                            onSelectedItem(food)
                        },
                        mainText = food.name,
                        secondaryText = food.description,
                        imgUrl = food.imgUrl,
                        icon = Icons.Default.Warning,
                        overlineText = food.createdBy,
                        showDivider = true,
                    )
                }

            }
        }
    }
}