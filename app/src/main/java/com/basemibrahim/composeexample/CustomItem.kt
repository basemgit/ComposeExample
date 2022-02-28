package com.basemibrahim.composeexample

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basemibrahim.composeexample.data.Person


@Composable
fun CustomItem(person: Person, context: Context) {
    Card(
        elevation = 1.dp,
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically)
                .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 8.dp)
        ) {

            Column() {


            Row() {

                val resourceId = context.resources.getIdentifier(person.image, "drawable", context.getPackageName());

                Image(
                painter = painterResource(id = resourceId),
                contentDescription = stringResource(R.string.logo_icon_disc),
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)

            )

            Spacer(modifier = Modifier.width(8.dp))

            Column() {
                Text(text = "${person.name}", style = MaterialTheme.typography.h1
                , fontSize = 14.sp
                    , fontWeight = FontWeight.SemiBold
                    , letterSpacing = 0.5.sp
                , color = colorResource(id = R.color.TextFieldPlacHolderColor)
                )
                Text(text = "${person.age}", style = MaterialTheme.typography.h2,
                 fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                    , color = colorResource(id = R.color.TextFieldPlacHolderColor)

                )
            }

                val resourceId2 = context.resources.getIdentifier(person.image_verified, "drawable", context.getPackageName());

                Image(
                    painter = painterResource(id = resourceId2),
                    contentDescription = stringResource(R.string.logo_icon_disc),
                    modifier = Modifier
                        .width(18.dp)
                        .height(18.dp).padding(start = 8.dp)

                )

            }

                Spacer(modifier = Modifier.height(8.dp))

                val resourceId = context.resources.getIdentifier(person.image_big, "drawable", context.getPackageName());

                Image(
                    painter = painterResource(id = resourceId),
                    contentDescription = stringResource(R.string.logo_icon_disc),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp),
                    contentScale = ContentScale.FillBounds

                )


                Spacer(modifier = Modifier.height(12.dp))


                Row() {

                    val resourceId = context.resources.getIdentifier(person.image_tag, "drawable", context.getPackageName());

                    Image(
                        painter = painterResource(id = resourceId),
                        contentDescription = stringResource(R.string.logo_icon_disc),
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)

                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column() {
                        Text(text = "${person.tag}", style = MaterialTheme.typography.h1
                            , fontSize = 14.sp
                            , fontWeight = FontWeight.SemiBold
                            , letterSpacing = 0.5.sp
                            , color = colorResource(id = R.color.TextFieldPlacHolderColor)
                        )
                        Text(text = "${person.disc}", style = MaterialTheme.typography.h2,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                            , color = colorResource(id = R.color.TextFieldPlacHolderColor)

                        )
                    }


                }
                Spacer(modifier = Modifier.height(7.5.dp))
               Box(modifier = Modifier
                   .background
                       (colorResource(id = R.color.borderColor))
                   .fillMaxWidth()
                   .height(1.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        //  .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(vertical = 8.5.dp)
                    , horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row{


                    Text(text = "${person.like}", style = MaterialTheme.typography.h2
                        , fontSize = 14.sp
                        , fontWeight = FontWeight.Normal
                        , letterSpacing = 0.5.sp
                        , color = colorResource(id = R.color.TextFieldPlacHolderColor)
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_like),
                        contentDescription = stringResource(R.string.logo_icon_disc),
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .clickable { }
                    )

                    }
                    Row {


                    Text(text = "${person.comment}", style = MaterialTheme.typography.h2
                        , fontSize = 14.sp
                        , fontWeight = FontWeight.Normal
                        , letterSpacing = 0.5.sp
                        , color = colorResource(id = R.color.TextFieldPlacHolderColor)
                    )
                        Image(
                            painter = painterResource(R.drawable.ic_comment),
                            contentDescription = stringResource(R.string.logo_icon_disc),
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .clickable { }
                        )
                    }

                    Row {


                        Text(text = "${person.share}", style = MaterialTheme.typography.h2
                            , fontSize = 14.sp
                            , fontWeight = FontWeight.Normal
                            , letterSpacing = 0.5.sp
                            , color = colorResource(id = R.color.TextFieldPlacHolderColor)
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_share),
                            contentDescription = stringResource(R.string.logo_icon_disc),
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .clickable { }
                        )
                    }

                }
            }
        }

    }
    Spacer(modifier = Modifier.height(3.dp))

}