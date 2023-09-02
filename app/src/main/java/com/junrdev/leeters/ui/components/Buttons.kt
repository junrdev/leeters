package com.junrdev.leeters.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.junrdev.leeters.App
import com.junrdev.leeters.ui.theme.btn_primary
import com.junrdev.leeters.ui.theme.screen_white_1

@Composable
@Preview
fun Previews() {
    App {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SmallIconButton()
        }
    }
}

@Composable
fun SmallIconButton(btnText: String = "Text") {

    val isClicked = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .background(color = btn_primary, shape = MaterialTheme.shapes.small)
            .clickable { isClicked.value = !isClicked.value },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isClicked.value) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
//                    .padding(7.dp)
                    .padding(horizontal = 8.dp, vertical = 5.dp),
                color = screen_white_1
            )
        } else
            Text(
                text = btnText,
                modifier = Modifier
                    .padding(7.dp)
                    .padding(horizontal = 8.dp),
                style = TextStyle(color = screen_white_1)
            )
    }
}