package com.elavngeeks.bethaven

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elavngeeks.bethaven.ui.theme.BottomNavigation
import com.elavngeeks.bethaven.ui.theme.CardsItem
import com.elavngeeks.bethaven.ui.theme.Otherbookies
import com.elavngeeks.bethaven.ui.theme.UI.ExtraData
import com.elavngeeks.bethaven.ui.theme.UI.NavbarContents
import com.elavngeeks.bethaven.ui.theme.UI.Punterexclusives
import com.elavngeeks.bethaven.ui.theme.UI.backgroundColour
import com.elavngeeks.bethaven.ui.theme.UI.betkingColor
import com.elavngeeks.bethaven.ui.theme.UI.gradientLightblue
import com.elavngeeks.bethaven.ui.theme.UI.gradientblue
import com.elavngeeks.bethaven.ui.theme.epiloguebold
import com.elavngeeks.bethaven.ui.theme.epilogueregular
import com.elavngeeks.bethaven.ui.theme.epiloguesbold
import com.elavngeeks.bethaven.ui.theme.interbold
import com.elavngeeks.bethaven.ui.theme.interregular
import java.lang.Math.PI
import java.lang.Math.sqrt
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun ExclusiveScreen() {
    Box(modifier = Modifier
        .background(color = backgroundColour)
        .fillMaxSize()
    ) {
        Column {
            HeadingSection()
            Screen()
        }
        BottomNavigation(items = listOf(
            NavbarContents(R.drawable.home, "Home"),
            NavbarContents(R.drawable.exclusives, "Exclusives"),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Screen(){
    Column(
        modifier = Modifier
            .padding(bottom = 100.dp)
        .verticalScroll(rememberScrollState())) {

        ExclusiveCards()
        HeadingTwo()
        extraCards()

    }
}


@Composable
fun HeadingSection() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(18.dp)
            .fillMaxWidth(0.8f)
    ) {
        Text(
            text = "Hey, Punter!",
            fontFamily = epiloguesbold,
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = "A bit of more exciting contents for your perusal",
            fontFamily = epilogueregular,
            fontSize = 18.sp
        )
    }
}

private fun Modifier.gradientBackground(colors: List<Color>, angle: Float) = this.then(
    Modifier.drawBehind {

        // Setting the angle in radians
        val angleRad = angle / 180f * PI

        // Fractional x
        val x = kotlin.math.cos(angleRad).toFloat()

        // Fractional y
        val y = kotlin.math.sin(angleRad).toFloat()

        // Set the Radius and offset as shown below
        val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
        val offset = center + Offset(x * radius, y * radius)

        // Setting the exact offset
        val exactOffset = Offset(
            x = kotlin.math.min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - kotlin.math.min(offset.y.coerceAtLeast(0f), size.height)
        )

        // Draw a rectangle with the above values
        drawRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset
            ),
            size = size
        )
    }
)

@Composable
fun ExclusiveCard(features: Punterexclusives) {
    Box(
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, top = 5.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(22.dp))
            .height(160.dp)
            .fillMaxWidth()
            .gradientBackground(listOf(gradientblue, gradientLightblue), angle = -75f)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, start = 15.dp)
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth(0.55f)
            ) {
                Text(
                    text = features.maintext,
                    fontFamily = interbold,
                    fontSize = 18.sp,
                    color = Color.White,
                    lineHeight = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = features.textbody,
                    fontFamily = interregular,
                    fontSize = 16.sp,
                    color = Color.White,
                    lineHeight = 15.sp
                )
            }

            Icon(
                painter = painterResource(id = features.freepik),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

 @Composable
 fun ExclusiveCards(
 ){
     val firstcard = Punterexclusives(
         R.drawable.money,
         "Gamble Responsibly",
         "Find out how best to punt without being mudded by your favorite bookies.")

     val secondcard = Punterexclusives(
         R.drawable.celebratingman,
         "Expert Picks",
         "Reduce sapa-risk by betting on more reliable options from serial winners."
     )

     Column {
         ExclusiveCard(features = firstcard)
         ExclusiveCard(features = secondcard)
     }
 }

@Composable
fun HeadingTwo() {
    Text(
        modifier = Modifier
            .padding(start = 18.dp, top = 10.dp),
        text = "Extras",
        fontSize = 22.sp,
        fontFamily = epiloguebold,
    )
}

@Composable
fun extraCard(extraData: ExtraData){
    Box(
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, top = 10.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(color = Color.White)
            .height(83.dp)
            .fillMaxWidth()
            .shadow(elevation = 0.5.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = extraData.extraImg),
                contentDescription = extraData.extraName,
                tint = Color.Unspecified,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.2f)
                    .padding(start = 10.dp, end = 20.dp)

            )
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = extraData.extraName,
                    fontFamily = interregular,
                    fontSize = 20.sp,
                )

                Text(
                    text = extraData.extraDesc,
                    fontFamily = interregular,
                    fontSize = 14.sp,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }
        }
    }
}

@Composable
fun extraCards(){

    val card1 = ExtraData(
        R.drawable.flashscore,
        "FlashScore",
        "Sports live fixtures, scores, etc."
    )
    val card2 = ExtraData(
        R.drawable.sofascore,
        "SofaScore",
        "Sports live fixtures, scores, etc."
    )
    val card3 = ExtraData(
        R.drawable.statarea,
        "FlashScore",
        "Sports prediction and stats."
    )
    val card4 = ExtraData(
        R.drawable.forebet,
        "Forebet",
        "Predictions, mathematical analysis."
    )

    Column{
        extraCard(extraData = card1)
        extraCard(extraData = card2)
        extraCard(extraData = card3)
        extraCard(extraData = card4)

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ExclusivePreview(
){
    Column {
        HeadingSection()
        ExclusiveCards()
        HeadingTwo()
        extraCards()
    }
}