package com.varun.login.view.fragment.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.varun.login.R
import com.varun.login.model.User
import kotlinx.android.synthetic.main.custom_row.view.*

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.firstName_txt).text     = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.lastName_txt).text      = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.phoneNumber_txt).text   = currentItem.phone

        holder.itemView.customRowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = userList.size

    fun setData(userList: List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }
}