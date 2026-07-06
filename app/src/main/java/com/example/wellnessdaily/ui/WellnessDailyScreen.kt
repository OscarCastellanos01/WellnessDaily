package com.example.wellnessdaily.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellnessdaily.R
import com.example.wellnessdaily.data.DataSource
import com.example.wellnessdaily.model.WellnessDay
import com.example.wellnessdaily.ui.theme.WellnessDailyTheme

@Composable
fun WellnessDailyApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            WellnessTopAppBar()
        }
    ) { contentPadding ->
        WellnessDailyLayout(
            wellness = DataSource.wellness,
            contentPadding = contentPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier
    )
}

@Composable
fun WellnessDailyLayout(
    wellness: List<WellnessDay>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(wellness) { day ->
            WellnessDayItem(
                day = day,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun WellnessDayItem(
    day: WellnessDay,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable(
            onClick = {}
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(day.wellnessDay),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(day.wellnessTitle),
                style = MaterialTheme.typography.headlineSmall
            )
            Image(
                painter = painterResource(day.wellnessImage),
                contentDescription = stringResource(day.wellnessTitle),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(day.wellnessDescription),
                style = MaterialTheme.typography.bodyMedium
            )
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