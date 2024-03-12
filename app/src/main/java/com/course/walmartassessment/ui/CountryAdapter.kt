package com.course.walmartassessment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.course.domain.model.Country
import com.course.walmartassessment.R

class CountryAdapter(private val countryList: List<com.course.domain.model.Country>) : RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.name.text = "${country.name}, ${country.region}"
        holder.capital.text = country.capital
        holder.code.text = country.code
    }

}

class CountryViewHolder(itemView: View) : ViewHolder(itemView) {

    var name: TextView
    var capital: TextView
    var code: TextView

    init {
        name = itemView.findViewById(R.id.country_name)
        capital = itemView.findViewById(R.id.country_capital)
        code = itemView.findViewById(R.id.country_code)
    }

}