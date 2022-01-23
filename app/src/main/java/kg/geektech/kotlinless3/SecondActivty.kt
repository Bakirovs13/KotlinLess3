package kg.geektech.kotlinless3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.kotlinless3.databinding.ActivitySecondActivtyBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondActivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getImages()
    }

    private fun getImages() {
        val list = intent.getStringArrayListExtra(MainActivity.KEY)
        binding.recycler.adapter = list?.let { imagesList ->
            Adapter(imagesList) }

        binding.arrowBackIv.setOnClickListener {
            finish()
        }
    }
}