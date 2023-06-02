package uz.hamroev.riskanalysis.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.riskanalysis.R
import uz.hamroev.riskanalysis.adapters.ResultsAdapter
import uz.hamroev.riskanalysis.database.ResultDatabase
import uz.hamroev.riskanalysis.database.ResultEntity
import uz.hamroev.riskanalysis.databinding.FragmentSavedBinding
import uz.hamroev.riskanalysis.utils.gone
import uz.hamroev.riskanalysis.utils.visible

class SavedFragment : Fragment() {

    private lateinit var binding: FragmentSavedBinding
    lateinit var resultDatabase: ResultDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSavedBinding.inflate(layoutInflater)

        resultDatabase = ResultDatabase.getInstance(binding.root.context)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        val list = resultDatabase.resultDao().getAllResults().reversed()

        if (list.isNotEmpty()){
            //print
            binding.one.gone()
            binding.two.visible()
            val resultAdapter = ResultsAdapter(binding.root.context, list, object : ResultsAdapter.OnMyClickListener{
                override fun onShare(resultEntity: ResultEntity, position: Int) {

                    var message: String = ""
                    var shareMessage: String =
                        "https://play.google.com/store/apps/details?id="
                    shareMessage = "https://play.google.com/store/apps/details?id=" + activity?.packageName
                    val name = "Med - Analysis"
                    message = "$name\n\n" +
                            "* * * * * * *\n" +
                            "Диагностический номер: ${list[position].id}\n" +
                            "Пользователь: ${list[position].fio}\n" +
                            "${list[position].countBall}\n" +
                            "Диагноз: ${list[position].diagnos}\n" +
                            "Время: ${list[position].date}" +
                            "\n" +
                            "\n* * * * * * *\n" +
                            "$shareMessage"

                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    val chooser = Intent.createChooser(intent, "Share using...")
                    startActivity(chooser)

                }

                override fun onInfoResult(resultEntity: ResultEntity, position: Int) {

                }
            })
            binding.rvSavedImage.adapter = resultAdapter
        } else {
            // view empty animation
            binding.one.visible()
            binding.two.gone()
        }



        return binding.root
    }


}