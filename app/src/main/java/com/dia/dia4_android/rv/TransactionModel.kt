package com.dia.dia4_android.rv

data class TransactionModel(
    val id: Int,
    val amount: String,
    val senderName: String,
    val receiverName: String,
    val transactionStatus: String,
    val date: String,
    val type: String
)
