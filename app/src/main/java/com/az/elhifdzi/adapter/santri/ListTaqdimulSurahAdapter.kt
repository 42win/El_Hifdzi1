package com.az.elhifdzi.adapter.santri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.az.elhifdzi.R
import com.az.elhifdzi.model.santri.TahfizulSurah
import kotlinx.android.synthetic.main.item_row_surah.view.*

class ListTaqdimulSurahAdapter (private val listData: List<TahfizulSurah>) : RecyclerView.Adapter<ListTaqdimulSurahAdapter.ListViewHolder>() {

    //for itemOnclick Listenter
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TahfizulSurah)
    }
    //end for itemOnclick Listenter

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListTaqdimulSurahAdapter.ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_surah,viewGroup,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ListTaqdimulSurahAdapter.ListViewHolder, position: Int) {
        holder.bind(listData[position],position)
    }

    inner class ListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data:TahfizulSurah, position: Int){
            with(itemView){
                tvSurahNumber.text = data.idSurah.toString()
                tvSurahName.text = data.namaSurah
                tvSurahJumlah.text = data.jumlahAyat.toString()+" Ayat"

                cvSurah.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
            }
        }
    }

}