package tw.edu.pu.csim.s1131224.myapplication


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
