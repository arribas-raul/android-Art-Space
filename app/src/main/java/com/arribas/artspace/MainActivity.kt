package com.arribas.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arribas.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(1) }

    when(step){
        1 -> {
            Design(
                title = R.string.title_dmc,
                img = R.drawable.ps5_dmc,
                company = R.string.company_dmc,
                year = R.string.year_horizon,
                onClickPrevious = { step = 5},
                onClickNext = { step = 2 }
            )
        }

        2 -> {
            Design(
                title = R.string.title_horizon,
                img = R.drawable.ps5_horizon,
                company = R.string.company_horizon,
                year = R.string.year_horizon,
                onClickPrevious = { step = 1},
                onClickNext = { step = 3 }
            )
        }

        3 -> {
            Design(
                title = R.string.title_gow,
                img = R.drawable.ps5_gow,
                company = R.string.company_gow,
                year = R.string.year_gow,
                onClickPrevious = { step = 2},
                onClickNext = { step = 4 }
            )
        }

        4 ->{
            Design(
                title = R.string.title_lou,
                img = R.drawable.ps5_lou1,
                company = R.string.company_lou,
                year = R.string.year_lou,
                onClickPrevious = { step = 3},
                onClickNext = { step = 5 }
            )
        }

        5 -> {
            Design(
                title = R.string.title_village,
                img = R.drawable.ps5_village,
                company = R.string.company_village,
                year = R.string.year_village,
                onClickPrevious = { step = 4},
                onClickNext = { step = 1 }
            )
        }
    }


}

@Composable
fun Design(
    title: Int = R.string.title_horizon,
    img: Int = R.drawable.ps5_horizon,
    company: Int = R.string.company_horizon,
    year: Int = R.string.year_horizon,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit,
    modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(32.dp)) {

        Text(
            text = stringResource(R.string.title),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(img),
            contentDescription = "",
            modifier = Modifier
                .padding(8.dp)
                .size(400.dp)
                .border(
                    BorderStroke(1.dp, Color(1, 20, 22, 255)),
                    shape = RoundedCornerShape(2.dp)
                )
                .clickable(onClick = {}))
        
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = stringResource(id = title),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(company),
                    fontWeight = FontWeight.Bold)

                Text(text = "(${stringResource(year)})")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
           ) {
            Button(
                onClick = { onClickPrevious() },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            ){

                Text(text = stringResource(R.string.bt_previous))
            }
            
            Button(
                onClick = { onClickNext() },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)) {
                Text(text = stringResource(R.string.bt_next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        App()
    }
}