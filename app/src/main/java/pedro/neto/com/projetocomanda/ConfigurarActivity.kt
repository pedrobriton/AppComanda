package pedro.neto.com.projetocomanda

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import scarlet.machado.lmsapp.R

class ConfigurarActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

