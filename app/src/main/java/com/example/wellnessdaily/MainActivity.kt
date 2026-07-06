package com.example.wellnessdaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.wellnessdaily.ui.WellnessDailyApp
import com.example.wellnessdaily.ui.theme.WellnessDailyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WellnessDailyTheme {
                WellnessDailyApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessDailyPreview() {
    WellnessDailyTheme {
        WellnessDailyApp()
    }
}