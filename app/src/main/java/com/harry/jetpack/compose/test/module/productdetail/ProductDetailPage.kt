package com.harry.jetpack.compose.test.module.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.harry.jetpack.compose.test.R
import com.harry.jetpack.compose.test.model.ProductDetailItem
import com.harry.jetpack.compose.test.module.productdetail.component.MakeDescView
import com.harry.jetpack.compose.test.module.productdetail.component.MakeImagePagerView
import com.harry.jetpack.compose.test.module.productdetail.component.MakePickUpLocationView
import com.harry.jetpack.compose.test.module.productdetail.component.MakePriceView
import com.harry.jetpack.compose.test.module.productdetail.component.MakeProductTitleView
import com.harry.jetpack.compose.test.shared.readAssetsFile
import com.harry.jetpack.compose.test.ui.theme.HarryJetpackComposeTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakeProductDetailPage(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Spacer(modifier = Modifier.weight(1.0F))
                        IconButton(onClick = { { /*TODO*/ } }) {
                            Image(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                                contentDescription = "shopping_cart"
                            )
                        }
                        IconButton(onClick = { { /*TODO*/ } }) {
                            Image(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_favorite),
                                contentDescription = "shopping_cart"
                            )
                        }
                        IconButton(onClick = { { /*TODO*/ } }) {
                            Image(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_cart),
                                contentDescription = "shopping_cart"
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            Column(modifier = Modifier.padding(it)) {

                val jsonString = LocalContext.current.assets.readAssetsFile("product_detail.json")
                val productDetailItem = Gson().fromJson(jsonString, ProductDetailItem::class.java)

                MakePickUpLocationView()

                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .weight(1F)
                ) {
                    item { MakeImagePagerView(productDetailItem) }
                    item { MakeProductTitleView(productDetailItem) }
                    item { MakePriceView(productDetailItem) }
                    item {
                        Column(modifier = Modifier.padding(top = 10.dp)) {
                            MakeDescView(
                                title = "商品說明",
                                content = productDetailItem.description
                            )
                            MakeDivider()
                        }
                    }
                    item {
                        Column(modifier = Modifier.padding(top = 10.dp)) {
                            MakeDescView(
                                title = "內容量",
                                content = productDetailItem.netContent
                            )
                            MakeDivider()
                        }
                    }
                    item {
                        Column(modifier = Modifier.padding(top = 10.dp)) {
                            MakeDescView(
                                title = "成分/原材料",
                                content = productDetailItem.ingredient
                            )
                        }
                    }
                }

                MakeAmountView()
            }
        }
    )
}

@Composable
private fun MakeAmountView() {
    val amountLimit = 100
    var currentAmount by remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Remove,
            contentDescription = null,
            tint = if (currentAmount <= 0) Color.LightGray else colorResource(id = R.color.pink),
            modifier = Modifier.clickable(enabled = (currentAmount > 0)) {
                currentAmount -= 1
            }
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .background(
                    color = colorResource(id = R.color.grey),
                    shape = RoundedCornerShape(2.dp)
                )
                .defaultMinSize(minWidth = 40.dp, minHeight = 40.dp)
        ) {
            Text(
                text = "$currentAmount",
                textAlign = TextAlign.Center,
            )
        }

        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            tint = if (currentAmount >= amountLimit) Color.LightGray else colorResource(id = R.color.pink),
            modifier = Modifier
                .padding(end = 20.dp)
                .clickable(enabled = (currentAmount < amountLimit)) {
                    currentAmount += 1
                }
        )

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.pink),
                contentColor = Color.White,
                disabledContainerColor = colorResource(R.color.button_disable_pink),
                disabledContentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp)
                .height(50.dp)
            ,
            onClick = {}
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_cart),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(20.dp)
                )
                Text(
                    text = "加入購物車",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailPageAmountViewPreview() {
    HarryJetpackComposeTestTheme {
        MakeAmountView()
    }
}

@Composable
private fun MakeDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
        ,
        color = Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun ProductDetailPagePreview() {
    HarryJetpackComposeTestTheme {
        MakeProductDetailPage(rememberNavController())
    }
}