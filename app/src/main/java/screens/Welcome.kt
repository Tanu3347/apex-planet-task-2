
package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compotents.AppButton

private val Teal = Color(0xFF286B63)
private val TextColor = Color(0xFF26332F)

@Composable
fun WelcomeScreen(
    onGetStarted: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "WELCOME",
            color = Teal,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Welcome",
            fontSize = 36.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Bold,
            color = TextColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "We're glad you're here. Take a moment " +
                    "to introduce yourself and get started.",
            fontSize = 16.sp,
            lineHeight = 25.sp,
            color = Color(0xFF66716C)
        )

        Spacer(modifier = Modifier.height(32.dp))

        AppButton(
            text = "Get Started",
            onClick = onGetStarted
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Simple, easy, and all about you.",
            fontSize = 13.sp,
            color = Color(0xFF7B8580)
        )
    }
}
