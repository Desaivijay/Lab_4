package vijay.vijay_score

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class settingsActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)



        setSupportActionBar(findViewById(R.id.toolBar))

        val teamAScore = intent.getStringExtra(getString(R.string.team_a_score))
        val teamBScore = intent.getStringExtra(getString(R.string.team_b_score))

        findViewById<Button>(R.id.btnCancel).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.layTeamA).findViewById<TextView>(R.id.tvScoreA).text = teamAScore
        findViewById<TextView>(R.id.layTeamB).findViewById<TextView>(R.id.tvScoreB).text = teamBScore

        val sp = applicationContext.getSharedPreferences(
            getString(R.string.sp_name),
            Context.MODE_PRIVATE
        )
        val editor = sp.edit()

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            editor.putString(getString(R.string.team_a_score), teamAScore)
            editor.putString(getString(R.string.team_b_score), teamBScore)
            editor.apply()
            Toast.makeText(this, "Scores saved successfully", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
