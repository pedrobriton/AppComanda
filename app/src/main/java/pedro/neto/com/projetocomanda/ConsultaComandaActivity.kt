package pedro.neto.com.projetocomanda

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cardapio.*
import scarlet.machado.lmsapp.R

class ConsultaComandaActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comandas)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "COMANDAS EM ABERTO.:"

        recycler_produtos?.layoutManager = LinearLayoutManager(this)
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