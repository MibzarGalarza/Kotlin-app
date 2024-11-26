package com.example.goaltrack.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.goaltrack.R
import com.example.goaltrack.core.entities.Usuario
import com.example.goaltrack.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)
        val signUpButton = findViewById<Button>(R.id.registerButton)
        val loginTextView = findViewById<TextView>(R.id.tvLogin)

        // Inicializar la base de datos de Room
        val db = AppDatabase.getDatabase(applicationContext)

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Registrar el usuario en la base de datos
            val usuario = Usuario(nombre = name, correo = email, contrasena = password)

            lifecycleScope.launch(Dispatchers.IO) {
                val usuarioDao = db.usuarioDao()
                val existingUser = usuarioDao.obtenerPorId(email) // Asumiendo que el correo es único

                if (existingUser == null) {
                    usuarioDao.insertar(usuario)
                    runOnUiThread {
                        Toast.makeText(this@RegistroActivity, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegistroActivity, LoginActivity::class.java))
                        finish()
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this@RegistroActivity, "El correo ya está registrado", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        loginTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
