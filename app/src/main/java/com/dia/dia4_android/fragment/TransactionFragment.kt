package com.dia.dia4_android.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dia.dia4_android.databinding.FragmentTransactionBinding
import com.dia.dia4_android.rv.TransactionAdapter
import com.dia.dia4_android.rv.TransactionModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TransactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransactionFragment : Fragment(), TransactionAdapter.TransactionCallback {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentTransactionBinding
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTransaction.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }

        val transactionList = arrayListOf<TransactionModel>()
        transactionList.add(
            TransactionModel(1, "Rp 100.000", "Sender1", "Receiver1", "Success", "17:00:00 2022-01-01", "Credit")
        )
        transactionList.add(
            TransactionModel(2, "Rp 200.000", "Sender2", "Receiver2", "Success", "17:00:00 2022-01-02", "Credit")
        )
        transactionList.add(
            TransactionModel(3, "Rp 300.000", "Sender3", "Receiver3", "Success", "17:00:00 2022-01-03", "Debit")
        )

        transactionAdapter = TransactionAdapter(transactionList, this)
        binding.rvTransaction.adapter = transactionAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TransactionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransactionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onTransactionSelected(transactionModel: TransactionModel) {
        Log.i("Logger", "Transaction selected ${transactionModel.id}")
    }
}