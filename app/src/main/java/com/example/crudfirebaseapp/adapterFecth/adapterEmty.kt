package com.example.crudfirebaseapp.adapterFecth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crudfirebaseapp.EmployeeModel
import com.example.crudfirebaseapp.R

class adapterEmty ( var list : ArrayList<EmployeeModel>): RecyclerView.Adapter<adapterEmty.EmptyViewHolder>() {

    class EmptyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
          var tvEmpty : TextView

         init {
             tvEmpty = itemview.findViewById(R.id.tvEmpName)
         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmptyViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.emp_list_item, parent, false);
        return EmptyViewHolder( view )
    }

    override fun onBindViewHolder(holder: EmptyViewHolder, position: Int) {
       holder.itemView.apply {
           holder.tvEmpty.text = list[position].empName
       }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}