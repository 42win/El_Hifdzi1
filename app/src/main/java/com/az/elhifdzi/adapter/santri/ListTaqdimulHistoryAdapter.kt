package com.az.elhifdzi.adapter.santri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.az.elhifdzi.R
import com.az.elhifdzi.model.santri.TahfizulSurah
import com.az.elhifdzi.model.santri.TaqdimulHistory
import kotlinx.android.synthetic.main.item_row_history_taqdimul.view.*
import kotlinx.android.synthetic.main.item_row_surah.view.*
import kotlinx.android.synthetic.main.item_row_surah.view.cvSurah
import kotlinx.android.synthetic.main.item_row_surah.view.tvSurahName

class ListTaqdimulHistoryAdapter (private val listData: List<TaqdimulHistory>) : RecyclerView.Adapter<ListTaqdimulHistoryAdapter.ListViewHolder>() {

    //for itemOnclick Listenter
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TaqdimulHistory)
    }
    //end for itemOnclick Listenter

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListTaqdimulHistoryAdapter.ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_history_taqdimul,viewGroup,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ListTaqdimulHistoryAdapter.ListViewHolder, position: Int) {
        holder.bind(listData[position],position)
    }

    inner class ListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data:TaqdimulHistory, position: Int){
            with(itemView){
                tvDate.text = data.date
                tvSurahName.text = data.namaSurah
                var sts = data.stsUstadz

                if(sts==0){
                    icStatus.setBackgroundResource(R.drawable.ic_sts_pending)
                }else if (sts==1){
                    icStatus.setBackgroundResource(R.drawable.ic_sts_approve)
                }else{
                    icStatus.setBackgroundResource(R.drawable.ic_sts_reject)
                }

                cvTaqdimulHistory.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
            }
        }
    }

}