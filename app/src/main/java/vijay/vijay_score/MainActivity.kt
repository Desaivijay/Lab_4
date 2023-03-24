package vijay.vijay_score

import android.app.UiModeManager.MODE_NIGHT_NO
import android.app.UiModeManager.MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    // Views
    private lateinit var team1_score: TextView
    private lateinit var team2_score: TextView
    private lateinit var team1_inc: Button
    private lateinit var team2_inc: Button
    private lateinit var team1_dec: Button
    private lateinit var team2_dec: Button
    private lateinit var one_run: RadioButton
    private lateinit var two_runs: RadioButton
    private lateinit var three_runs: RadioButton
    private lateinit var four_runs: RadioButton
    private lateinit var five_runs: RadioButton
    private lateinit var six_runs: RadioButton
    private lateinit var radioGroup: RadioGroup

    // Integer value for increment decrement score
    private var valueToIncDec: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        team1_score = findViewById(R.id.team1_score)
        team2_score = findViewById(R.id.team2_score)

        team1_inc = findViewById(R.id.team1_inc)
        team2_inc = findViewById(R.id.team2_inc)
        team1_dec = findViewById(R.id.team1_dec)
        team2_dec = findViewById(R.id.team2_dec)

        one_run = findViewById(R.id.one_run)
        two_runs = findViewById(R.id.two_runs)
        three_runs = findViewById(R.id.three_runs)
        four_runs = findViewById(R.id.four_runs)
        five_runs = findViewById(R.id.five_runs)
        six_runs = findViewById(R.id.six_runs)
        radioGroup = findViewById(R.id.radioGroup)

        val switch: Switch = findViewById(R.id.theme)
        // Set valueToIncDec when radio button checked
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            valueToIncDec = when (checkedId) {
                R.id.one_run -> {
                    1
                }
                R.id.two_runs -> {
                    2
                }
                R.id.three_runs -> {
                    3
                }
                R.id.four_runs -> {
                    4
                }
                R.id.five_runs -> {
                    5
                }
                R.id.six_runs -> {
                    6
                }
                else -> {
                    1
                }
            }
        }
        // Click event for Increment button of Team 1
        team1_inc.setOnClickListener {
            val currentscoreteam1 = team1_score.text.toString()             // Current score of Team 1
            val newscore = currentscoreteam1.toInt() + valueToIncDec         // New score after increment the score
            team1_score.text = newscore.toString()
        }

        team2_inc.setOnClickListener {
            val currentscoreteam2 = team2_score.text.toString()             // Current score of Team 2
            val newscore = currentscoreteam2.toInt() + valueToIncDec        // New score after increment the score
            team2_score.text = newscore.toString()
        }

        team1_dec.setOnClickListener {
            val currentscoreteam1 = team1_score.text.toString()             // Current score of Team 1
            val newscore = currentscoreteam1.toInt() - valueToIncDec        // New score after decrement the score
            if (newscore >= 0) {
                team1_score.text = newscore.toString()
            }
        }

        team2_dec.setOnClickListener {
            val currentscoreteam2 = team2_score.text.toString()             // Current score of Team 1
            val newscore = currentscoreteam2.toInt() - valueToIncDec        // New score after decrement the score
            if (newscore >= 0) {
                team2_score.text = newscore.toString()
            }
        }
        //switch to chane the theme
        switch.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
             }else {
                 AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO))
             }

            }
        }
    }
