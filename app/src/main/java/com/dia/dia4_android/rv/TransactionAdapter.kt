package com.dia.dia4_android.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dia.dia4_android.databinding.TransactionItemBinding

class TransactionAdapter(
        val transactionList: ArrayList<TransactionModel>,
        val transactionCallback: TransactionCallback) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(val binding: TransactionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener{
                val transactionSelected = transactionList[adapterPosition]
                transactionCallback.onTransactionSelected(transactionSelected)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = TransactionItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransactionViewHolder(binding)
    }

    override fun getItemCount(): Int = transactionList.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transactionHistory = transactionList[position]
        with(holder) {
            binding.tvId.text = transactionHistory.id.toString()
            binding.tvAmount.text = transactionHistory.amount
            binding.tvSender.text = transactionHistory.senderName
            binding.tvReceiver.text = transactionHistory.receiverName
            binding.tvStatus.text = transactionHistory.transactionStatus
            binding.tvDate.text = transactionHistory.date
            binding.tvType.text = transactionHistory.type
        }
    }

    interface TransactionCallback{
        fun onTransactionSelected(transactionModel: TransactionModel)
    }
}