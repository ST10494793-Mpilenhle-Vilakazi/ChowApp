package vcmsa.ci.chowapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Declare UI elements
        val edtTime: EditText = findViewById(R.id.edtTime)
        val btnSuggestMeal: Button = findViewById(R.id.btnSuggestion)
        val txtMealSuggestion = findViewById<TextView>(R.id.txtSuggestion)


        // Button click listener to suggest a meal
        btnSuggestMeal.setOnClickListener {
            val inputText = edtTime.text.toString()

            if (inputText.isNotEmpty()) {
                val hour = inputText.toIntOrNull()

                if (hour != null && hour in 0..23) {
                    suggestMeal(hour)
                    val suggestedMeal = suggestMeal(hour)
                    txtMealSuggestion.text = "Suggested Meal: $suggestedMeal"
                } else {
                    Toast.makeText(this, "Please enter a valid hour (0-23_", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, "Please enter TIME", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //function to determine meal based on time of day
    private fun suggestMeal(hour: Int): String {
        return when (hour) {
            in 5..10 -> "Breakfast suggestion:Pancakes or Omelette"
            in 11..15 -> "Lunch suggestion: Sandwich or Salad"
            in 16..21 -> "Dinner suggestion: Pasta or Grilled chicken"
            else -> "It's not a typical mealtime. How about a snack?"
        }
    }
}