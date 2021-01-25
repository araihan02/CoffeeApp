package com.ahmadraihan.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapter(private val listDataku: ArrayList<DBModel>): RecyclerView.Adapter<DBAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvemailku: TextView = itemV.findViewById(R.id.tv_emailku)
        var tvnamaku: TextView = itemV.findViewById(R.id.tv_namaku)
        var tvalamatku: TextView = itemV.findViewById(R.id.tv_alamatku)
        var tvjkku: TextView = itemV.findViewById(R.id.tv_jkku)
        var tvteleponku: TextView = itemV.findViewById(R.id.tv_teleponku)
        var btndelete: Button = itemV.findViewById(R.id.btn_deletecard)
        var btnupdate: Button = itemV.findViewById(R.id.btn_updatecard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_dataku, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvemailku.text = dataku.email
        holder.tvnamaku.text = dataku.nama
        holder.tvalamatku.text = dataku.alamat
        holder.tvjkku.text = dataku.jk
        holder.tvteleponku.text = dataku.telepon

        holder.btndelete.setOnClickListener {
            var adapterDBHelper: DBHelper
            adapterDBHelper = DBHelper(holder.itemView.context)
            adapterDBHelper.deleteData(dataku.email)
            listDataku.removeAt(position)
            notifyDataSetChanged()
        }

        holder.btnupdate.setOnClickListener {
            val pindahUpdAc = Intent(holder.itemView.context, UpdateActivity::class.java)
            val bundle = Bundle()
            bundle.putString("emailk", dataku.email)
            bundle.putString("namak", dataku.nama)
            bundle.putString("alamatk", dataku.alamat)
            bundle.putString("jkk", dataku.jk)
            bundle.putString("teleponk", dataku.telepon)
            pindahUpdAc.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUpdAc)
        }

    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}