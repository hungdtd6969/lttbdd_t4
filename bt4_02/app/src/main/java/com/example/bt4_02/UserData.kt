package com.example.bt4_02
data class UserData(
    var email: String = "",
    var otp: String = "",
    var password: String = ""
) {
    // Phương thức kiểm tra dữ liệu đã đầy đủ chưa
    fun isComplete(): Boolean {
        return email.isNotBlank() && otp.isNotBlank() && password.isNotBlank()
    }
}
