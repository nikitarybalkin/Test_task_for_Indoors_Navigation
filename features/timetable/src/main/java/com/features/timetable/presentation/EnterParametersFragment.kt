package com.features.timetable.presentation

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.features.timetable.databinding.FragmentEnterParametersBinding
import com.features.timetable.di.TimetableComponent
import com.features.timetable.di.TimetableComponentProvider
import javax.inject.Inject
import com.example.core.di.ViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.core.utils.TransportTypes
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class EnterParametersFragment : Fragment() {

    @Inject
    lateinit var timetableRouter: TimetableRouter
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var timetableComponent: TimetableComponent
    private lateinit var binding: FragmentEnterParametersBinding
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
        binding = FragmentEnterParametersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawAllElements()
        binding.ivBackground1.setOnClickListener {
            val calendar = Calendar.getInstance()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val todayDate = dateFormat.format(calendar.time)
            viewModel.date = todayDate
            drawAllElements()
        }
        binding.ivBackground2.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val tomorrowDate = dateFormat.format(calendar.time)
            viewModel.date = tomorrowDate
            drawAllElements()
        }
        binding.ivBackground3.setOnClickListener {
            showDatePickerDialog()
        }
        binding.cvAny.setOnClickListener {
            viewModel.transport = TransportTypes.any
            drawAllElements()
        }
        binding.cvPlane.setOnClickListener {
            viewModel.transport = TransportTypes.plane
            drawAllElements()
        }
        binding.cvTrain.setOnClickListener {
            viewModel.transport = TransportTypes.train
            drawAllElements()
        }
        binding.cvSuburban.setOnClickListener {
            viewModel.transport = TransportTypes.suburban
            drawAllElements()
        }
        binding.cvBus.setOnClickListener {
            viewModel.transport = TransportTypes.bus
            drawAllElements()
        }
        binding.ivTurnOver.setOnClickListener {
            val first: String = binding.edCityFrom.text.toString()
            binding.edCityFrom.text = binding.edCityTo.text
            binding.edCityTo.setText(first)
        }
        binding.bFind.setOnClickListener {
            if (binding.edCityTo.text.toString() != "" && binding.edCityFrom.text.toString() != "") {
                timetableRouter.goToTimetableFragment(this, date = viewModel.date, transport = viewModel.transport.name)
            } else Toast.makeText(
                requireActivity().applicationContext,
                resources.getString(com.example.core.R.string.fill_all),
                Toast.LENGTH_SHORT
            ).show()
        }


    }

    private fun drawAllElements() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val tomorrowDate = dateFormat.format(calendar.time)
        when (viewModel.date) {
            SimpleDateFormat(
                "yyyy-MM-dd",
                Locale.getDefault()
            ).format(Calendar.getInstance().time) -> {
                binding.ivBackground1.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.dark_grey)
                )
                binding.ivBackground2.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.grey)
                )
                binding.ivBackground3.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.grey)
                )
            }

            tomorrowDate -> {

                binding.ivBackground1.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.grey)
                )
                binding.ivBackground2.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.dark_grey)
                )
                binding.ivBackground3.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.grey)
                )
            }

            else -> {
                binding.ivBackground1.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.grey)
                )
                binding.ivBackground2.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.grey)
                )
                binding.ivBackground3.setBackgroundColor(
                    resources.getColor(com.example.core.R.color.dark_grey)
                )
            }
        }
        when (viewModel.transport) {

            TransportTypes.any -> {
                binding.tvAny.setTextColor(resources.getColor(com.example.core.R.color.white))
                binding.ivPlane.setImageResource(com.example.core.R.drawable.plane)
                binding.ivTrain.setImageResource(com.example.core.R.drawable.train)
                binding.ivSuburban.setImageResource(com.example.core.R.drawable.electro_train)
                binding.ivBus.setImageResource(com.example.core.R.drawable.bus)

            }

            TransportTypes.plane -> {
                binding.tvAny.setTextColor(resources.getColor(com.example.core.R.color.black))
                binding.ivPlane.setImageResource(com.example.core.R.drawable.plane_light)
                binding.ivTrain.setImageResource(com.example.core.R.drawable.train)
                binding.ivSuburban.setImageResource(com.example.core.R.drawable.electro_train)
                binding.ivBus.setImageResource(com.example.core.R.drawable.bus)

            }

            TransportTypes.train -> {
                binding.tvAny.setTextColor(resources.getColor(com.example.core.R.color.black))
                binding.ivPlane.setImageResource(com.example.core.R.drawable.plane)
                binding.ivTrain.setImageResource(com.example.core.R.drawable.train_light)
                binding.ivSuburban.setImageResource(com.example.core.R.drawable.electro_train)
                binding.ivBus.setImageResource(com.example.core.R.drawable.bus)

            }

            TransportTypes.suburban -> {
                binding.tvAny.setTextColor(resources.getColor(com.example.core.R.color.black))
                binding.ivPlane.setImageResource(com.example.core.R.drawable.plane)
                binding.ivTrain.setImageResource(com.example.core.R.drawable.train)
                binding.ivSuburban.setImageResource(com.example.core.R.drawable.electro_train_light)
                binding.ivBus.setImageResource(com.example.core.R.drawable.bus)

            }

            TransportTypes.bus -> {
                binding.tvAny.setTextColor(resources.getColor(com.example.core.R.color.black))
                binding.ivPlane.setImageResource(com.example.core.R.drawable.plane)
                binding.ivTrain.setImageResource(com.example.core.R.drawable.train)
                binding.ivSuburban.setImageResource(com.example.core.R.drawable.electro_train)
                binding.ivBus.setImageResource(com.example.core.R.drawable.bus_light)

            }

        }
    }

    private fun showDatePickerDialog() {
        // Получаем текущую дату
        val calendar = Calendar.getInstance()
        var selectedDate = ""
        val datePickerDialog = DatePickerDialog(
            requireActivity(),
            { _, year, month, dayOfMonth ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, dayOfMonth)

                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                viewModel.date = dateFormat.format(selectedCalendar.time)
                drawAllElements()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }
}
