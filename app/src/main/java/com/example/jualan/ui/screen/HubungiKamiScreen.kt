package com.example.jualan.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HubungiKamiScreen(navController: NavController) {
    var emailText by remember { mutableStateOf("") }
    var messageText by remember { mutableStateOf("") }
    var problemType by rememberSaveable { mutableStateOf("Pilih Tipe Pesan") }
    var isAgreed by rememberSaveable { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var isEmailValid = emailText.contains("@") && emailText.isNotBlank()
    val isMessageValid = messageText.length >= 10
    val isFormValid = isEmailValid && isMessageValid && isAgreed && problemType != "Pilih Tipe Pesan"
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Hubungi Kami") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text(text = "←")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        
@Composable
fun StatelessFormHubungiKami(
    modifier: Modifier = Modifier,
    email: String, oneEmailChange: (String) -> Unit, isEmailValid: Boolean,
    message: String, oneMessageChange: (String) -> Unit, isMessageValid: Boolean,
    problemType: String, onProblemTypeChange: (String) -> Unit,
    isAgreed: Boolean, onAgreedChange: (Boolean) -> Unit,
    imageUri: Uri?, onImagePicked: (Uri?) -> Unit,
    isFormValid: Boolean, onSubmit: () -> Unit
) {
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? -> onImagePicked(uri) }
    )
    Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Kirim pesan kepada kami")
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = emailText,
                onValueChange = onEmailChange,
                label = { Text(text = "Email Anda") },
                placeholder = { Text(text = "nama@email.com") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = messageText,
                onValueChange = onMessageChange,
                label = { Text(text = "Pesan") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )
            var expanded by remember { mutableStateOf(false) }
            val options = listOf("Pertanyaan", "Keluhan", "Saran")
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = problemType,
                    onValueChange = {},
                    label = { Text(text = "Tipe Pesan") },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    modifier = Modifier.fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { selectedOption ->
                        DropdownMenuItem(
                            text = { Text(text = selectedOption) },
                            onClick = {
                                onProblemTypeChange(selectedOption)
                                expanded = false
                            }
                        )
                    }
                }
            }

            if (imageUri != null){
                Spacer(modifier = Modifier.height(8.dp))
                Card(colos = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
                        Icon(painter = painterResource(id = R.drawable.ic_image), contentDescription = "Selected Image", modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("File terpilih: ${imageUri.lastPathSegment}")
                    }
                    }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                if (isFormValid) {
                        scope.launch {
                            snackbarHostState.showSnackbar("Pesan Terkirim")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Text(text = "Kirim Pesan")
                }
            }
        }
    }
}

}