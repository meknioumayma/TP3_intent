package com.example.tp3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3.ui.theme.TP3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color(0xFFFAFAFA)), // Couleur de fond léger pour l'écran
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Message de bienvenue avec une taille de police professionnelle
        Text(
            text = "Bienvenue à l'application",
            fontSize = 24.sp,
            color = Color(0xFF333333), // Couleur de texte sombre
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Champ de saisie du nom d'utilisateur
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nom d'utilisateur") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp) // Arrondi
        )

        // Champ de saisie du mot de passe
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Mot de passe") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp) // Arrondi
        )

        // Bouton de connexion avec un style plus raffiné
        Button(
            onClick = {
                // Logique de connexion
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp), // Coins arrondis
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF578616)) // Couleur du bouton
        ) {
            Text(text = "Connexion", fontSize = 16.sp, color = Color.White)
        }

        // Lien pour mot de passe oublié
        Text(
            text = "Mot de passe oublié ?",
            fontSize = 14.sp,
            color = Color(0xFF177E1C), // Couleur du lien
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, ForgotPasswordActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(vertical = 8.dp)
        )

        // Lien pour inscription
        Text(
            text = "S'inscrire",
            fontSize = 14.sp,
            color = Color(0xFF338D36), // Couleur du lien
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, SignUpActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TP3Theme {
        LoginScreen()
    }
}