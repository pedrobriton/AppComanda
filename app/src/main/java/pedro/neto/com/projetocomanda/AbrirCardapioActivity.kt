package pedro.neto.com.projetocomanda

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cardapio.*
import scarlet.machado.lmsapp.*

class AbrirCardapioActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardapio)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "CARDÁPIO.:"

        recycler_produtos?.layoutManager = LinearLayoutManager(this)


    }

    private var produtos = listOf<Produto>()
    override fun onResume() {
        super.onResume()
        produtos = ProdutoService.getProdutos()
        recycler_produtos?.adapter = ProdutoAdapter(produtos) {
            onClickProduto(it)
        }
    }

    fun onClickProduto(produto: Produto){
        Toast.makeText(this, "Clicou produto ${produto.nome}", Toast.LENGTH_LONG).show()
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