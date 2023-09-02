package com.junrdev.leeters.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.junrdev.leeters.App
import com.junrdev.leeters.R
import com.junrdev.leeters.ui.theme.btn_loading
import com.junrdev.leeters.ui.theme.primary_text_input_bg
import com.junrdev.leeters.ui.theme.text_black

@Composable
@Preview
fun TxFieldPreview() {
    val txt = remember {
        mutableStateOf("")
    }
    App {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTexTField(text = txt)
            PasswordTexTField(text = txt)
            SearchField(searchtext = txt, placehlder = "Enter search text") {

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTexTField(
    text: MutableState<String>,
    placehlder: String = "Placeholder",
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp)
            .clip(shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {

        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = primary_text_input_bg,
                textColor = text_black,
                placeholderColor = btn_loading,
                focusedIndicatorColor = primary_text_input_bg,
                unfocusedIndicatorColor = primary_text_input_bg
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = { Text(text = placehlder) },
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTexTField(
    text: MutableState<String>,
    placehlder: String = "password",
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier = Modifier
) {

    val hidepassword = remember {
        mutableStateOf(true)
    }

    val trailing = when (hidepassword.value) {
        true -> R.drawable.round_visibility_24
        else -> R.drawable.round_visibility_off_24
    }

    val description = when (hidepassword.value) {
        true -> "Show password"
        else -> "Hide password"
    }

    val transformation = when (hidepassword.value) {
        true -> PasswordVisualTransformation()
        else -> VisualTransformation.None
    }


    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 12.dp)
            .clip(shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {

        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = primary_text_input_bg,
                textColor = text_black,
                placeholderColor = btn_loading,
                focusedIndicatorColor = primary_text_input_bg,
                unfocusedIndicatorColor = primary_text_input_bg
            ),
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = { Text(text = placehlder) },
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            maxLines = 1,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = trailing),
                    contentDescription = description,
                    modifier = Modifier.clickable { hidepassword.value = !hidepassword.value })
            },
            visualTransformation = transformation
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    searchtext: MutableState<String>,
    placehlder: String = "search",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    showFilters: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 12.dp)
            .clip(shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {

        TextField(
            value = searchtext.value,
            onValueChange = { searchtext.value = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = primary_text_input_bg,
                textColor = text_black,
                placeholderColor = btn_loading,
                focusedIndicatorColor = primary_text_input_bg,
                unfocusedIndicatorColor = primary_text_input_bg
            ),
            placeholder = { Text(text = placehlder) },
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = "Filters",
                    modifier = Modifier.clickable { showFilters() })
            },
            trailingIcon = {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "search")
            },
            modifier = modifier
                .fillMaxWidth(),
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )
    }
}
