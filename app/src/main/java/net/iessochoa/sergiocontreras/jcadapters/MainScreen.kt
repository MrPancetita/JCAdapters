package net.iessochoa.sergiocontreras.jcadapters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.jcadapters.ui.components.ItemListAdvance
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
            .padding(top=24.dp))
    }
}



@Composable
fun MainView(modifier: Modifier) {
    val countries = listOf("Spain", "France", "Germany", "Italy", "United Kingdom")
    val friends = listOf("Sergio", "Javier", "Pablo", "Sara", "Daniel", "Natalia")
    val foods = getAllFoods()

    Column(modifier = modifier.padding(dimensionResource(R.dimen.common_padding_default))) {
        SpinnerPan(
            Modifier
                .fillMaxWidth(),
            label = "Country",
            items = countries
        )

//        Text(text = "Amigos: ",
//        modifier = Modifier.padding(top=dimensionResource(R.dimen.common_padding_default)))
//        Column(Modifier.verticalScroll(rememberScrollState())) {
//            friends.forEach { friend ->
//                ItemListBasic(friend)
//            }
//
//        }

        Text(text = "Comidas: ",
        modifier = Modifier.padding(top=dimensionResource(R.dimen.common_padding_default)))
        LazyColumn {
            items(foods.size) { index ->
                val food = foods[index]
                ItemListAdvance(
                    mainText = food.name,
                    secondaryText = food.description,
                    imgUrl = food.imgUrl
                )
            }

        }
    }
}