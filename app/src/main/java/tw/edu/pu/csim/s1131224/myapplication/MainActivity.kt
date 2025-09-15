package tw.edu.pu.csim.s1131224.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tw.edu.pu.csim.s1131224.myapplication.ui.theme.LottoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LottoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Play(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Play(modifier: Modifier = Modifier) {
    // 使用 remember 和 mutableStateOf 來記住並更新樂透數字
    var lucky by remember { mutableStateOf((1..100).random()) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // 水平垂直置中
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "樂透數字(1-100)為 $lucky"
            )
            Button(
                onClick = { lucky = (1..100).random() } // 按鈕按下時更新 lucky 值
            ) {
                Text("重新產生樂透碼")
            }
        }
    }
}
