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

    var lucky = (1..100).random()

    Box(
        modifier = modifier.fillMaxSize(), // 讓 Box 填滿整個螢幕
        contentAlignment = Alignment.Center // 水平與垂直置中
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "樂透數字(1-100)為 $lucky"
            )
            Button(
                onClick = { lucky = (1..100).random() }
            ) {
                Text("重新產生樂透碼")
            }
        }
    }
}

