package me.projekt401.projkt.ui.firstScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import me.projekt401.projkt.R
import me.projekt401.projkt.databinding.FragmentFirstScreenBinding


class FirstScreenFragment : Fragment() {

    private lateinit var binding: FragmentFirstScreenBinding
    private lateinit var viewModel: FirstScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            /* param1 = it.getString(ARG_PARAM1) */
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FirstScreenViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnNextScreen.apply {
            setOnClickListener {
                goToNextScreen(requireView())
            }
        }

        return binding.root
    }

    private fun goToNextScreen(view: View) {
        view.findNavController().navigate(FirstScreenFragmentDirections.actionFirstScreenFragmentToSecondScreenFragment())
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstScreenFragment().apply {
                arguments = Bundle().apply {
                    /* putString(ARG_PARAM1, param1) */
                }
            }
    }
}