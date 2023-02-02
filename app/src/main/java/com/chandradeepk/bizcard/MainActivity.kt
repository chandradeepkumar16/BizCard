package com.chandradeepk.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chandradeepk.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){

    val btnclickedstate = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            backgroundColor=Color.LightGray,
            shape = RoundedCornerShape(corner= CornerSize(25.dp)),
            elevation = 4.dp) {
            
            Column(modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {


                CreateImageProfile()


                Divider(
                    thickness = 1.dp
                )


                CreateInfo()


                Button(
                    onClick = {
                        btnclickedstate.value=!btnclickedstate.value

                }
                ) {
                    Text(text = "PortFolio",
                    style = MaterialTheme.typography.button
                    )
                }
                if(btnclickedstate.value){
                    Content()
                }else{
                    Box() {
                        
                    }
                }


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Content()
{
    
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(9.dp)){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(7.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 2.dp , color = Color.LightGray)
        ) {

            Portfolio(data=
            listOf("Project 1" , "Project 2" ,
                "Project 3" , "Project 4" ,
                "Project 5"))

        }
    }

}

@Composable
fun Portfolio(data: List<String>) {
    
    LazyColumn{
        items(data){item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(), shape = RectangleShape,
                border = BorderStroke(0.5.dp, Color.DarkGray),
            elevation = 4.dp)
            {

                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.background)
                    .padding(16.dp)) {

//                    CreateImageProfile(modifier = Modifier.size(70.dp))

                    Surface(
                        modifier = Modifier
                            .size(70.dp)
                            .padding(7.dp),
                        shape = CircleShape,
                        border = BorderStroke(0.5.dp, Color.DarkGray),
                        elevation = 4.dp,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "My profile pic",
                            modifier = Modifier.size(55.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                        Text(text = item , fontWeight = FontWeight.Bold)
                        Text(text = "A great Projet")
                    }


                }
                
            }
        }
    }

}


@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            modifier = Modifier.padding(3.dp), color = Color.Black,
            fontSize = 28.sp,
            text = "Chandradeep K",
            style = MaterialTheme.typography.h4
        )

        Text(
            modifier = Modifier.padding(3.dp), color = Color.Black,
            fontSize = 14.sp,
            text = "Android Developer",
            style = MaterialTheme.typography.h2
        )

        Text(
            modifier = Modifier.padding(3.dp),
            color = Color.Black,
            fontSize = 14.sp,
            text = "@chandradeep.kumar16",
            style = MaterialTheme.typography.h2
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.DarkGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "My profile pic",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}