package net.iessochoa.sergiocontreras.jcadapters.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import net.iessochoa.sergiocontreras.jcadapters.R
import net.iessochoa.sergiocontreras.jcadapters.ui.theme.JCAdaptersTheme
import net.iessochoa.sergiocontreras.jcadapters.ui.theme.Typography

/**
 * Project: JC Adapters
 * From: net.iessochoa.sergiocontreras.jcadapters.ui.components
 * Created by: Contr
 * On: 13/10/2025 at 13:35
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Preview(showBackground = true)
@Composable
private fun BasicPreview() {
    JCAdaptersTheme {
        ItemListBasic(text = "Lorem Ipsum")
    }
}


@Preview(showBackground = true)
@Composable
private fun AdvancedPreview() {
    JCAdaptersTheme {
        ItemListAdvance("MainText", "more text here")
    }
}



@Composable
fun ItemListBasic(
    text: String,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text,
            modifier = modifier
                .fillMaxWidth() //Sin esto es scroll sería solo posible encima del texto... muy raro.
                .padding(vertical = dimensionResource(id = R.dimen.common_padding_default)),
            style = Typography.headlineSmall
        )

        HorizontalDivider()

    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemListAdvance(
    mainText:String,
    secondaryText:String,
    imgUrl: String = ""
) {
    ListItem(
        headlineContent = {
            Text(
                text = mainText,
                style = Typography.headlineMedium
            )
        },
        leadingContent = {
            GlideImage(
                model = imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(dimensionResource(R.dimen.img_item_list))

            )
        }
    )


}

