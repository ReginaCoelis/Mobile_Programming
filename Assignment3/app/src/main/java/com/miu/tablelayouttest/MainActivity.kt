package com.miu.tablelayouttest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBtn.setOnClickListener {
            Toast.makeText(this,"Successfully Added!!", Toast.LENGTH_LONG).show()
            val tableRow = TableRow(getApplicationContext())
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.setLayoutParams(layoutParams)
            val text1 = TextView(this)
            val text2 = TextView(this)
            text1.textSize= 20f
            text2.textSize = 20f
            text1.text = versionText!!.text.toString()
            text2.text = codeName!!.text.toString()
            text1.setBackgroundColor(Color.parseColor("#FF0085"))
            text2.setBackgroundColor(Color.parseColor("#FF0085"))
            tableRow.addView(text1,0)
            tableRow.addView(text2,1)
            tableLayoutId.addView(tableRow,TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT))


        }
    }

}