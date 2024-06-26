package com.brian.project101.ui.theme.screens.application

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.brian.project101.data.productviewmodel
import com.brian.project101.navigation.ROUTE_WELCOME

@Composable
fun ApplicationScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Text(
            text = "Application",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Green,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
        var productPrice by remember { mutableStateOf(TextFieldValue("")) }
        var productAddress by remember { mutableStateOf(TextFieldValue("")) }
        var productLocation by remember { mutableStateOf(TextFieldValue("")) }
        var productRequest by remember { mutableStateOf(TextFieldValue(""))}
        var productNumber by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text(text = " Full name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = { Text(text = "Phone number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = productAddress,
            onValueChange = { productAddress = it },
            label = { Text(text = "Email Address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text(text = "Grades( the subjects needed only)",
                ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = productLocation,
            onValueChange = { productLocation = it },
            label = { Text(text = "Country(location)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = productRequest,
            onValueChange = { productRequest = it },
            label = { Text(text = "Do you have a Visa(YES or NO )") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = productNumber,
            onValueChange = { productNumber = it },
            label = { Text(text = "Guardians Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )



        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            val productRepository = productviewmodel(navController,context)
            productRepository.saveProduct(productName.text.trim(),productQuantity.text.trim(),
                productPrice.text.trim(),productAddress.text.trim(),productLocation.text.trim(), productRequest.text.trim(),productNumber.text)
            navController.navigate(ROUTE_WELCOME)


        }) {
            Text(text = "Apply")
        }
        Spacer(modifier = Modifier.height(10.dp))

        //---------------------IMAGE PICKER START-----------------------------------//

        ImagePicker(Modifier,context, navController, productName.text.trim(), productQuantity.text.trim(), productPrice.text.trim())

        //---------------------IMAGE PICKER END-----------------------------------//

    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, quantity:String, price:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                val productRepository = productviewmodel(navController,context)
                productRepository.saveProductWithImage(name, quantity, price,imageUri!!)


            }) {
                Text(text = "Save")
            }
        }
    }
}


@Preview
@Composable
fun Applicationpre() {
    ApplicationScreen(rememberNavController())

}