package me.projekt401.projkt.ui.secondScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import me.projekt401.projkt.adapters.MultipleViewAdapter
import me.projekt401.projkt.databinding.FragmentSecondScreenBinding
import me.projekt401.projkt.models.Questions
import me.projekt401.projkt.ui.secondScreen.SecondScreenViewModel.Companion.ERROR
import me.projekt401.projkt.ui.secondScreen.SecondScreenViewModel.Companion.IN_PROGRESS
import me.projekt401.projkt.ui.secondScreen.SecondScreenViewModel.Companion.SUCCESS


class SecondScreenFragment : Fragment() {

    private lateinit var binding: FragmentSecondScreenBinding
    private lateinit var viewModel: SecondScreenViewModel
    private var listener: SecondFragmentListener? = null
    private lateinit var questionsAdapter: MultipleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondScreenViewModel::class.java)
        questionsAdapter = MultipleViewAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        initRecyclerView(requireContext())
        observeDataTransmission()
        getData()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SecondFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement SecondFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun getData() {
        viewModel.getQuestions()
    }

    private fun initRecyclerView(context: Context) {
        binding.recyclerViewListaPreguntas.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = questionsAdapter
        }
    }

    private fun observeDataTransmission() {
        viewModel.requestStatus.observe(viewLifecycleOwner, Observer { requestStatus ->
            when (requestStatus) {
                IN_PROGRESS -> {
                    listener?.showLoading()
                }

                SUCCESS -> {
                    listener?.hideLoading()
                    questionsAdapter.enviarListaDeItems(viewModel.questionsInfo.value!!.questions)
                    questionsAdapter.notifyDataSetChanged()
                }

                ERROR -> {
                    listener?.hideLoading()
                }

                else -> {
                    listener?.hideLoading()
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        listener?.hideLoading()
    }

    interface SecondFragmentListener {
        fun showLoading()
        fun hideLoading()
    }
}