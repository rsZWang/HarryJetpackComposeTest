package com.harry.jetpack.compose.test.module.productdetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harry.jetpack.compose.test.R
import com.harry.jetpack.compose.test.model.ProductDetailItem

@Composable
fun MakeProductTitleView(productDetailItem: ProductDetailItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Row {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_sell),
                    contentDescription = null
                )
                Text(
                    text = "資生堂",
                    color = colorResource(id = R.color.pink),
                    modifier = Modifier.padding(start = 6.dp)
                )
            }
            Text(
                text = productDetailItem.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1F))

        Box(modifier = Modifier
            .background(colorResource(id = R.color.grey), shape = CircleShape)
            .padding(8.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_share),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .background(colorResource(id = R.color.grey), shape = CircleShape)
                .padding(8.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_favorite),
                contentDescription = null
            )
        }
    }
}