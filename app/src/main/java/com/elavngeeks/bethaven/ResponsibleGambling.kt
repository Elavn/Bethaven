package com.elavngeeks.bethaven

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elavngeeks.bethaven.ui.theme.UI.backgroundColour
import com.elavngeeks.bethaven.ui.theme.epiloguebold
import com.elavngeeks.bethaven.ui.theme.interbold
import com.elavngeeks.bethaven.ui.theme.interregular
import com.elavngeeks.bethaven.ui.theme.intersbold

@Composable
fun ResponsibleGamblingScreen(){
    Box(
        modifier = Modifier
            .background(backgroundColour)
            .fillMaxSize()
    ) {
        Column {
            TopSection()
            ScrollSection()
        }
    }
}

//To make the Screen scrollable
@Composable
fun ScrollSection() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(154.dp)
                .padding(start = 18.dp, end = 18.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.responsibleimg),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxSize()
            )
        }

        Spacer(
            modifier = Modifier
                .padding(15.dp)
        )
        AllCards()
    }
}


@Composable
fun TopSection(){
    Column(
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, top = 18.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.backbtn),
            contentDescription = "Go back",
            tint = Color.Black,
            modifier = Modifier
                .align(Alignment.Start)
                .scale(1.2f)
                .padding(bottom = 8.dp)
        )

        //A double styled text
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp),
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = epiloguebold
                    )
                ){
                    append("Learn the ethics of\n")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontFamily = epiloguebold
                    )
                ){
                    append("Responsible Gambling")
                }
            }
        )
    }
}

@Composable
fun DropDowns(
    title: String,
    @DrawableRes arrow: Int,
    details: String,
) {
    var expanded by remember { mutableStateOf(false) }

    val iconRotation by animateFloatAsState(
            targetValue = if (expanded) 180f else 0f, label = ""
    )

    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .padding(horizontal = 18.dp, vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                fontFamily = intersbold,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            )

            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(
                    painter = painterResource(id = arrow),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .rotate(iconRotation)
                        .scale(1.5f)
                )
            }
        }

        AnimatedVisibility(
            visible = expanded
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(color = Color.Black.copy(0.2f))
                )

                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    text = details,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = interregular
                )
            }
        }
    }
}

@Composable
fun AllCards() {

    val cardOne = DropDowns(
        title = "Money Explained: Gambling",
        arrow = R.drawable.dropdown,
        details = "Through personal stories and expert insights, 'Money, Explained' underscores the significance of understanding the odds before engaging in any form of gambling. Viewers are reminded that responsible gambling involves knowing when to stop. Ultimately, 'Money, Explained' reinforces the idea that responsible gambling is about enjoying the experience while safeguarding one's financial well-being."
    )

    val cardTwo = DropDowns(
        title = "Not a get-rich-quick Scheme",
        arrow = R.drawable.dropdown,
        details = "I'd like to address a common misconception surrounding gambling. It's often seen as a potential shortcut to quick riches, but in reality, it's far from that.\n" +
                "Gambling is primarily a game of chance. While some may experience short-term wins, we must remember that it's a form of entertainment with uncertain outcomes. The allure of instant wealth can be misleading and, more often than not, leads to financial losses.\n" +
                "The idea of getting rich quickly through gambling is a myth fueled by unrealistic expectations. Instead, it should be seen as a recreational activity with risks that must be approached with caution."
    )

    val cardThree = DropDowns(
        title = "Strictly for Leisure",
        arrow = R.drawable.dropdown,
        details = "While some may view it as a way to make quick money, it's essential to understand that gambling's primary purpose is entertainment.\n" +
                "Gambling is meant for leisure, not wealth. It's essential to view it as entertainment, not a way to make quick money. Remember, the odds are often against you.\n" +
                "Instead, consider stable financial planning and investments for building your wealth.\n" +
                "In summary, always keep in mind that gambling should be for leisure and entertainment purposes only. Approach it responsibly, set limits, and prioritize your financial well-being."
    )

    val cardFour = DropDowns(
        title = "Suitable with spare money",
        arrow = R.drawable.dropdown,
        details = "Gambling should always be done with spare money. It's crucial to view it as a form of entertainment that you can afford, not as a means to make substantial gains.\n" +
                "When you gamble with disposable income, you can enjoy the experience without risking your financial stability. Spare money, in this context, means funds that you can comfortably part with without affecting your essential expenses and savings.\n" +
                "In summary, remember that gambling is suitable with spare money—money you can afford to lose without consequences. This approach ensures a responsible and enjoyable gambling experience."
    )

    val cardFive = DropDowns(
        title = "It's only 5% chance",
        arrow = R.drawable.dropdown,
        details = "In the world of gambling, understanding the odds is paramount. When you encounter a situation with such a low probability of winning, it's essential to acknowledge the rarity of success. While it's not impossible, it's far from guaranteed.\n" +
                "Always approach it with caution and never wager more than you can comfortably afford to lose.\n" +
                "Why is this important? Well, the odds of success being just 5% mean that the likelihood of facing losses is significantly higher. That's why I stress the importance of responsible gambling.\n" +
                "In conclusion, when confronted with a 5% chance scenario in gambling, remember that it's an exceptional circumstance."
    )

    Column {
        cardOne
        cardTwo
        cardThree
        cardFour
        cardFive
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScreenPreview(){
    Column {
        TopSection()
        DropDowns(
            title = "Money Explained: Gambling",
            arrow = R.drawable.dropdown,
            details = "Find out how best to punt without being mudded by your favorite bookies.")
    }
}