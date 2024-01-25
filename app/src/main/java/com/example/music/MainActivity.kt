package com.example.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.example.music.ui.theme.MusicTheme
import java.nio.channels.spi.AbstractSelectionKey
import java.security.interfaces.DSAPrivateKey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   home()
                }
            }
        }
    }
}
@Composable
fun home() {

    LazyColumn() {
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text("Find your", fontSize = 24.sp, color = Color.Black)
                    Text("favorite music", fontSize = 24.sp, color = Color.Black)

                }
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    modifier = Modifier.size(height = 50.dp, width = 50.dp)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("Popular", fontSize = 22.sp, color = Color.Black)
                Text("view All", fontSize = 15.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                items(song_imageitem, key = { it.id }) {

                    Card(modifier = Modifier
                        .padding(end = 7.dp)
                        ) {
                        Image(
                            painter = rememberImagePainter(it.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .size(250.dp)
                        )
                    }
                }
            }
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "MainScreen"){
                composable(route = "MainScreen"){
                    home()
                }
                composable(route = "Detailscreen"){
                      DetailScreen()
                }
            }



        }
    }
}

@Composable
fun DetailScreen() {

}


data class Song_images(
    val id:Int,
    val image:String,
)
val song_imageitem= listOf<Song_images>(
    Song_images(1,"https://c.saavncdn.com/107/Jai-Shri-Ram-From-Adipurush-Telugu-Telugu-2023-20230519190614-500x500.jpg"),
    Song_images(2,"https://www.naasongs.to/wp-content/uploads/2023/11/Anima-2023-Nanna-Nuv-Naa-Pranam.jpg"),
    Song_images(3,"https://c.saavncdn.com/847/All-Hail-The-Tiger-From-Devara-Part-1-Telugu-2024-20240109141003-500x500.jpg"),
    Song_images(4,"https://www.cinejosh.com/newsimg/newsmainimg/chitti-adugu-from-most-eligible-bachelor-released_b_1110210555.jpg"),
    Song_images(5,"https://c.saavncdn.com/437/Yaar-Yaaro-Soul-Version-From-ANIMAL-Tamil-2023-20231223151011-500x500.jpg"),
)
