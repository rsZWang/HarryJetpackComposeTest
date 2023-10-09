package com.harry.jetpack.compose.test.module.productdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harry.jetpack.compose.test.R
import com.harry.jetpack.compose.test.model.ProductDetailItem

@Composable
fun MakePriceView(productDetailItem: ProductDetailItem) {
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Text(
            text = "NT$ 427",
            fontSize = 12.sp,
            color = Color.LightGray,
            style = TextStyle(
                textDecoration = TextDecoration.LineThrough
            )
        )
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "NT$ 1494.67",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.pink),
                style = TextStyle(
                    textDecoration = TextDecoration.LineThrough
                )
            )
            Text(
                text = "JPY ${productDetailItem.price}",
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 6.dp, bottom = 2.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "免稅價格",
                fontSize = 12.sp,
                color = Color.Black
            )
            Icon(
                modifier = Modifier.size(14.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_info),
                contentDescription = null
            )
        }

        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .padding(end = 3.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_cart),
                contentDescription = null
            )
            Text(
                text = "每筆訂單限購100件",
                fontSize = 12.sp,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black
            )
        }
        Row(
            modifier = Modifier.padding(top = 2.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .padding(end = 3.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_history),
                contentDescription = null
            )
            Text(
                text = "8小時27分鐘 前訂購，最快可於 2023/04/17 13:00:00 取貨。（JR成田機場站）",
                fontSize = 12.sp,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black
            )
        }

        Row(modifier = Modifier.padding(top = 6.dp, bottom = 10.dp)) {
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = "選擇取貨機場",
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.pink)
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
            ,
            color = Color.LightGray
        )
    }
}