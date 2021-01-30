package com.az.elhifdzi.adapter.santri
import android.graphics.Color.green
import android.graphics.Color.red
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.az.elhifdzi.R
import com.az.elhifdzi.model.santri.TahfizulResult
import com.az.elhifdzi.model.santri.TahfizulSurah
import kotlinx.android.synthetic.main.item_row_surah.view.*
import kotlinx.android.synthetic.main.item_row_tahfizul_result.view.*

class ListTahfizulResultAdapter (private val listData: List<TahfizulResult>) : RecyclerView.Adapter<ListTahfizulResultAdapter.ListViewHolder>() {

    //for itemOnclick Listenter
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TahfizulResult)
    }
    //end for itemOnclick Listenter

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListTahfizulResultAdapter.ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_tahfizul_result,viewGroup,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ListTahfizulResultAdapter.ListViewHolder, position: Int) {
        holder.bind(listData[position],position)
    }

    inner class ListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data:TahfizulResult, position: Int){
            with(itemView){
                var result = data.evaluation
                var eval = "";

                if(result==1){
                    eval="Benar"
                    divEval.setBackgroundColor(resources.getColor(R.color.colorPrimary))
                }else{
                    eval="Kurang Tepat"
                    divEval.setBackgroundColor(resources.getColor(R.color.red))
                }

                tvEvaluation.text = "("+ data.idSurah + ":" + data.nomorAyat + ") " + eval
                tvAyat.text = data.ayat
                cvResult.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
            }
        }
    }

}