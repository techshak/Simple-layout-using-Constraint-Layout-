package com.example.weektwotask

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.weektwotask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var orientChange = 0
    private var portraitState =" Orientation: PORTRAIT"
    private var landscapeState =" Orientation: LANDSCAPE"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Set
        findViewById<TextView>(R.id.textView).text=orientChange.toString()

        // On Clicking the button move to the second activity
        findViewById<Button>(R.id.secondAction).setOnClickListener{
            val intent = Intent( this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        findViewById<TextView>(R.id.textViewState).text="onStart"
    }

    override fun onPause() {
        super.onPause()
        findViewById<TextView>(R.id.textViewState).text="onPause"
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.textViewState).text="onResume"
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("rotateCount",orientChange)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val rotationInt =savedInstanceState.getInt("rotateCount",0)
        orientChange= rotationInt
        val orientationCount =resources.configuration.orientation
        if(orientationCount == Configuration.ORIENTATION_LANDSCAPE ){
            ++orientChange
            findViewById<TextView>(R.id.textView).text="Rotations: "+orientChange.toString()+landscapeState
        }else{
            ++orientChange
            findViewById<TextView>(R.id.textView).text="Rotations: "+orientChange.toString()+portraitState
        }
    }

}