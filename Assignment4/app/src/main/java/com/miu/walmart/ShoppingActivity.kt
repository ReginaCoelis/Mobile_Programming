package com.miu.walmart

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_shopping.*
import kotlinx.android.synthetic.main.custom_list.*

class ShoppingActivity : AppCompatActivity() {
    var items :List<Category> = arrayListOf(
        Category("Electronics", "electronic", R.drawable.electronics),
        Category("Beauty", "beauty", R.drawable.beauty),
        Category("Clothing", "clothing", R.drawable.clothing),
        Category("Food", "food", R.drawable.food)
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        user.text = "Welcome ${intent.getStringExtra("userName")}"
        itemsGrid.adapter= MyAdapter(this,items)


        itemsGrid.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem:Category = parent.getItemAtPosition(position) as Category
                Toast.makeText(applicationContext,selectedItem.name,Toast.LENGTH_SHORT).show()

             var intent = Intent(applicationContext,ItemList::class.java)
                startActivity(intent)
            }
        }
    }

//    fun itemClicked() {
//        itemImage.setOnClickListener {
//            var intent : Intent = Intent(this, ItemList::class.java)
//            startActivity(intent)
//        }
//    }
}
class MyAdapter(val context: Context,val myList:List<Category>):BaseAdapter(){



    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View? {
        var view:View?
        var viewHolder:ViewHolder
        if(convertView==null){
            view = LayoutInflater.from(context).inflate(R.layout.custom_list,container,false)
            viewHolder  = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var category:Category  = getItem(position)

        viewHolder.item?.text =category.name
        viewHolder.image?.setImageResource(category.image)
        return view as View
    }

    override fun getItem(position: Int): Category {
        return  myList[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount(): Int {
        return myList.count()
    }

    private class ViewHolder(view: View?){
        var item: TextView?=null
        var image: ImageView?=null
        init {

            image = view?.findViewById<ImageView>(R.id.itemImage)
            item = view?.findViewById<TextView>(R.id.itemName)

        }
    }


}