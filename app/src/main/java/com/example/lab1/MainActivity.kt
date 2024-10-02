package com.example.lab1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var cbTerms: CheckBox
    private lateinit var btnSave: Button
    private lateinit var recyclerView: RecyclerView

    private lateinit var userAdapter: UserAdapter
    private val userList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các view
        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        rgGender = findViewById(R.id.rgGender)
        cbTerms = findViewById(R.id.cbTerms)
        btnSave = findViewById(R.id.btnSave)
        recyclerView = findViewById(R.id.recyclerView)

        // Thiết lập RecyclerView
        userAdapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        // Xử lý khi nhấn nút Lưu
        btnSave.setOnClickListener {
            // Kiểm tra điều khoản sử dụng
            if (!cbTerms.isChecked) {
                Toast.makeText(this, "Vui lòng đồng ý với điều khoản sử dụng", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Lấy thông tin từ EditText
            val fullName = etFullName.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()

            // Lấy giới tính từ RadioGroup
            val selectedGenderId = rgGender.checkedRadioButtonId
            var gender = ""
            if (selectedGenderId != -1) {
                val selectedRadioButton: RadioButton = findViewById(selectedGenderId)
                gender = selectedRadioButton.text.toString()
            }

            // Tạo đối tượng User
            val user = User(fullName, email, phoneNumber, gender)
            userList.add(user)

            // Cập nhật RecyclerView
            userAdapter.notifyDataSetChanged()
        }
    }
}
