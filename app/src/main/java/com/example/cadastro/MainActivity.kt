package com.example.cadastro
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nomeEditText: EditText
    private lateinit var telefoneEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var femininoRadio: RadioButton
    private lateinit var masculinoRadio: RadioButton
    private lateinit var cidadeEditText: EditText
    private lateinit var ufSpinner: Spinner
    private lateinit var limparButton: Button

    private lateinit var salvarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nomeEditText = findViewById(R.id.nomeEditText)
        telefoneEditText = findViewById(R.id.telefoneEditText)
        emailEditText = findViewById(R.id.emailEditText)
        checkBox = findViewById(R.id.checkBox)
        femininoRadio = findViewById(R.id.femininoRadio)
        masculinoRadio = findViewById(R.id.masculinoRadio)
        cidadeEditText = findViewById(R.id.cidadeEditText)
        ufSpinner = findViewById(R.id.ufSpinner)
        limparButton = findViewById(R.id.limparButton)
        salvarButton = findViewById(R.id.salvarButton)
        val ufList = arrayOf("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ufList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ufSpinner.adapter = adapter

        salvarButton.setOnClickListener {
            val nome = nomeEditText.text.toString()
            val telefone = telefoneEditText.text.toString()
            val email = emailEditText.text.toString()
            val ingressarListaEmails = checkBox.isChecked
            val sexo = if (femininoRadio.isChecked) "Feminino" else "Masculino"
            val cidade = cidadeEditText.text.toString()
            val uf = ufSpinner.selectedItem.toString()

            val formulario = Formulario(nome, telefone, email, ingressarListaEmails, sexo, cidade, uf)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }
        limparButton.setOnClickListener {
            nomeEditText.text.clear()
            telefoneEditText.text.clear()
            emailEditText.text.clear()
            checkBox.isChecked = false
            femininoRadio.isChecked = false
            masculinoRadio.isChecked = false
            cidadeEditText.text.clear()
            ufSpinner.setSelection(0)
        }
    }
}