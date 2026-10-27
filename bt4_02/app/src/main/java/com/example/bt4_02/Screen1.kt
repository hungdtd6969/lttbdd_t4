package com.example.bt4_02

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Màn hình 1: Forget Password
 */
@Composable
fun Screen1(
    initialEmail: String,
    submittedData: UserData?,
    onNext: (String) -> Unit
) {
    var email by remember { mutableStateOf(if (initialEmail.isBlank()) "uth@gmail.com" else initialEmail) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 28.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_uth),
            contentDescription = "Logo UTH",
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(100.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 2. Tiêu đề
        Text(
            text = "Forget Password?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 3. Mô tả
        Text(
            text = "Enter your Email, we will send you a verification code.",
            fontSize = 13.sp,
            color = Color(0xFF64748B),
            textAlign = TextAlign.Center,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        // 4. Ô nhập Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Your Email", color = Color(0xFF94A3B8), fontSize = 14.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email",
                    tint = Color(0xFF94A3B8),
                    modifier = Modifier.size(20.dp)
                )
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFE2E8F0),
                focusedBorderColor = Color(0xFF3B82F6)
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 5. Nút Next (Chuyển sang Màn hình 2)
        Button(
            onClick = { onNext(email) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B82F6)),
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Next", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
        }

        Spacer(modifier = Modifier.weight(1f))

        // 6. Khung màu xanh nhạt nhận kết quả trả về từ Màn hình 4 (Đúng theo sơ đồ đề bài)
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(130.dp)
                .background(Color(0xFFE0EDFF), shape = RoundedCornerShape(20.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (submittedData != null && submittedData.isComplete()) {
                    Text(text = "email: ${submittedData.email}", color = Color(0xFFDC2626), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "otp: ${submittedData.otp}", color = Color(0xFFDC2626), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "pass: ${submittedData.password}", color = Color(0xFFDC2626), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "(từ màn hình 4)", color = Color(0xFFDC2626), fontSize = 13.sp)
                } else {
                    Text(text = "email", color = Color(0xFFDC2626), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "otp", color = Color(0xFFDC2626), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "pass", color = Color(0xFFDC2626), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "(từ màn hình 4)", color = Color(0xFFDC2626), fontSize = 13.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
