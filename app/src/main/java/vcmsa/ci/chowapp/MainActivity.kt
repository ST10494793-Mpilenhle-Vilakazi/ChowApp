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
        inputTime = findViewById(R.id.input_time)
        btnSuggest = findViewById(R.id.btn_suggest)
        txtSuggestion = findViewById(R.id.txt_suggestion)

        // Set button click listener
        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()
            txtSuggestion.text = suggestMeal(timeOfDay)
        }
    }

    //function to determine meal suggestion based on time of day
    private fun suggestMeal(time: String): String {
        return when (time) {
            "morning" -> "Breakfast suggestion: Pancakes or Omlette"
            "mid-morning" -> "Light snack: Fruit or Yogurt"
            "afternoon" -> "Lunch suggestion: Sandwich or Salad"
            "dinner" -> "Dinner suggestion:Pasta or Grilled Chicken"
            else -> "Invalid input. Please enter a valid time of the day"
        }
    }
}
