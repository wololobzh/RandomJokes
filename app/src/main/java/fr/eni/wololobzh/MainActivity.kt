package fr.eni.wololobzh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.eni.wololobzh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = ActivityMainBinding.inflate(layoutInflater)
        setContentView(db.root)

        val vm = ViewModelProvider(this).get(ChuckViewModel::class.java)

        vm.randomBlague()

        vm.joke.observe(this, Observer {
            db.model = vm
        })
    }
}