package com.example.fifth

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private var mInfoTextView: TextView? = null
    private var spinner: ProgressBar?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInfoTextView = findViewById(R.id.text_info)
    }

    fun onClick(view: View?) {
        spinner = findViewById(R.id.progressbar)
        spinner!!.visibility = View.VISIBLE;
        val pizza: Pizza = Pizza()
        pizza.execute()
    }

    internal inner class Pizza :
        AsyncTask<Void?, Void?, Void?>() {
        override fun onPreExecute() {
            super.onPreExecute()
            mInfoTextView!!.text = "Выпекаем пиццу, время ожидания 10 секунд"
        }

        protected override fun doInBackground(vararg voids: Void?): Void? {
            try {
                TimeUnit.SECONDS.sleep(10)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            mInfoTextView!!.text = "Ваша пицца готова!!"
            spinner = findViewById(R.id.progressbar)
            spinner!!.visibility=View.GONE;
        }
    }
}