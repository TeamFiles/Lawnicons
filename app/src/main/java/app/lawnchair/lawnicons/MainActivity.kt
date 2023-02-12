package app.lawnchair.lawnicons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import app.lawnchair.lawnicons.databinding.ActivityMainBinding
import app.lawnchair.lawnicons.screens.icons.GetIconInfo

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.bottomNav.setupWithNavController(this.findNavController(R.id.navHostFragment))


        //Run threads
        val dataThread: Thread = Data()
        Data.setContext(applicationContext)
        dataThread.start()
        val iconsThread: Thread = GetIconInfo()
        GetIconInfo.setContext(applicationContext)
        iconsThread.start()
    }
}