package com.example.currencyconverter.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R

class CurrAdapter(currViewModel: CurrViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var currencyMap: LinkedHashMap<String, Double>? = null
    private var currViewModel: CurrViewModel

    init {
        this.currencyMap = currViewModel.currResponseModel?.quotes?.getCurrListAsMap()
        this.currViewModel = currViewModel
    }

    fun setCurrencyMap(currMap: LinkedHashMap<String, Double>) {
        this.currencyMap = currMap
        this.notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val vh: RecyclerView.ViewHolder
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.conv_list_item, parent, false)
        vh = CurrItemHolder(v)
        return vh
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        configureItemView(viewHolder as CurrItemHolder, position)
    }

    private fun configureItemView(viewHolder: CurrItemHolder, position: Int) {
            val movieItem: String = currViewModel.getExchangeRateText(position,currencyMap)
            viewHolder.titleTv.text = movieItem
    }

    override fun getItemCount(): Int {
        return currencyMap?.size ?: 0
    }

    inner class CurrItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var titleTv: TextView = itemView.findViewById(R.id.curr_text)

    }

}
