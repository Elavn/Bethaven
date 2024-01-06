package com.elavngeeks.bethaven

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elavngeeks.bethaven.ui.theme.interregular
import com.elavngeeks.bethaven.ui.theme.intersbold


@Composable
fun TopmostSection(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            IconButton(onClick = { /*TODO*/ })
            {
                Icon(
                    painter = painterResource(id = R.drawable.backbtn),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Text(
                text = "Your best punters from X",
                fontFamily = interregular,
                fontSize = 18.sp,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PunterCards(morePunters: MorePunters) {
    Card(
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 20.dp),
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 25.dp)
            ) {
                Icon(
                    painter = painterResource(id = morePunters.displayPic),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)

                )
                Text(
                    text = morePunters.punterName,
                    fontSize = 17.sp,
                    fontFamily = intersbold,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .background(Color.Black)
            )

            Divider(
                thickness = 2.dp,
                color = Color.Black.copy(alpha = 0.3f),
                modifier = Modifier
                    .padding(bottom = 8.dp, start = 26.dp, end = 26.dp)
            )

            Text(
                text = morePunters.preferredSports,
                fontSize = 16.sp,
                fontFamily = interregular,
                modifier = Modifier
                    .padding(start = 28.dp)

            )
        }
    }
}

@Composable
fun ExtPunters() {

    val firstPunter = MorePunters(R.drawable.talented, "Talented🏀🏀", "Preferred Sports: Basketball")
    val thirdPunter = MorePunters(R.drawable.adab, "Ada B💕💕", "Preferred Sports: Football")
    val fourthPunter = MorePunters(R.drawable.mayor, "Mayor of Ekiti", "Preferred Sports: Multi-Sports")
    val fifthPunter = MorePunters(R.drawable.fernandes, "👑Daddy Fernandes👑", "Preferred Sports: Football")
    val sixthPunter = MorePunters(R.drawable.emmanueloc, "Emmanuel O.C.", "Preferred Sports: Football")
    val seventhPunter = MorePunters(R.drawable.woozzaa, "Woozzaa", "Preferred Sports: Football")
    val eighthPunter = MorePunters(R.drawable.male, "Moore Tips", "Preferred Sports: Football")
    val ninthPunter = MorePunters(R.drawable.elavn111, "Elavn11", "Preferred Sports: Football")
    val tenthPunter = MorePunters(R.drawable.male, "Ms.Amber", "Preferred Sports: Football")
    val eleventhPunter =MorePunters(R.drawable.male, "Mr. Bayo", "Preferred Sports: Football")
    val twelfthPunter =MorePunters(R.drawable.male, "Most Wanted Punter", "Preferred Sports: Football")
    val thirteenthPunter =MorePunters(R.drawable.male, "Grand Audit Chaser☘️", "Preferred Sports: Football")

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        PunterCards(morePunters = firstPunter)
        PunterCards(morePunters = thirdPunter)
        PunterCards(morePunters = fourthPunter)
        PunterCards(morePunters = fifthPunter)
        PunterCards(morePunters = sixthPunter)
        PunterCards(morePunters = seventhPunter)
        PunterCards(morePunters = eighthPunter)
        PunterCards(morePunters = ninthPunter)
        PunterCards(morePunters = tenthPunter)
        PunterCards(morePunters = eleventhPunter)
        PunterCards(morePunters = twelfthPunter)
        PunterCards(morePunters = thirteenthPunter)
    }
}