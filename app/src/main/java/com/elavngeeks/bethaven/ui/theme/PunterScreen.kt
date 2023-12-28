package com.elavngeeks.bethaven.ui.theme

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elavngeeks.bethaven.Punters
import com.elavngeeks.bethaven.R
import com.elavngeeks.bethaven.ui.theme.UI.accentColour
import androidx.compose.ui.graphics.painter.Painter
import com.elavngeeks.bethaven.Screen
import com.elavngeeks.bethaven.ui.theme.UI.ExtraData
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Composable
fun PunterScreen(){

}

@Composable
fun UpSection(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18 .dp)
    ) {
        IconButton(
            onClick = { /*TODO*/ })
        {
            Icon(
                painter = painterResource(id = R.drawable.backbtn),
                contentDescription = null,
                modifier = Modifier
                    .scale(1.5f)
                    .align(Alignment.Start)
            )
        }

        Text(
            text = "Find the Best Expert in Punting for You",
            fontFamily = epiloguebold,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            modifier = Modifier
                .fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = "The best punters from X",
            fontSize = 18.sp,
            fontFamily = epiloguesbold
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(
                text = "Most Popular",
                fontFamily = epiloguesbold,
                fontSize = 22.sp,
            )

            Text(
                text = "See all",
                fontFamily = epiloguesbold,
                fontSize = 16.sp,
                color = accentColour
            )
        }
    }
}



@Composable
fun PunterRow(punter: Punters, isFocused: Boolean){
    val imageSize = if (isFocused) 230.dp else 170.dp

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(start = 12.dp, end = 10.dp),

    ) {
            Column(
                verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 20.dp)
        ) {

            Icon(painter = painterResource(id = punter.punterPics),
                contentDescription = punter.punterName,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .clip(CircleShape)
                    .size(imageSize)

            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = punter.punterName,
                    fontFamily = interbold,
                    fontSize = 32.sp,
                )

                Text(
                    text = punter.punterNick,
                    fontFamily = intersbold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
        }
    }
}

@Composable
fun PuntingScreen(){
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(0.5f)
    ){

    }
}

@Composable
fun PunterRows() {
    val puntersList = listOf(
        Punters(R.drawable.talented, "Talented🏀🏀", "@TalentedFBG"),
        Punters(R.drawable.adab, "Ada B💕", "@Ada_Daddyya"),
        Punters(R.drawable.mayor, "Mayor of Ekiti", "@Ekitipikin"),
        Punters(R.drawable.fernandes, "Daddy Fernandes", "@Kingkuti_"),
        Punters(R.drawable.emmanueloc, "Emmanuel O.C", "@Emmanuel_Tips"),
        Punters(R.drawable.woozzaa, "Woozzaa", "@woozzaabets")
    )

    val lazyRowState = rememberLazyListState()
    val focusedIndex = remember { mutableStateOf(0) }

    LazyRow(
        state = lazyRowState
    ) {
        itemsIndexed(puntersList) { index, punter ->
            val isFocused = focusedIndex.value == index

            PunterRow(punter = punter, isFocused = isFocused)

            if (isFocused) {
                LaunchedEffect(Unit) {
                    val scrollPosition = index * 215
                    lazyRowState.scrollToItem(
                        index,

                    )
                }
            }
        }
    }

    // Observing the scroll position and updating the focusedIndex
    LaunchedEffect(key1 = lazyRowState) {
        snapshotFlow { lazyRowState.firstVisibleItemIndex }
            .collect { visibleIndex ->
                focusedIndex.value = visibleIndex
            }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PunterScreenPreview() {
    Column {
        UpSection()
        PunterRows()
    }
}
