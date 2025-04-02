package vcmsa.ci.chowapp

import android.os.Bundle
import android.view.inputmethod.InlineSuggestion
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.time.ExperimentalTime

class MainActivity : ComponentActivity() {

    //Declare viables
    private lateinit var inputTime: EditText
    private lateinit var btnSuggest: Button
    private lateinit var txtSuggestion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_main)

        //Initialize UI elements


            ChowAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChowAppTheme {
        Greeting("Android")
    }
}