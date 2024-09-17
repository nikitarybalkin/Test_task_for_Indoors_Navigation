package com.features.timetable.presentation

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.core.di.ViewModelFactory
import com.example.core.utils.TransportTypes
import com.features.timetable.R
import com.features.timetable.databinding.FragmentTimetableBinding
import com.features.timetable.di.TimetableComponent
import com.features.timetable.di.TimetableComponentProvider
import kotlinx.coroutines.delay
import javax.inject.Inject

class TimetableFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var timetableComponent: TimetableComponent
    private lateinit var binding: FragmentTimetableBinding
    private lateinit var viewModel: EnterParametersViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        timetableComponent =
            (requireActivity().applicationContext as TimetableComponentProvider).provideTimetableComponent()
        timetableComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[EnterParametersViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTimetableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            if (arguments?.getString("date") != null) {
                viewModel.date = arguments?.getString("date")!!
            }
            if (arguments?.getString("transport") != null) {
                when (arguments?.getString("transport")) {
                    "plane" -> viewModel.transport = TransportTypes.plane
                    "bus" -> viewModel.transport = TransportTypes.bus
                    "suburban" -> viewModel.transport = TransportTypes.suburban
                    "train" -> viewModel.transport = TransportTypes.train
                    else -> viewModel.transport = TransportTypes.any
                }
            }
            viewModel.sendDataToServer()
            viewModel.timetable.collect{
                if (it != null) {
                    binding.rvTimetable.adapter = OneTimetableAdapter(it)
                }
            }
        }

    }
}