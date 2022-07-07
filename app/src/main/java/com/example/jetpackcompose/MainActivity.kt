package com.example.jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcompose.ui.theme.JetpackcomposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //for your own font
//        val fontFamily = FontFamily(
//            Font(R.font.exp)
//        )
        setContent {

            //ConstrainLayout()

           // Animation()

//            CircularProgressbar(
//                percentage = 0.8f, 100,
//            )


        }
    }
}

@Composable
fun NavigationComp(){

}

@Composable
fun CircularProgressbar(percentage: Float,
number: Int, fontSize: TextUnit = 28.sp, radius: Dp =50.dp,
color: Color = Color.Red, storkeWidth: Dp = 20.dp, aniDur: Int = 1000,
aniDelay: Int = 0
){
    var aniPlayed by remember {
        mutableStateOf(false)
    }
    val currPer = animateFloatAsState(targetValue = if (aniPlayed)
        percentage else 0f, animationSpec = tween(durationMillis = aniDur,
    delayMillis = aniDelay))
    
    LaunchedEffect(key1 = true ){
        aniPlayed = true
    }

    Box(contentAlignment = Alignment.Center,
    modifier = Modifier.size(radius * 2f)){

        //canvas is used to draw your shape
        Canvas(modifier = Modifier.size(radius * 2f)){
            drawArc(color = color,
            -90f,
            360 * currPer.value,
            useCenter = false,
            style = Stroke(storkeWidth.toPx(), cap = StrokeCap.Round ))
        }

        Text(text = (currPer.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )

    }


}

@Composable
fun Card(){
    //card work
//            val painter = painterResource(id = R.drawable.ic_launcher_background)
//            val des = "image card text"
//            val title = "image card title"

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(.5f)
//                    .padding(16.dp)
//            ) {
//                ImageCard(painter = painter, content = des, title = title)
//            }
}


@Composable
fun State(){
    //state with clicks
    //ColorBox(Modifier.fillMaxSize())

    //text styles
//            Box(modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xFF101010))){
//
//                Text(text = buildAnnotatedString {
//                                                 withStyle(
//                                                     style = SpanStyle(
//                                                         color = Color.Green,
//                                                         fontSize = 50.sp
//                                                     )
//                                                 ){
//                                                     append("J")
//                                                 }
//                    append("etpack")
//                },
//                color = Color.White,
//                fontSize = 30.sp,
//                    textAlign = TextAlign.Center
//                    ,fontStyle = FontStyle.Italic
//                    ,textDecoration = TextDecoration.Underline
//                //fontFamily = fontFamily
//               )
//
//            }
}

@Composable
fun Snackbar(){

    //provide a layout that works well together with material design
    //layout in compose this will help in already existing
    //material design compenets
    //used to show snackbar
    //state is just a value that can change overtime
    // state usually represents some part of the ui

//            val scaffoldState = rememberScaffoldState()
//            var textFieldState by remember {
//                mutableStateOf("")
//            }
//            val scope = rememberCoroutineScope()
//            Scaffold(
//                modifier = Modifier.fillMaxSize(),
//                scaffoldState = scaffoldState
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = 30.dp)
//                ) {
//                    TextField(
//                        value = textFieldState,
//                        label = {
//                            Text("Enter your name")
//                        },
//                        onValueChange = {
//                            textFieldState = it
//                        },
//                        singleLine = true,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//
//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    Button(onClick = {
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
//                        }
//                    }) {
//                        Text("Please greet me")
//                    }
//
//                }
//            }

    Navigation()

}

@Composable
fun List(){
    //list

    //these will load lazily
    //they will only load when we scroll to that position
//            LazyColumn{
//                itemsIndexed(
//                    listOf("This","is","test","list","sample")){ index, string ->
//
//                        Text(text = string,
//                            fontSize = 20.sp,
//                            textAlign = TextAlign.Center,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 24.dp)
//                        )
//
//                    }
//
////                items(500){
////                    Text(text = "Item $it",
////                        fontSize = 20.sp,
////                        textAlign = TextAlign.Center,
////                        fontWeight = FontWeight.Bold,
////                        modifier = Modifier
////                            .fillMaxWidth()
////                            .padding(vertical = 24.dp)```
////                    )
////                }
//            }


    //normal list
    //  val scroll = rememberScrollState()
//            Column(
//                modifier = Modifier.verticalScroll(scroll)
//            ) {
//                for(i in 1..50){
//                    Text(text = "Item $i",
//                    fontSize = 20.sp,
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp)
//                    )
//
//                }
//
//            }
}

@Composable
fun Animation(){
    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    val size  by animateDpAsState(targetValue = sizeState,
    //apply animation curve, dela y
        tween(
            durationMillis = 3000,
            delayMillis = 300,
            easing = LinearOutSlowInEasing
        ))
    Box(modifier = Modifier
        .size(size = size)
        .background(Color.Red),
    contentAlignment = Alignment.Center) {
        Button(onClick = { sizeState += 50.dp}) {
            Text("Increase size")
        }

    }

}

@Composable
fun ConstrainLayout(){
    val const = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")

        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox){
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        //add chain
        createHorizontalChain(greenBox,redBox,chainStyle =  ChainStyle.Spread)
    }
    ConstraintLayout(constraintSet = const,modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("greenbox"))

        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redbox"))
    }



}

@Composable
fun ImageCard(
    painter: Painter, content: String, title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {

        Box(modifier = Modifier.height(200.dp)) {

            Image(
                painter = painter, contentDescription = content,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(Color.Black, fontSize = 16.sp))
            }
        }
    }
}

//we called Composable to the view now
@SuppressLint("UnrememberedMutableState")
@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(Color.Yellow)
    }
    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }
    )
}
