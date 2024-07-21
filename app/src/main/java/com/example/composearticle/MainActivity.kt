package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    ComposeArticleApp(
                        title = stringResource(id = R.string.article_title),
                        firstParagraph = stringResource(id = R.string.article_first_paragraph),
                        secondParagraph = stringResource(id = R.string.article_second_paragraph),
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(title: String, firstParagraph: String,
             secondParagraph: String,
             modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)

        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        ){
            Image(
                painter = image,
                contentDescription = null
            )
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = modifier
                    .padding(16.dp)
            )
            Text(
                text = firstParagraph,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp)
            )
            Text(
                text = secondParagraph,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(16.dp)
            )
        }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeArticleApp(
            title = stringResource(R.string.article_title),
            firstParagraph = stringResource(R.string.article_first_paragraph),
            secondParagraph = stringResource(R.string.article_second_paragraph)
        )
    }
}