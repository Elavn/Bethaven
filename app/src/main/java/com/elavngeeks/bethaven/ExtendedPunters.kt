package com.elavngeeks.bethaven

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elavngeeks.bethaven.ui.theme.interregular
import com.elavngeeks.bethaven.ui.theme.intersbold


@Composable
fun UpSection(){
    Column {
        Row {
            IconButton(onClick = { /*TODO*/ })
            {
                Icon(
                    painter = painterResource(id = R.drawable.backbtn),
                    contentDescription = "",
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
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column {
            Row {
                Icon(
                    painter = painterResource(id = morePunters.displayPic),
                    contentDescription = ""
                )
                Text(
                    text = morePunters.punterName,
                    fontSize = 18.sp,
                    fontFamily = intersbold
                )
            }

            Spacer(
                modifier = Modifier
                    .height(2.dp)
            )

            Text(
                text = morePunters.preferredSports,
                fontSize = 12.sp,
                fontFamily = interregular
            )
        }
    }
}