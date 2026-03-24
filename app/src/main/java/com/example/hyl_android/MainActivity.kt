package com.example.hyl_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hyl_android.ui.theme.Hyl_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hyl_androidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding ->
                    ContactCard(
                        name = "Jennifer Doe",
                        title = "Android Developer Extraordinaire",
                        phone = "+1 (123) 444 555 666",
                        twitter = "@AndroidDev",
                        email = "jen.doe@andrid.com",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContactCard(
    name: String,
    title: String,
    phone: String,
    twitter: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 图片部分
        Image(
            painter = painterResource(R.drawable.ip2_0),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 24.dp),
            alignment = Alignment.Center
        )
        
        // 姓名和职位
        Text(
            text = name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color(0xFF4CAF50), // 绿色
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )
        
        // 分隔线
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
                .padding(horizontal = 32.dp)
        )
        
        // 联系信息 - 不使用图标
        Spacer(modifier = Modifier.height(24.dp))
        ContactInfoItem(label = "Phone:", value = phone)
        ContactInfoItem(label = "Twitter:", value = twitter)
        ContactInfoItem(label = "Email:", value = email)
    }
}

@Composable
fun ContactInfoItem(label: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3), // 蓝色
            modifier = Modifier.width(80.dp) // 固定标签宽度，保持对齐
        )
        Text(
            text = value,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    Hyl_androidTheme {
        ContactCard(
            name = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            phone = "+1 (123) 444 555 666",
            twitter = "@AndroidDev",
            email = "jen.doe@andrid.com"
        )
    }
}