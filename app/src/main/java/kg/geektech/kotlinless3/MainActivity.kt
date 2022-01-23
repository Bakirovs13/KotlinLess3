package kg.geektech.kotlinless3
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlinless3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), Adapter.OnClick {

    companion object {
        const val KEY = "key"
    }

    private lateinit var binding: ActivityMainBinding
    private val imageList = mutableListOf<String>()
    private val list = arrayListOf<String>()
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRv()
    }

    private fun initRv() {
        adapter = Adapter(fullList())
        adapter.setOnClick(this)
        binding.recycler.adapter = adapter
    }

    private fun fullList(): MutableList<String> {
        imageList.add("https://cdn.pixabay.com/photo/2015/03/11/01/33/hulk-667988__340.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2015/03/11/01/33/hulk-667988__340.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2019/09/03/05/01/spiderman-4448631__480.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2015/03/11/01/33/hulk-667988__340.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2015/03/11/01/33/hulk-667988__340.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2015/03/11/01/33/hulk-667988__340.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2020/08/07/19/37/iron-man-5471434__480.png")
        imageList.add("https://cdn.pixabay.com/photo/2020/08/07/19/37/iron-man-5471434__480.png")
        imageList.add("https://cdn.pixabay.com/photo/2021/07/20/14/59/iron-man-6480952__340.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2021/07/20/14/59/iron-man-6480952__340.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2021/07/20/14/59/iron-man-6480952__340.jpg")


        return imageList
    }

    override fun onClicked(position: String) {
        binding.cardView.visibility = View.VISIBLE
        binding.finishBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(KEY, list)
            startActivity(intent)
        }
        list.add(position)
    }

    override fun onRemoved(position: String) {
        list.remove(position)
    }
}