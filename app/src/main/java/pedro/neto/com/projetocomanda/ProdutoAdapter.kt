package pedro.neto.com.projetocomanda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import scarlet.machado.lmsapp.R


class ProdutoAdapter (
    val produtos: List<Produto>,
    val onClick: (Produto) -> Unit

): RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

//    Classe com os elementos que seráo exibidos
    class ProdutosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImage = view.findViewById(R.id.card_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_produtos)
        }
}

    override fun getItemCount() = this.produtos.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)

        val holder =
            ProdutosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val Produto = produtos[position]

        holder.cardNome.text = Produto.nome
        holder.cardProgress.visibility = View.VISIBLE

        val context = holder.itemView.context
        Picasso.with(context).load(Produto.foto).fit().into(holder.cardImage,
            object : com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardImage.setImageResource(R.drawable.imagem_login)
                    holder.cardProgress.visibility = View.GONE
                }
            }        )

        holder.itemView.setOnClickListener{onClick(Produto)}
    }


}