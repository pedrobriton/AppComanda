package pedro.neto.com.projetocomanda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import scarlet.machado.lmsapp.R

class CadastrarActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anotar_pedido)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "INSERIR PEDIDO"

        val btn_confirm_comanda = findViewById<Button>(R.id.btn_confirmar_comanda)
        val btn_consultar_cardapio = findViewById<Button>(R.id.btn_consultar_cardapio)
        val btn_abrir_comanda = findViewById<Button>(R.id.BtnAbrirNovaComanda)

        btn_confirm_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AnotarPedidoActivity::class.java)
            startActivity(intent)
        })

        btn_consultar_cardapio.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AbrirCardapioActivity::class.java)
            startActivity(intent)
        })

        btn_abrir_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AbrirComandaActivity::class.java)
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