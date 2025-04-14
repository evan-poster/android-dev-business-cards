package com.eposter.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eposter.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCardPage()
            }
        }
    }
}

@Composable
fun UserInfo(name: String, jobtitle: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                top = 100.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = modifier
                .padding(10.dp)
                .width(110.dp)
                .height(110.dp)
                .background(color = colorResource(id = R.color.avatar_bg))
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 42.sp,
            modifier = Modifier
                .padding(5.dp)
        )
        Text(
            text = jobtitle,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = colorResource(R.color.green_primary)
        )
    }
}

@Composable
fun ContactItem(label: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.height(25.dp)
    ){
        Icon(
            imageVector = icon,
            tint = colorResource(R.color.green_primary),
            contentDescription = null
        )
        Text(
            text = label,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            modifier = Modifier
                .width(175.dp)
                .padding(
                    start = 10.dp,
                )
        )
    }
}

@Composable
fun ContactInfo(phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(
                top = 200.dp,
                bottom = 20.dp
            )
    ) {
        ContactItem(phone, Icons.Filled.Phone)
        ContactItem(social, Icons.Filled.Share)
        ContactItem(email, Icons.Filled.Email)
    }
}

@Composable
fun BusinessCardPage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(color = colorResource(id = R.color.light_green))
        ) {
            UserInfo(
                stringResource(id = R.string.user_name),
                stringResource(id = R.string.job_title)
            )
            ContactInfo(
                stringResource(id = R.string.phone_number),
                stringResource(id = R.string.social_media),
                stringResource(id = R.string.email_address)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardPage()
    }
}