package com.example.crudfirebaseapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudfirebaseapp.adapterFecth.adapterEmty
import com.google.firebase.database.*

class FetchActivity : AppCompatActivity() {
    lateinit var ds : ArrayList<EmployeeModel>
    lateinit var dataFB : DatabaseReference

    lateinit var rcvFetch : RecyclerView
    lateinit var tvLoadding : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)

        mapping ()
        rcvFetch.layoutManager = LinearLayoutManager(this);
        rcvFetch.setHasFixedSize(true)
        ds = arrayListOf<EmployeeModel>()

        getInforUser()
    }

    private fun getInforUser() {
        rcvFetch.visibility = View.GONE
        tvLoadding.visibility = View.VISIBLE
        dataFB = FirebaseDatabase.getInstance().getReference("Employees")
        dataFB.addValueEventListener(object  : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                    ds.clear()
                     if (snapshot.exists()){
                         for (empSnap in snapshot.children){
                             val empModel = empSnap.getValue(EmployeeModel::class.java)
                             ds.add(empModel!!)
                         }
                         val mAdapter = adapterEmty(ds)
                         rcvFetch.adapter = mAdapter
                         rcvFetch.visibility = View.VISIBLE
                         tvLoadding.visibility = View.GONE

                     }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

    private fun mapping() {
        rcvFetch = findViewById(R.id.rvEmp)
        tvLoadding = findViewById(R.id.txtLoadingData)
    }
}