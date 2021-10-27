package com.example.weektwotask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Increase count and pass parameter one and two to the new Instance of the fragment when the Button is clicked
        findViewById<Button>(R.id.addButton).setOnClickListener {
            count++
            supportFragmentManager.beginTransaction().add(
                    R.id.fragmentFrame,
                OriginalFragment.newInstance("Fragment: $count",""),
                "Empty Fragment"
                ).commit()
            }

                }

        }

