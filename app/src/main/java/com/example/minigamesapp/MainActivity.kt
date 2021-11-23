package com.example.minigamesapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.minigamesapp.classes.Dice
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val dice = Dice()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btRoll.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Try your luck")

            val layout = LinearLayout (this)
            layout.orientation = LinearLayout.VERTICAL

            var alertDialog:AlertDialog? = null

            val btClick =  View.OnClickListener { view->
                alertDialog?.cancel()
                val n:Int = view.tag as Int
                if(n==dice.roll()) {
                    Toast.makeText(this, "Good!", Toast.LENGTH_LONG).show()
                }

                when(dice.state) {
                    1 -> binding.ImageView.setImageResource(R.drawable.a)
                    2 -> binding.ImageView.setImageResource(R.drawable.b)
                    3 -> binding.ImageView.setImageResource(R.drawable.c)
                    4 -> binding.ImageView.setImageResource(R.drawable.d)
                    5 -> binding.ImageView.setImageResource(R.drawable.e)
                    6 -> binding.ImageView.setImageResource(R.drawable.f)
                }
            }
            for (i in 1..dice.sides) {
                val bt = Button(this)
                bt.text = i.toString()
                bt.tag = i
                bt.setOnClickListener(btClick)
                layout.addView(bt)
            }
            dialogBuilder.setView(layout)
            alertDialog=dialogBuilder.show()
        }
    }
}