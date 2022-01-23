package kg.geektech.kotlinless3.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.load(resource:String){

    Glide.with(this)
        .load(resource)
        .centerCrop()
        .into(this)
}