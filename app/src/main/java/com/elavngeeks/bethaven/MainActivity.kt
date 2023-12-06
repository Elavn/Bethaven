package com.elavngeeks.bethaven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.elavngeeks.bethaven.ui.theme.HomeScreen
import com.elavngeeks.bethaven.ui.theme.UI.BethavenTheme
import com.elavngeeks.bethaven.ui.theme.UI.Punterexclusives

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BethavenTheme {
                    ResponsibleGamblingScreen()
            }
        }
    }
}
