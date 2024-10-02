package com.example.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvFullName.text = "Họ và tên: ${user.fullName}"
        holder.tvEmail.text = "Email: ${user.email}"
        holder.tvPhoneNumber.text = "Số điện thoại: ${user.phoneNumber}"
        holder.tvGender.text = "Giới tính: ${user.gender}"
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFullName: TextView = itemView.findViewById(R.id.tvFullName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvPhoneNumber: TextView = itemView.findViewById(R.id.tvPhoneNumber)
        val tvGender: TextView = itemView.findViewById(R.id.tvGender)
    }
}
