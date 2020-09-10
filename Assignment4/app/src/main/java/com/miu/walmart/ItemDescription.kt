package com.miu.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_item_details.*

class ItemDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
       var product = intent.getSerializableExtra("product") as Product
        itemImage.setImageResource(product.image)
        itemName.text= (product.title)
        itemColor.text =(product.color)
        itemNum.text = product.num
        itemDetails.text = product.description



    }
}