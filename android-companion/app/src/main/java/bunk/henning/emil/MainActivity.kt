package bunk.henning.emil

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import bunk.henning.emil.model.PermissionModel
import bunk.henning.emil.ui.theme.EmilTheme

// Screen one: Permissions
// Screen two: Connection
// Screen three: ACTION!

// TODO
// Theming

class MainActivity : ComponentActivity() {

    private val viewModel: ViewModel by viewModels { ViewModelFactory(application) }

    private val requestPermissionLauncher = registerForActivityResult(
        RequestMultiplePermissions()
    ) { permissions: MutableMap<String, Boolean>? ->
        permissions?.forEach {
            Toast.makeText(applicationContext, "Permission: ${it.key}:${it.value}", Toast.LENGTH_SHORT).show()
        }
        viewModel.checkPermissions()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EmilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (viewModel.hasPermissions) {
                        Column {
                            Button(onClick = {}) {
                                Text("Brighter")
                            }
                            Button(onClick = {}) {
                                Text("Darker")
                            }
                        }
                    } else {
                        requestPermissionLauncher.launch(PermissionModel.getPermissionStrings())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmilTheme {
        Greeting("Android")
    }
}
