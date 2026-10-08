
package screens

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compotents.AppButton

private val Teal = Color(0xFF286B63)
private val TextColor = Color(0xFF26332F)

@Composable
fun RegistrationScreen(
    onBack: () -> Unit,
    onRegistrationComplete: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        TextButton(onClick = onBack) {
            Text("← Back", color = Teal)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Let's get to know you",
            fontSize = 29.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.Bold,
            color = TextColor
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Just a couple of details and you're all set.",
            fontSize = 15.sp,
            color = Color(0xFF66716C)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text("Full name", fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter your name") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Email address", fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("you@example.com") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            shape = RoundedCornerShape(12.dp)
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = errorMessage,
                color = Color(0xFFB3261E),
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        AppButton(
            text = "Submit",
            onClick = {
                when {
                    name.isBlank() ->
                        errorMessage = "Please enter your name."

                    email.isBlank() ->
                        errorMessage = "Please enter your email."

                    !Patterns.EMAIL_ADDRESS
                        .matcher(email.trim()).matches() ->
                        errorMessage = "Please enter a valid email."

                    else -> showSuccessDialog = true
                }
            }
        )
    }

    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = {
                showSuccessDialog = false
            },
            title = {
                Text(
                    text = "You're registered!",
                    fontWeight = FontWeight.Bold,
                    color = Teal
                )
            },
            text = {
                Text(
                    text = "Thank you, ${name.trim()}. " +
                            "Your details have been submitted successfully."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showSuccessDialog = false
                        onRegistrationComplete()
                    }
                ) {
                    Text("Done", color = Teal)
                }
            },
            containerColor = Color.White
        )
    }
}
