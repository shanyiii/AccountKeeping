package com.example.accountskeeping


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.accountskeeping.R

class AccountArrayAdapter(val c: Context, val items: ArrayList<AccountItem>) :
    ArrayAdapter<AccountItem>(c, 0, items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(c)

        var itemlayout: LinearLayout? = null

        if (convertView == null) {
            itemlayout = inflater.inflate(R.layout.listitem, null)
                    as? LinearLayout
        } else {
            itemlayout = convertView as? LinearLayout
        }

        val item: AccountItem? = getItem(position) as? AccountItem

        val tv_name: TextView = itemlayout?.findViewById(R.id.itemtv)!!
        tv_name.text = item!!.name
        val tv_money: TextView = itemlayout?.findViewById(R.id.itemmoney)!!
        tv_money.text = item!!.money.toString()

        return itemlayout;

    }
}