package pedro.neto.com.projetocomanda

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import scarlet.machado.lmsapp.R

class AnotarPedidoActivity : DebugActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anotar_pedido2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "INSERIR PEDIDO"

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