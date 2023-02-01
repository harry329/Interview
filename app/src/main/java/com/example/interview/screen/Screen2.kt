package com.example.interview.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.interview.vm.Screen2VM
import org.koin.androidx.compose.koinViewModel

@Composable
fun screen2(goToScreen1: () -> Unit = {}, vm : Screen2VM = koinViewModel()) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val dogState = vm.dogState.collectAsState()
        val screenSize = LocalConfiguration.current
        Text("Screen 2")
        if ( screenSize.screenWidthDp.dp >= 400.dp) {
            Row {
                ImageView(vm)
            }
        } else {
            ImageView(vm)
        }
        Button(onClick = goToScreen1) {
            Text("Go Back")
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (dogState.value.isEmpty()) {
            Text("We don't have data to show")
        } else {
            AsyncImage(model = dogState.value.get(0).message,
                 modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
            contentDescription = "Dog Image")
        }
    }
}

@Composable
private fun ImageView(vm: Screen2VM) {
    Button(onClick = { vm.fetchDogInfo() }) {
        Text("Fetch Image")
    }
    Button(onClick = { vm.stopFetchingDogInfo() }) {
        Text("Stop Fetching")
    }
}