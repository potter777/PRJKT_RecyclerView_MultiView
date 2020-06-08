package me.projekt401.projkt.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_step1_questions_date.view.*
import kotlinx.android.synthetic.main.item_step1_questions_number_dui.view.*
import kotlinx.android.synthetic.main.item_step1_questions_number_nit.view.*
import kotlinx.android.synthetic.main.item_step1_questions_phone_number.view.*
import kotlinx.android.synthetic.main.item_step1_questions_single.view.*
import kotlinx.android.synthetic.main.item_step1_questions_text.view.*
import me.projekt401.projkt.R
import me.projekt401.projkt.models.Questions

class MultipleViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_SIMPLE_TEXT = 0
        const val TYPE_DATE = 1
        const val TYPE_SINGLE = 2
        const val TYPE_DUI = 3
        const val TYPE_NIT = 4
        const val TYPE_EMAIL = 5
        const val TYPE_PHONE = 6

        const val API_TYPE_SIMPLE_TEXT = "SIMPLE_TEXT"
        const val API_TYPE_DATE = "DATE"
        const val API_TYPE_SINGLE = "SINGLE"
        const val API_TYPE_DUI = "DUI"
        const val API_TYPE_NIT = "NIT"
        const val API_TYPE_EMAIL = "EMAIL"
        const val API_TYPE_PHONE = "PHONE"
    }

    private var items: List<Questions> = ArrayList()

    fun enviarListaDeItems(questionsList: List<Questions>) {
        items = questionsList
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_SIMPLE_TEXT -> TypeSimpleTextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_text, parent, false))
            TYPE_DATE -> TypeDateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_date, parent, false))
            TYPE_SINGLE -> TypeSingleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_single, parent, false))
            TYPE_DUI -> TypeDuiViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_number_dui, parent, false))
            TYPE_NIT -> TypeNitViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_number_nit, parent, false))
            TYPE_EMAIL -> TypeSimpleTextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_text, parent, false))
            TYPE_PHONE -> TypePhoneViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_phone_number, parent, false))
            else -> TypeSimpleTextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_step1_questions_text, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TypeSimpleTextViewHolder -> {
                holder.bind(items[position])
            }

            is TypeDateViewHolder -> {
                holder.bind(items[position])
            }

            is TypeSingleViewHolder -> {
                holder.bind(items[position])
            }

            is TypeDuiViewHolder -> {
                holder.bind(items[position])
            }

            is TypeNitViewHolder -> {
                holder.bind(items[position])
            }

            is TypePhoneViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return when (item.type) {
            API_TYPE_SIMPLE_TEXT -> TYPE_SIMPLE_TEXT
            API_TYPE_DATE -> TYPE_DATE
            API_TYPE_SINGLE -> TYPE_SINGLE
            API_TYPE_DUI -> TYPE_DUI
            API_TYPE_NIT -> TYPE_NIT
            API_TYPE_EMAIL -> TYPE_EMAIL
            API_TYPE_PHONE -> TYPE_PHONE
            else -> TYPE_SIMPLE_TEXT
        }
    }

    /*
    * Agregare todos los ViewHolders que hacen falta para completar los 3 "steps"
     */

    inner class TypeSimpleTextViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleSimpleText = itemView.txtTextTitle

        fun bind(questionItem: Questions) {
            titleSimpleText.text = questionItem.text
        }
    }

    inner class TypeDateViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoPrueba = itemView.txtDateTitle

        fun bind(questionItem: Questions) {
            textoPrueba.text = questionItem.text
        }
    }

    inner class TypeSingleViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoPrueba = itemView.txtSingleTitle

        fun bind(questionItem: Questions) {
            textoPrueba.text = questionItem.text
        }
    }

    inner class TypeDuiViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoPrueba = itemView.txtNumberTitle

        fun bind(questionItem: Questions) {
            textoPrueba.text = questionItem.text
        }
    }

    inner class TypeNitViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoPrueba = itemView.txtNumberNitTitle

        fun bind(questionItem: Questions) {
            textoPrueba.text = questionItem.text
        }
    }

    inner class TypeEmailViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoPrueba = itemView.txtDateTitle

        fun bind(questionItem: Questions) {
            textoPrueba.text = questionItem.text
        }
    }

    inner class TypePhoneViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoPrueba = itemView.txtNumberPhoneTitle

        fun bind(questionItem: Questions) {
            textoPrueba.text = questionItem.text
        }
    }

}