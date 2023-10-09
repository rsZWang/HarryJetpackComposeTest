package com.harry.jetpack.compose.test.module.productdetail.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.harry.jetpack.compose.test.model.ProductDetailItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MakeImagePagerView(productDetailItem: ProductDetailItem) {

    val pageSize = productDetailItem.images.size
    val dummyPageCount = Int.MAX_VALUE
    val pagerState = rememberPagerState(
        initialPage = (dummyPageCount / pageSize / 2) * pageSize
    ) { dummyPageCount }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1F)
        ) { dummyIndex ->
            AsyncImage(
                model = productDetailItem.images[dummyIndex % pageSize],
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            repeat(pageSize) { index ->
                val currentDummyIndex = pagerState.currentPage
                val currentIndex = currentDummyIndex % pageSize
                val color = if (currentIndex == index) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .background(shape = CircleShape, color = color)
                        .size(10.dp)
                )
            }
        }
    }
}