package pedro.neto.com.projetocomanda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import scarlet.machado.lmsapp.R

class AbrirComandaActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abrir_comanda)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "ABRIR COMANDA.:"

        val btn_abrir_comanda = findViewById<Button>(R.id.add_comanda)
        val btn_cancelar_abertura_comanda = findViewById<Button>(R.id.cancelar_comanda)

        btn_abrir_comanda.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "CLICADO NO BOTÃO SALVAR",
                Toast.LENGTH_LONG).show()
        })

        btn_cancelar_abertura_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, TelaInicialActivity::class.java)
            Toast.makeText(this, "CLICADO NO BOTÃO CANCELAR",
                Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == android.R.id.home){
            finish()
        }

        else if(id == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}