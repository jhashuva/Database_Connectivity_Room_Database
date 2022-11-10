package com.example.studentdata


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.TaskStackBuilder.create
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.net.URI.create

class StudentListAdapter: ListAdapter<Student, StudentListAdapter.StudentViewHolder>(
    StudentViewHolder.StudentsComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.rollNumber,current.name)
    }

    class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val rollNo: TextView = itemView.findViewById(R.id.roll_no)
        private val studentName: TextView = itemView.findViewById(R.id.name)

        fun bind(roll_no:String?, name:String?){
            rollNo.text = roll_no
            studentName.text = name
        }

        companion object {
            fun create(parent: ViewGroup): StudentViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item,parent,false)
                return StudentViewHolder(view)
            }
        }



        class StudentsComparator: DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem.rollNumber == newItem.rollNumber && oldItem.name==newItem.name
            }

        }
    }
}






