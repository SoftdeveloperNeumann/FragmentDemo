package com.example.fragmentdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.example.fragmentdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityMainBinding
    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btn1.setOnClickListener(this@MainActivity)
            btn2.setOnClickListener(this@MainActivity)
            btn3.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(view: View?) {
        if(view is Button) {
            val city = view.text.toString()
            Log.d(TAG, "onClick: $city")
            if(binding.containerMain == null) {
                val intent = Intent(this, OutputActivity::class.java)
                intent.putExtra("city", city)
                startActivity(intent)
            }else{
                // Erstellen eines Fragments
                val fragment = OutputFragment()
                // dem Fragment die city übergeben
                val args = Bundle()
                args.putString("city", city)
                fragment.arguments = args

                // Aufrufen und Verwenden des erstellten Fragments
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container_main,fragment)
                transaction.commit()

            }
        }
    }
}