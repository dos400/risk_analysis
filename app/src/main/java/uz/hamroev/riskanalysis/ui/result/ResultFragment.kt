package uz.hamroev.riskanalysis.ui.result

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.riskanalysis.R
import uz.hamroev.riskanalysis.cache.Cache
import uz.hamroev.riskanalysis.database.ResultDatabase
import uz.hamroev.riskanalysis.database.ResultEntity
import uz.hamroev.riskanalysis.databinding.FragmentResultBinding
import java.text.SimpleDateFormat
import java.util.*

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    lateinit var resultDatabase: ResultDatabase

    var a = ""
    var b = ""
    var c = ""

    var d1 = 0
    var d2 = 0
    var d3 = 0
    var d4 = 0
    var d5 = 0
    var d6 = 0
    var d7 = 0
    var d8 = 0

    var e1 = 0
    var e2 = 0
    var e3 = 0
    var e4 = 0
    var e5 = 0
    var e6 = 0
    var e7 = 0

    var f1 = 0
    var f2 = 0
    var f3 = 0
    var f4 = 0
    var f5 = 0
    var f6 = 0

    var g1 = 0
    var g2 = 0
    var g3 = 0
    var g4 = 0
    var g5 = 0
    var g6 = 0

    var h = ""

    var i1 = ""
    var i2 = ""
    var i3 = ""
    var i4 = ""
    var i5 = ""
    var i6 = ""

    var j = ""

    var k1 = ""
    var k2 = ""
    var resultEntity = ResultEntity()

    var risk = ""
    var recommend = ""
    var algorithm = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)

        resultDatabase = ResultDatabase.getInstance(binding.root.context)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        arguments.let { bundle ->
            a = bundle!!.getString("a", "")
            b = bundle.getString("b", "")
            c = bundle.getString("c", "")

            d1 = bundle.getInt("d1", 0)
            d2 = bundle.getInt("d2", 0)
            d3 = bundle.getInt("d3", 0)
            d4 = bundle.getInt("d4", 0)
            d5 = bundle.getInt("d5", 0)
            d6 = bundle.getInt("d6", 0)
            d7 = bundle.getInt("d7", 0)
            d8 = bundle.getInt("d8", 0)


            e1 = bundle.getInt("e1", 0)
            e2 = bundle.getInt("e2", 0)
            e3 = bundle.getInt("e3", 0)
            e4 = bundle.getInt("e4", 0)
            e5 = bundle.getInt("e5", 0)
            e6 = bundle.getInt("e6", 0)
            e7 = bundle.getInt("e7", 0)

            f1 = bundle.getInt("f1", 0)
            f2 = bundle.getInt("f2", 0)
            f3 = bundle.getInt("f3", 0)
            f4 = bundle.getInt("f4", 0)
            f5 = bundle.getInt("f5", 0)
            f6 = bundle.getInt("f6", 0)

            g1 = bundle.getInt("g1", 0)
            g2 = bundle.getInt("g2", 0)
            g3 = bundle.getInt("g3", 0)
            g4 = bundle.getInt("g4", 0)
            g5 = bundle.getInt("g5", 0)
            g6 = bundle.getInt("g6", 0)

            h = bundle.getString("h", "")

            i1 = bundle.getString("i1", "")
            i2 = bundle.getString("i2", "")
            i3 = bundle.getString("i3", "")
            i4 = bundle.getString("i4", "")
            i5 = bundle.getString("i5", "")
            i6 = bundle.getString("i6", "")

            j = bundle.getString("j", "")

            k1 = bundle.getString("k1", "")
            k2 = bundle.getString("k2", "")


        }


        checkVariant()
        checkAlgorithm()
        resultEntity.fio = Cache.name
        resultEntity.birth = Cache.birth
        resultEntity.sex = Cache.sex
        resultEntity.address = Cache.address
        resultEntity.date = getCurrentDateAndTime()

        resultDatabase.resultDao().addResult(resultEntity)

        binding.shareLayout.setOnClickListener {
            var message: String = ""
            var shareMessage: String =
                "https://play.google.com/store/apps/details?id="
            shareMessage = "https://play.google.com/store/apps/details?id=" + activity?.packageName
            val name = "Risk - Analysis"
            message = "$name\n\n" +
                    "* * * * * * *\n" +
                    "${activity?.resources!!.getString(R.string.user)}: ${Cache.name}\n" +
                    "${activity?.resources!!.getString(R.string.sex)}: ${Cache.sex}\n" +
                    "${activity?.resources!!.getString(R.string.born)}: ${Cache.birth}\n" +
                    "${activity?.resources!!.getString(R.string.address)}: ${Cache.address}\n" +

                    "${activity?.resources!!.getString(R.string.risk)}: ${risk}\n" +
                    "${activity?.resources!!.getString(R.string.recommned)}: ${recommend}\n" +
                    "${algorithm}\n" +

                    "${activity?.resources!!.getString(R.string.time)}: ${getCurrentDateAndTime()}" +
                    "\n" +
                    "\n* * * * * * *\n" +
                    "$shareMessage"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, message)
            val chooser = Intent.createChooser(intent, "Share using...")
            startActivity(chooser)
        }







        return binding.root
    }

    private fun checkAlgorithm() {
        val sumD = d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8
        val sumE = e1 + e2 + e3 + e4 + e5 + e6 + e7
        val sumF = f1 + f2 + f3 + f4 + f5 + f6
        val sumG = g1 + g2 + g3 + g4 + g5 + g6


        if (a == "" && b == "" && c == "" && sumD == 0 && sumE == 0 && sumF == 0 && sumG == 0 && h != "h1") {
            binding.algorithmTv.text = resources.getString(R.string.algorithm1)
            resultEntity.algorithmtext = resources.getString(R.string.algorithm1)
            algorithm = resources.getString(R.string.algorithm1)
        } else if (e4 == 0 && e5 == 0 && e5 == 0 && f5 == 0 && g2 == 0 && i2 != "i2") {
            binding.algorithmTv.text = resources.getString(R.string.algorithm2)
            resultEntity.algorithmtext = resources.getString(R.string.algorithm2)
            algorithm = resources.getString(R.string.algorithm2)

        } else if (sumF == 0 && sumG == 0 && (j != "j1" || j != "j2" || j != "j3") && (k1 != "k1" || k2 != "k2")) {
            binding.algorithmTv.text = resources.getString(R.string.algorithm3)
            resultEntity.algorithmtext = resources.getString(R.string.algorithm3)
            algorithm = resources.getString(R.string.algorithm3)

        } else if (sumF == 0 && sumG == 0 && i1 != "i1" && i3 != "i4") {
            binding.algorithmTv.text = resources.getString(R.string.algorithm4)
            resultEntity.algorithmtext = resources.getString(R.string.algorithm4)
            algorithm = resources.getString(R.string.algorithm4)

        }
        else if (e1 == 0 && e4 == 0 && e5 == 0 && e6 == 0 && f2 == 0 && f3 == 0 && f5 == 0 && g2 == 0 && g3 == 0 && g5 == 0
            && j == ""
        ) {
            binding.algorithmTv.text = resources.getString(R.string.algorithm5)
            resultEntity.algorithmtext = resources.getString(R.string.algorithm5)
            algorithm = resources.getString(R.string.algorithm5)

        } else if (f1 == 0 && f5 == 0 && g1 == 0 && g5 == 0 && i5 == "" && i6 == "") {
            binding.algorithmTv.text = resources.getString(R.string.algorithm6)
            algorithm = resources.getString(R.string.algorithm6)

        } else {
            binding.algorithmTv.text = resources.getString(R.string.algorithm3)
            algorithm = resources.getString(R.string.algorithm3)
        }


    }

    private fun checkVariant() {
        val sumD = d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8
        val sumE = e1 + e2 + e3 + e4 + e5 + e6 + e7
        val sumF = f1 + f2 + f3 + f4 + f5 + f6
        val sumG = g1 + g2 + g3 + g4 + g5 + g6
        val sumK = k1 + k2

        if ((a == "a1" && b == "b1" && c == "c1") && sumD <= 2 && sumE <= 2 && sumG <= 2) {
            variant1()
        } else
            if (((a == "a1" || a == "a2") && b == "b1" && c == "c2") && sumD <= 4 && sumE <= 3 && sumG <= 2
                && h == "h1" && (i4.toInt() < 2 || i5.toInt() < 3) && j == "j1"
            ) {
                variant2()
            } else
                if ((a == "a2" && b == "b2" && c == "c2") && sumD >= 4 && sumE >= 4 && sumF >= 3 && sumG >= 3
                    && h == "h1" && (i4.toInt() < 3 || i5.toInt() < 4) && (j == "j2" || j == "j3")
                    && (k1 == "k1" || k2 == "k2")
                ) {
                    variant3()
                } else {
                    variant2()
                }

    }

    private fun showData() {
        binding.timeTv.text = "" +
                "a = ${a}\n" +
                "b = ${b}\n" +
                "c = ${c}\n" +

                "d1 = ${d1}\n" +
                "d2 = ${d2}\n" +
                "d3 = ${d3}\n" +
                "d4 = ${d4}\n" +
                "d5 = ${d5}\n" +
                "d6 = ${d6}\n" +
                "d7 = ${d7}\n" +
                "d8 = ${d8}\n" +

                "e1 = ${e1}\n" +
                "e2 = ${e2}\n" +
                "e3 = ${e3}\n" +
                "e4 = ${e4}\n" +
                "e5 = ${e5}\n" +
                "e6 = ${e6}\n" +
                "e7 = ${e7}\n" +

                "f1 = ${f1}\n" +
                "f2 = ${f2}\n" +
                "f3 = ${f3}\n" +
                "f4 = ${f4}\n" +
                "f5 = ${f5}\n" +
                "f6 = ${f6}\n" +

                "g1 = ${g1}\n" +
                "g2 = ${g2}\n" +
                "g3 = ${g3}\n" +
                "g4 = ${g4}\n" +
                "g5 = ${g5}\n" +
                "g6 = ${g6}\n" +

                "h = ${h}\n" +

                "i1 = ${i1}\n" +
                "i2 = ${i2}\n" +
                "i3 = ${i3}\n" +
                "i4 = ${i4}\n" +
                "i5 = ${i5}\n" +
                "i6 = ${i6}\n" +

                "j = ${j}\n" +

                "k1 = ${k1}\n" +
                "k2 = ${k2}\n" +


                ""
    }


    private fun variant1() {
        binding.apply {
            nameTv.text = Cache.name
            recommendationTv.text = resources.getString(R.string.recommendation1)
            riskTv.text = resources.getString(R.string.risk1)

            resultEntity.recommendation = resources.getString(R.string.recommendation1)
            resultEntity.risktype = resources.getString(R.string.risk1)

            recommend = resources.getString(R.string.recommendation1)
            risk = resources.getString(R.string.risk1)

            timeTv.text = getCurrentDateAndTime()
        }
    }

    private fun variant2() {
        binding.apply {
            nameTv.text = Cache.name
            recommendationTv.text = resources.getString(R.string.recommendation2)
            riskTv.text = resources.getString(R.string.risk2)
            timeTv.text = getCurrentDateAndTime()
            resultEntity.recommendation = resources.getString(R.string.recommendation2)
            resultEntity.risktype = resources.getString(R.string.risk2)

            recommend = resources.getString(R.string.recommendation2)
            risk = resources.getString(R.string.risk2)
        }
    }

    private fun variant3() {
        binding.apply {
            nameTv.text = Cache.name
            recommendationTv.text = resources.getString(R.string.recommendation3)
            riskTv.text = resources.getString(R.string.risk3)
            timeTv.text = getCurrentDateAndTime()
            resultEntity.recommendation = resources.getString(R.string.recommendation3)
            resultEntity.risktype = resources.getString(R.string.risk3)
            recommend = resources.getString(R.string.recommendation3)
            risk = resources.getString(R.string.risk3)
        }
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