package com.mihir.googlesheetsasdb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mihir.googlesheetsasdb.model.Data
import com.mihir.googlesheetsasdb.databinding.ItemCompanyBinding

class Adapter(private val list:List<Data>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(binding: ItemCompanyBinding) :RecyclerView.ViewHolder(binding.root){
        val company = binding.tvCompany
        val link = binding.tvLink
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCompanyBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.company.text = list[position].Company_name
        holder.link.text = list[position].LinkedIn

    }

    override fun getItemCount(): Int {
        return list.size
    }
}