package alura.orgs.ui.recylerview.adapter

import alura.orgs.model.Produto
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListaProdutoAdapter(
    private val produtos: List<Produto>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
