package com.harry.jetpack.compose.test.module

import android.content.res.AssetManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.harry.jetpack.compose.test.R
import com.harry.jetpack.compose.test.model.AirportList
import com.harry.jetpack.compose.test.ui.theme.HarryJetpackComposeTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakeAirportListPage(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "SIM卡的領取方法",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = colorResource(id = R.color.grey))
            )
        },
        containerColor = colorResource(id = R.color.grey),
        content = { padding ->

            val listString = LocalContext.current.assets.readAssetsFile("airport_list.json")
            val list = Gson().fromJson(listString, AirportList::class.java)
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(2.dp)
                    )
            ) {
                itemsIndexed(list.airports) { index, airport ->
                    Column {
                        Row(modifier = Modifier.padding(
                            horizontal = 14.dp,
                            vertical = 11.dp
                        )) {
                            Text(text = airport.name)
                            Spacer(modifier = Modifier.weight(1.0F))
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowRight,
                                contentDescription = "Next",
                                tint = Color.LightGray
                            )
                        }
                        if (index != list.airports.size-1) {
                            Divider(
                                modifier = Modifier.height(0.7.dp),
                                color = Color.LightGray
                            )
                        }
                    }
                }
            }
        }
    )
}

fun AssetManager.readAssetsFile(fileName: String): String = open(fileName).bufferedReader().use { it.readText() }

@Preview(showBackground = true)
@Composable
fun AirportListPagePreview() {
    HarryJetpackComposeTestTheme {
        MakeAirportListPage(rememberNavController())
    }
}