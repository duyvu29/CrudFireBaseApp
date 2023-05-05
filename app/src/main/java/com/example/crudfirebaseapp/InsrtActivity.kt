package com.example.crudfirebaseapp

import android.app.backup.BackupAgent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsrtActivity : AppCompatActivity() {
    lateinit var btnSave : Button
    lateinit var edtName: EditText
    lateinit var edtAge: EditText
    lateinit var edtSalary: EditText

    lateinit var db : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insrt)

        mapping()
        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance().getReference("Employees")
        // xử lý sự kiện khi click vào button save
        btnSave.setOnClickListener {
            saveEmployees()
        }

    }

    private fun saveEmployees() {
        //get string data
        var employName = edtName.text.toString();
        var employAge = edtAge.text.toString()
        var employSalaty    = edtSalary.text.toString()
        //lấy dữ liệu
        var empId = db.push().key!!
        var employess = EmployeeModel(empId,employName,employAge,employSalaty)
        db.child(empId).setValue(employess)
            .addOnCompleteListener{
                Toast.makeText(this     , "data insert success", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                err ->
                Toast.makeText(this, "Errol ", Toast.LENGTH_SHORT).show()
            }

    }

    private fun mapping() {
        btnSave = findViewById(R.id.btnSave)
        edtName = findViewById(R.id.edtEmpName)
        edtAge    = findViewById(R.id.edtEmpAge)
        edtSalary   = findViewById(R.id.edtEmpSalary)
    }
}