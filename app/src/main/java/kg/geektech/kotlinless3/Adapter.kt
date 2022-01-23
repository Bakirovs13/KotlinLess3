package kg.geektech.kotlinless3
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlinless3.databinding.RvItemBinding
import kg.geektech.kotlinless3.extensions.load

class Adapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var onClick: OnClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setOnClick(onClick: OnClick){
        this.onClick = onClick
    }

    inner class ViewHolder(private var binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.ivImage.load(image)
            itemView.setOnClickListener {
                if (binding.background.visibility == View.GONE) {
                    binding.background.visibility = View.VISIBLE
                    onClick.onClicked(image)
                } else {
                    binding.background.visibility = View.GONE
                    onClick.onRemoved(image)
                }
            }
        }
    }

    interface OnClick {
        fun onClicked(position: String)
        fun onRemoved(position: String)
    }
}