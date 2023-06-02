package uz.hamroev.riskanalysis.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.riskanalysis.R
import uz.hamroev.riskanalysis.database.ResultDatabase
import uz.hamroev.riskanalysis.databinding.FragmentResultBinding
import java.text.SimpleDateFormat
import java.util.*

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    lateinit var resultDatabase: ResultDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)

        resultDatabase = ResultDatabase.getInstance(binding.root.context)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }







        return binding.root
    }


    private fun getCurrentDateAndTime(): String {
        val dateAndTime: Date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val date = dateFormat.format(dateAndTime)
        val time = timeFormat.format(dateAndTime)
        val vaqt: String = "$date - $time"
        //Toast.makeText(this, "$vaqt", Toast.LENGTH_SHORT).show()
        return vaqt

    }



}