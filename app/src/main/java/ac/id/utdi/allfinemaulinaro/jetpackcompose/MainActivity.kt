package ac.id.utdi.allfinemaulinaro.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ac.id.utdi.allfinemaulinaro.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //== Tutorial 1 ==//
                    // Text adalah fungsi composable untuk menampilkan teks
                    //Text(text = "Hello World!")
                    //== End Tutorial 1 ==//

                    //== Tutorial 2 and 3 ==//
                    // MessageCard(Message("Android", "Jetpack Compose"))
                    //== End Tutorial 2 and 3 ==//

                    //== Tutorial 4 ==//
//                    Conversation(SampleData.conversationSample)
                    //== End Tutorial 4 ==//
                }
            }
        }
    }
}

//== Tutorial 2 and 3 ==//
// Message adalah class untuk menampung data
// dengan parameter author untuk penulis dengan tipe string dan body untuk bodi teks string
data class Message(val author: String, val body: String)
// anotasi @compsable digunakan untuk membuat fungsi composable
@Composable
// MessageCard adalah fungsi composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        // memberikan jarak antara gambar dan teks
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            // fungsi ini mimiliki fungsi composable Text
            // dan membutuhkan parameter dari properti data class Message
            Text(
                text = msg.author,
                // memberikan warna pada tulisan
                color = MaterialTheme.colorScheme.secondary,
                // menggunakan style MaterialTheme
                style = MaterialTheme.typography.titleSmall
            )
            // memberika jarak vertikal antar teks
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    // memberikan padding
                    modifier = Modifier.padding(all = 4.dp),
                    // memberikan style tulisan menggunakan MaterialTheme
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

// Preview digunakan untuk melihat peninjauan
// memiliki 2 preview komponen
// satu menggunakan light mode dan satunya menggunakan dark mode
//@Preview(name = "Light Mode")
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
@Composable
fun PreviewMessageCard() {
    // memberika
    JetpackComposeTheme {
        Surface {
            // menampilkan fungsi MessageCard untuk preview
            MessageCard(
                msg = Message("Lexi", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}
//== End Tutorial 2 and 3==//

//== Tutorial 4 ==//
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    JetpackComposeTheme {
//        Conversation(SampleData.conversationSample)
    }
}

//== End Tutorial 4 ==//