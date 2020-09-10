package com.miu.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_description_layout.view.*
import java.io.Serializable

class ItemList : AppCompatActivity(), OnCategoryClick {
    var electronis : List<Product> = arrayListOf(
        Product(R.drawable.tablet,"RGA Voyager 7 16GB Andriod Tablet", "$35.00", "Color: Black", "Introducing the new RGA Voyager 7-inch tablet 16GB Andriod Tablet", "Walmart #: 12345"),
        Product(R.drawable.laptop,"HP Flyer Red 15.6 Laptop", "$299.00", "Color: Black & Red", "HP Flyer Red 15.6 Laptop operating with Andriod version 10", "Walmart #: 54322"),
        Product(R.drawable.tv,"Vizio 70 Class 4K", "$1298.00", "Color: Black","The new Vizio 70 Class 4K available in only black. Limited edition", "Walmart #: 0987"),
        Product(R.drawable.printer,"Epson WorkForce WF-2750", "$69.00", "Color: Black", "Epson WorkForce WF-2750 with multiple inbuilt smart features", "Walmart #: 56789")



    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)
        recyclerList.hasFixedSize()
        recyclerList.adapter = MyRecyclerListAdapter(electronis,this)
        recyclerList.layoutManager = LinearLayoutManager(this)

    }
    override fun onClickCategory(item:Product) {
        val intent = Intent(applicationContext,ItemDescription::class.java)
        intent.putExtra("product", item)

        startActivity(intent)

        Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
    }

}
class MyRecyclerListAdapter(private val myList:List<Product>, private val clickListener:OnCategoryClick):RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_description_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadView(myList[position],clickListener)
    }



}

class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
    private var image = view.itemImage
    private  var desc = view.prdtDesc
    private var itemColor= view.colorTxt
    private  var priceR = view.priceTxt

    fun loadView(item: Product, action:OnCategoryClick){
        image.setImageResource(item.image)
        desc.text = item.title
        itemColor.text = item.color
        priceR.text = item.price.toString()
        view.setOnClickListener{
            action.onClickCategory(item)
        }
    }
}

interface OnCategoryClick{
    fun onClickCategory(product: Product)
}

data class Product (val image: Int, val title:String,val price:String,val color:String, val description: String, val num : String): Serializable