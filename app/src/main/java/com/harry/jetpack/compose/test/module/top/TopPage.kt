package com.harry.jetpack.compose.test.module.top

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.harry.jetpack.compose.test.R
import com.harry.jetpack.compose.test.Routes

@Composable
fun MakeTopPage(navController: NavController) {

    @Composable
    fun makeButtonStyle(): ButtonColors {
        return ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.pink),
            contentColor = Color.White,
            disabledContainerColor = colorResource(R.color.button_disable_pink),
            disabledContentColor = Color.White
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            colors = makeButtonStyle(),
            onClick = {
                navController.navigate(route = Routes.AirportList.route)
            }
        ) {
            Text(text = "空港リスト")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            colors = makeButtonStyle(),
            onClick = {
                navController.navigate(Routes.ProductDetail.route)
            }
        ) {
            Text(text = "商品詳細")
        }
    }
}