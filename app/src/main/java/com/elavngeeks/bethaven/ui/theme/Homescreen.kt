package com.elavngeeks.bethaven.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elavngeeks.bethaven.R
import com.elavngeeks.bethaven.ui.theme.UI.backgroundColour
import com.elavngeeks.bethaven.ui.theme.UI.bet9jaColor
import com.elavngeeks.bethaven.ui.theme.UI.betkingColor
import com.elavngeeks.bethaven.ui.theme.UI.onexbetColor
import com.elavngeeks.bethaven.ui.theme.UI.sportybetColor
import com.elavngeeks.bethaven.ui.theme.UI.textColour2

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .background(color = backgroundColour)
        .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            BetCards(
                betCards = listOf(
                    Bettingcards(
                        cardbg = bet9jaColor,
                        R.drawable.bet9jalogo,
                        "bet9ja.com",
                        "Nigeria’s number one betting website"
                    ),
                    Bettingcards(
                        cardbg = betkingColor,
                        R.drawable.betkinglogo,
                        "betking.com",
                        "The playground for Kings"
                    ),
                    Bettingcards(
                        cardbg = sportybetColor,
                        R.drawable.sportybetlogo,
                        "sportybet.com",
                        "Nigeria’s number one betting website"
                    ),
                    Bettingcards(
                        cardbg = onexbetColor,
                        R.drawable.onexbetlogo,
                        "1xbet.com",
                        "Nigeria’s number one betting website"
                    ),
                )
            )
            MoreBookies(
                features = listOf(
                    Otherbookies(
                        R.drawable.paripesa,
                        "Paripesa"
                    ),
                    Otherbookies(
                        R.drawable.bcgame,
                        "Bc.game"
                    ),
                    Otherbookies(
                        R.drawable.betwinner,
                        "Betwinner"
                    ),
                    Otherbookies(
                        R.drawable.twentytwobet,
                        "22Bet"
                    ),
                    Otherbookies(
                        R.drawable.parimatch,
                        "Parimatch"
                    ),
                    Otherbookies(
                        R.drawable.frapapa,
                        "Frapapa"
                    ),
                    Otherbookies(
                        R.drawable.betano,
                        "Betano"
                    ),
                    Otherbookies(
                        R.drawable.betway,
                        "Betway"
                    ),
                    Otherbookies(
                        R.drawable.zebet,
                        "Zebet"
                    )
                )
            )

        }
    }
}

@Composable
fun GreetingSection(){
    Box(
    ) {
        Text(
            text = "Welcome!",
            fontSize = 28.sp,
            fontFamily = epilogueregular,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = textColour2

        )
    }
}

@Composable
fun BetCards(betCards: List<Bettingcards>) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
    ) {
        Text(
            text = "Your favorite bookies",
            fontSize = 18.sp,
            fontFamily = intersbold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 3.dp, start = 14.dp),
            color = textColour2
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp, start = 7.dp,)

        ) {
            items(
                betCards.size){
                    CardsItem(cardsitem = betCards[it])
                }
        }

    }
}

@Composable
fun CardsItem(
    cardsitem: Bettingcards
) {
    Box(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(25.dp))
            .width(260.dp)
            .height(360.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .background(cardsitem.cardbg)
        ) {
            Icon(
                painter = painterResource(id = cardsitem.iconId),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(top = 15.dp)
            )

            Text(
                text = cardsitem.bookielink,
                fontSize = 28.sp,
                color = backgroundColour,
                fontFamily = interregular,
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp)
            )

            Text(
                text = cardsitem.bookietag,
                fontSize = 20.sp,
                color = backgroundColour,
                textAlign = TextAlign.Center,
                fontFamily = interregular,
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp),
            )

            Box(
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ){
                Row(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(15.dp))
                        .padding(horizontal = 15.dp)
                ) {
                    Text(
                        text = "OPEN",
                        fontFamily = interregular,
                        fontSize = 22.sp,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.internet),
                        contentDescription = "",
                        modifier = Modifier
                            .size(29.dp)
                            .padding(top = 7.dp, start = 6.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MoreBookies(features: List<Otherbookies>) {
    Column(
        modifier = Modifier
            .padding(top = 18.dp)
    ) {
        Text(
            text = "More available bookies",
            fontSize = 18.sp,
            fontFamily = intersbold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, start = 14.dp),
            color = textColour2
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 10.dp),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxHeight()
                .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 25.dp))
        ) {
            items(features.size) {
                BookiesItem(bookiesitem = features[it])
            }
        }
    }
}

@Composable
fun BookiesItem(bookiesitem: Otherbookies) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(7.5.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = bookiesitem.otherIcon),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(bottom = 8.dp, top = 10.dp)
            )

            Text(
                text = bookiesitem.betNames,
                fontFamily = interregular,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}


val interbold = FontFamily(Font(R.font.interbold))
val interregular = FontFamily(Font(R.font.interregular))
val intersbold = FontFamily(Font(R.font.intersemibold))
val epiloguebold = FontFamily(Font(R.font.epiloguebold))
val epilogueregular = FontFamily(Font(R.font.epilogueregular))
val epiloguesbold = FontFamily(Font(R.font.epiloguesemibold))