package com.basemibrahim.composeexample

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val repository = Repository()

@Composable
fun Home(context: Context) {
    ScaffoldWithBottomMenu(context)


}

@Preview
@Composable
fun CustomAppBar() {

    Card(
        elevation = 1.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = stringResource(R.string.logo_icon_disc),
                modifier = Modifier
                    .width(59.dp)
                    .height(14.58.dp)
            )

            Spacer(modifier = Modifier.width(158.dp))
            Image(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = stringResource(R.string.logo_icon_disc),
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp)
                    .clickable { }
            )

            Spacer(modifier = Modifier.width(28.dp))
            Image(
                painter = painterResource(R.drawable.ic_notificationpic),
                contentDescription = stringResource(R.string.logo_icon_disc),
                modifier = Modifier
                    .width(16.dp)
                    .height(19.5.dp)
                    .clickable { }
            )
            Spacer(modifier = Modifier.width(28.dp))
            Image(
                painter = painterResource(R.drawable.ic_cart),
                contentDescription = stringResource(R.string.logo_icon_disc),
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .clickable { }
            )

        }
    }
}

@Preview
@Composable
fun ShareExperience() {
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(0.dp)

    ) {

        Row(
            Modifier
                .fillMaxWidth()

                .padding(horizontal = 16.dp, vertical = 13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = stringResource(R.string.logo_icon_disc),
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)

            )

            Spacer(modifier = Modifier.width(12.dp))
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                textStyle = MaterialTheme.typography.h2,
                onValueChange = { text = it },
                placeholder = { Text(stringResource(R.string.Share_experience)) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.white),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    placeholderColor = colorResource(id = R.color.TextFieldPlacHolderColor)
                ),
                modifier = Modifier
                    .shadow(2.dp, RoundedCornerShape(40.dp))
                    .height(52.dp)
                    .padding(vertical = 0.dp)


            )


        }
    }
}

@Composable
fun showData(context: Context) {

    val personsList = repository.getData(context)
    LazyColumn() {
        items(items = personsList) { person ->
            CustomItem(person = person, context)
        }
    }
}


@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp, backgroundColor =
        colorResource(id = R.color.white)
    ) {

        BottomNavigationItem(icon = {
            Image(
                painter = painterResource(id = R.drawable.oval),
                "",
                modifier = Modifier.size(40.dp)
            )
        },

            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Image(
                painter = painterResource(id = R.drawable.ic_fork), "",
                modifier = Modifier
                    .width(15.dp)
                    .height(18.dp)
            )
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Image(
                painter = painterResource(id = R.drawable.ic_percent), "",
                modifier = Modifier
                    .width(18.dp)
                    .height(19.dp)
            )
        },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })


        BottomNavigationItem(icon = {
            Image(
                painter = painterResource(id = R.drawable.ic_people), "",
                modifier = Modifier
                    .width(25.dp)
                    .height(16.dp)
            )
        },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
            })

        BottomNavigationItem(icon = {
            Image(
                painter = painterResource(id = R.drawable.ic_person), "",
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
            })
    }
}

@Composable
fun ScaffoldWithBottomMenu(context: Context) {
    Scaffold(bottomBar = { BottomBar() }
    ) {

//        //content area
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.HomeBackgroundColor))
                .fillMaxSize()
                .padding(it)
        ) {
            Column {

                CustomAppBar()
                Spacer(modifier = Modifier.height(3.dp))
                ShareExperience()
                Spacer(modifier = Modifier.height(3.dp))
                showData(context = context)

            }

        }

    }
}