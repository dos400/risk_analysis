package uz.hamroev.riskanalysis.ui

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.riskanalysis.R
import uz.hamroev.riskanalysis.adapters.NavAdapter
import uz.hamroev.riskanalysis.cache.Cache
import uz.hamroev.riskanalysis.databinding.DialogLanguageBinding
import uz.hamroev.riskanalysis.databinding.FragmentHomeBinding
import uz.hamroev.riskanalysis.model.Nav
import uz.hamroev.riskanalysis.utils.toast
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    //nav menu list and navAdapter to down
    private lateinit var listNav: ArrayList<Nav>
    private lateinit var navAdapter: NavAdapter

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.menuButton.setOnClickListener {
            binding.drawerLayout.open()
        }

        binding.manLinear.setOnClickListener {
            Cache.sex = "erkak"
            checkSex()
        }

        binding.womanLinear.setOnClickListener {
            Cache.sex = "ayol"
            checkSex()
        }

        solve()






        loadNav()

        binding.resultButton.setOnClickListener {
            if (binding.fioEt.text.isNotEmpty()) {
                if (binding.userOld.text.isNotEmpty()) {
                    if (Cache.sex != "") {

                        Cache.name = binding.fioEt.text.toString().trim()
                        Cache.birth = binding.userOld.text.toString().trim()
                        Cache.address = binding.userAddress.text.toString().trim()
                        sentOptions()
                        findNavController().navigate(R.id.resultFragment, sentOptions())
                        clearCheck()


                    } else {
                        sentOptions()
                        toast(activity?.resources!!.getString(R.string.input_sex))
                    }
                } else {
                    sentOptions()
                    toast(activity?.resources!!.getString(R.string.input_date))
                }
            } else {
                sentOptions()
                toast(activity?.resources!!.getString(R.string.input_fio))
            }
        }




        return binding.root
    }

    private fun solve() {

        // department a
        binding.includeOptionA.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_button1 -> {
                    a = "a1"
                    hideKeyboard()

                }
                R.id.radio_button2 -> {
                    a = "a2"
                    hideKeyboard()
                }
            }
        }

        // department b
        binding.includeOptionB.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_button1 -> {
                    b = "b1"
                    hideKeyboard()

                }
                R.id.radio_button2 -> {
                    b = "b2"
                    hideKeyboard()
                }
            }
        }

        // department c
        binding.includeOptionC.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_button1 -> {
                    c = "c1"
                    hideKeyboard()

                }
                R.id.radio_button2 -> {
                    c = "c2"
                    hideKeyboard()
                }
            }
        }

        // department d
        binding.apply {
            //d1
            includeCheckerD.d1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d1 = 1
                } else {
                    d1 = 0
                }
            }
            //d2
            includeCheckerD.d2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d2 = 1
                } else {
                    d2 = 0
                }
            }
            //d3
            includeCheckerD.d3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d3 = 1
                } else {
                    d3 = 0
                }
            }
            //d4
            includeCheckerD.d4.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d4 = 1
                } else {
                    d4 = 0
                }
            }
            //d5
            includeCheckerD.d5.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d5 = 1
                } else {
                    d5 = 0
                }
            }
            //d6
            includeCheckerD.d6.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d6 = 1
                } else {
                    d6 = 0
                }
            }
            //d7
            includeCheckerD.d7.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d7 = 1
                } else {
                    d7 = 0
                }
            }
            //d8
            includeCheckerD.d8.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    d8 = 1
                } else {
                    d8 = 0
                }
            }


        }

        // department e
        binding.apply {
            //e1
            includeCheckerE.d1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    e1 = 1
                } else {
                    e1 = 0
                }
            }
            //e2
            includeCheckerE.d2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    e2 = 1
                } else {
                    e2 = 0
                }
            }
            //e3
            includeCheckerE.d3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    e3 = 1
                } else {
                    e3 = 0
                }
            }
            //e4
            includeCheckerE.d4.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    e4 = 1
                } else {
                    e4 = 0
                }
            }
            //e5
            includeCheckerE.d5.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    e5 = 1
                } else {
                    e5 = 0
                }
            }
            //e6
            includeCheckerE.d6.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    e6 = 1
                } else {
                    e6 = 0
                }
            }
            //e7
            includeCheckerE.d7.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    e7 = 1
                } else {
                    e7 = 0
                }
            }


        }

        // department f
        binding.apply {
            //f1
            includeCheckerF.d1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    f1 = 1
                } else {
                    f1 = 0
                }
            }
            //f2
            includeCheckerF.d2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    f2 = 1
                } else {
                    f2 = 0
                }
            }
            //f3
            includeCheckerF.d3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    f3 = 1
                } else {
                    f3 = 0
                }
            }
            //f4
            includeCheckerF.d4.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    f4 = 1
                } else {
                    f4 = 0
                }
            }
            //f5
            includeCheckerF.d5.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    f5 = 1
                } else {
                    f5 = 0
                }
            }
            //f6
            includeCheckerF.d6.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    f6 = 1
                } else {
                    f6 = 0
                }
            }


        }

        // department g
        binding.apply {
            //g1
            includeCheckerG.d1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    g1 = 1
                } else {
                    g1 = 0
                }
            }
            //g2
            includeCheckerG.d2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    g2 = 1
                } else {
                    g2 = 0
                }
            }
            //g3
            includeCheckerG.d3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    g3 = 1
                } else {
                    g3 = 0
                }
            }
            //g4
            includeCheckerG.d4.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    g4 = 1
                } else {
                    g4 = 0
                }
            }
            //g5
            includeCheckerG.d5.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    g5 = 1
                } else {
                    g5 = 0
                }
            }
            //g6
            includeCheckerG.d6.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    g6 = 1
                } else {
                    g6 = 0
                }
            }

            // department h
            binding.includeOptionH.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        h = "h1"
                        hideKeyboard()

                    }
                    R.id.radio_button2 -> {
                        h = "no"
                        hideKeyboard()
                    }
                }
            }

            // department i1
            binding.includeOptionI1.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        i1 = "i1"
                        hideKeyboard()

                    }
                    R.id.radio_button2 -> {
                        i1 = "no"
                        hideKeyboard()
                    }
                }
            }
            // department i2
            binding.includeOptionI2.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        i2 = "i2"
                        hideKeyboard()

                    }
                    R.id.radio_button2 -> {
                        i2 = "no"
                        hideKeyboard()
                    }
                }
            }

            // department i3
            binding.includeOptionI3.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        i3 = "i3"
                        hideKeyboard()

                    }
                    R.id.radio_button2 -> {
                        i3 = "no"
                        hideKeyboard()
                    }
                }
            }

            // department i4
            binding.includeOptionI4.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        i4 = "1"
                        hideKeyboard()
                    }
                    R.id.radio_button2 -> {
                        i4 = "2"
                        hideKeyboard()
                    }
                    R.id.radio_button3 -> {
                        i4 = "3"
                        hideKeyboard()
                    }
                    R.id.radio_button4 -> {
                        i4 = "4"
                        hideKeyboard()
                    }
                }
            }


            // department i5
            binding.includeOptionI5.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        i5 = "1"
                        hideKeyboard()
                    }
                    R.id.radio_button2 -> {
                        i5 = "2"
                        hideKeyboard()
                    }
                    R.id.radio_button3 -> {
                        i5 = "3"
                        hideKeyboard()
                    }
                    R.id.radio_button4 -> {
                        i5 = "4"
                        hideKeyboard()
                    }
                    R.id.radio_button5 -> {
                        i5 = "5"
                        hideKeyboard()
                    }
                }
            }

            // department i6
            binding.includeOptionI6.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        i6 = "i6"
                        hideKeyboard()

                    }
                    R.id.radio_button2 -> {
                        i6 = "no"
                        hideKeyboard()
                    }
                }
            }

            // department j
            binding.includeOptionJ.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radio_button1 -> {
                        j = "j1"
                        hideKeyboard()
                    }
                    R.id.radio_button2 -> {
                        j = "j2"
                        hideKeyboard()
                    }
                    R.id.radio_button3 -> {
                        j = "j3"
                        hideKeyboard()
                    }
                }
            }

            //k1
            includeCheckerK.k1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    k1 = "k1"
                } else {
                    k1 = ""
                }
            }

            //k2
            includeCheckerK.k2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    k2 = "k2"
                } else {
                    k2 = ""
                }
            }


        }


    }

    private fun clearCheck() {
        binding.fioEt.setText("")
        binding.userOld.setText("")
        binding.userAddress.setText("")
        binding.apply {
            includeOptionA.radioGroup.clearCheck()
            includeOptionB.radioGroup.clearCheck()
            includeOptionC.radioGroup.clearCheck()

            includeCheckerD.d1.isChecked = false
            includeCheckerD.d2.isChecked = false
            includeCheckerD.d3.isChecked = false
            includeCheckerD.d4.isChecked = false
            includeCheckerD.d5.isChecked = false
            includeCheckerD.d6.isChecked = false
            includeCheckerD.d7.isChecked = false
            includeCheckerD.d8.isChecked = false

            includeCheckerE.d1.isChecked = false
            includeCheckerE.d2.isChecked = false
            includeCheckerE.d3.isChecked = false
            includeCheckerE.d4.isChecked = false
            includeCheckerE.d5.isChecked = false
            includeCheckerE.d6.isChecked = false
            includeCheckerE.d7.isChecked = false

            includeCheckerF.d1.isChecked = false
            includeCheckerF.d2.isChecked = false
            includeCheckerF.d3.isChecked = false
            includeCheckerF.d4.isChecked = false
            includeCheckerF.d5.isChecked = false
            includeCheckerF.d6.isChecked = false

            includeCheckerG.d1.isChecked = false
            includeCheckerG.d2.isChecked = false
            includeCheckerG.d3.isChecked = false
            includeCheckerG.d4.isChecked = false
            includeCheckerG.d5.isChecked = false
            includeCheckerG.d6.isChecked = false

            includeOptionH.radioGroup.clearCheck()

            includeOptionI1.radioGroup.clearCheck()
            includeOptionI2.radioGroup.clearCheck()
            includeOptionI3.radioGroup.clearCheck()
            includeOptionI4.radioGroup.clearCheck()
            includeOptionI5.radioGroup.clearCheck()
            includeOptionI6.radioGroup.clearCheck()

            includeOptionJ.radioGroup.clearCheck()

            includeCheckerK.k1.isChecked = false
            includeCheckerK.k2.isChecked = false
        }
    }

    private fun sentOptions(): Bundle {
        val bundle = Bundle()

        bundle.putString("a", a)
        bundle.putString("b", b)
        bundle.putString("c", c)

        bundle.putInt("d1", d1)
        bundle.putInt("d2", d2)
        bundle.putInt("d3", d3)
        bundle.putInt("d4", d4)
        bundle.putInt("d5", d5)
        bundle.putInt("d6", d6)
        bundle.putInt("d7", d7)
        bundle.putInt("d8", d8)

        bundle.putInt("e1", e1)
        bundle.putInt("e2", e2)
        bundle.putInt("e3", e3)
        bundle.putInt("e4", e4)
        bundle.putInt("e5", e5)
        bundle.putInt("e6", e6)
        bundle.putInt("e7", e7)

        bundle.putInt("f1", f1)
        bundle.putInt("f2", f2)
        bundle.putInt("f3", f3)
        bundle.putInt("f4", f4)
        bundle.putInt("f5", f5)
        bundle.putInt("f6", f6)

        bundle.putInt("g1", g1)
        bundle.putInt("g2", g2)
        bundle.putInt("g3", g3)
        bundle.putInt("g4", g4)
        bundle.putInt("g5", g5)
        bundle.putInt("g6", g6)

        bundle.putString("h", h)

        bundle.putString("i1", i1)
        bundle.putString("i2", i2)
        bundle.putString("i3", i3)
        bundle.putString("i4", i4)
        bundle.putString("i5", i5)
        bundle.putString("i6", i6)

        bundle.putString("j", j)

        bundle.putString("k1", k1)
        bundle.putString("k2", k2)






        return bundle
    }


    private fun loadNav() {
        listNav = ArrayList()
        listNav.clear()
        listNav.add(Nav(requireActivity().resources.getString(R.string.main), R.drawable.fi_home))
        listNav.add(
            Nav(
                requireActivity().resources.getString(R.string.save),
                R.drawable.fi_bookmark
            )
        )
        listNav.add(Nav(requireActivity().resources.getString(R.string.info), R.drawable.fi_info))
        listNav.add(
            Nav(
                requireActivity().resources.getString(R.string.language),
                R.drawable.fi_globe
            )
        )
        listNav.add(
            Nav(
                requireActivity().resources.getString(R.string.authors),
                R.drawable.fi_users
            )
        )
        listNav.add(
            Nav(
                requireActivity().resources.getString(R.string.share),
                R.drawable.fi_share_2
            )
        )
        listNav.add(Nav(requireActivity().resources.getString(R.string.rate), R.drawable.fi_star))
        listNav.add(
            Nav(
                requireActivity().resources.getString(R.string.exit),
                R.drawable.fi_log_out
            )
        )

        navAdapter = NavAdapter(requireContext(), listNav, object : NavAdapter.OnNavClickListener {
            override fun onCLick(nav: Nav, position: Int) {
                when (position) {
                    0 -> {
                        binding.drawerLayout.close()
                    }
                    1 -> {
                        binding.drawerLayout.close()
                        findNavController().navigate(R.id.savedFragment)
                    }
                    2 -> {
                        binding.drawerLayout.close()
                        findNavController().navigate(R.id.aboutAppFragment)
                    }
                    3 -> {
                        binding.drawerLayout.closeDrawers()
                        val alertDialog = android.app.AlertDialog.Builder(binding.root.context)
                        val dialog = alertDialog.create()
                        val bindingLanguage =
                            DialogLanguageBinding.inflate(LayoutInflater.from(requireContext()))
                        dialog.setView(bindingLanguage.root)
                        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                        dialog.setCancelable(true)


                        bindingLanguage.russian.setOnClickListener {
                            Cache.language = "ru"
                            setAppLocale(requireContext(), "ru")
                            findNavController().popBackStack()
                            findNavController().navigate(R.id.homeFragment)
                            dialog.dismiss()
                        }
//                        bindingLanguage.uk.setOnClickListener {
//                            Cache.language = "en"
//                            setAppLocale(requireContext(), "en")
//                            findNavController().popBackStack()
//                            findNavController().navigate(R.id.homeFragment)
//                            dialog.dismiss()
//                        }
                        bindingLanguage.uzb.setOnClickListener {
                            Cache.language = "uz"
                            setAppLocale(requireContext(), "en")
                            findNavController().popBackStack()
                            findNavController().navigate(R.id.homeFragment)
                            dialog.dismiss()
                        }


                        dialog.show()


                    }
                    4 -> {
                        binding.drawerLayout.close()
                        findNavController().navigate(R.id.authorsFragment)
                    }
                    5 -> {
                        try {
                            val intent = Intent(Intent.ACTION_SEND)
                            intent.type = "text/plain"
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Med Analysis")
                            val shareMessage =
                                "https://play.google.com/store/apps/details?id=${activity!!.packageName}"
                            intent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                            startActivity(Intent.createChooser(intent, "share by iAndroid.uz"))
                        } catch (e: Exception) {
                        }
                        binding.drawerLayout.close()
                    }
                    6 -> {
                        try {
                            val uri: Uri =
                                Uri.parse("market://details?id=${activity!!.packageName}")
                            val intent = Intent(Intent.ACTION_VIEW, uri)
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        } catch (e: ActivityNotFoundException) {
                            val uri: Uri =
                                Uri.parse("http://play.google.com/store/apps/details?id=${activity!!.packageName}")
                            val intent = Intent(Intent.ACTION_VIEW, uri)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                        }
                        binding.drawerLayout.close()
                    }
                    7 -> {
                        activity?.finish()
                    }
                }
            }
        })
        binding.rvNav.adapter = navAdapter
    }

    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
    }

    private fun checkSex() {
        if (Cache.sex == "erkak") {
            binding.manImg.setImageResource(R.drawable.man)
            binding.manTv.text = resources.getString(R.string.man)
            binding.manTv.setTextColor(resources.getColor(R.color.man))

            binding.womanImg.setImageResource(R.drawable.woman_grey)
            binding.womanTv.text = resources.getString(R.string.woman)
            binding.womanTv.setTextColor(resources.getColor(R.color.grey2))

        } else if (Cache.sex == "ayol") {
            binding.manImg.setImageResource(R.drawable.man_grey)
            binding.manTv.text = resources.getString(R.string.man)
            binding.manTv.setTextColor(resources.getColor(R.color.grey2))

            binding.womanImg.setImageResource(R.drawable.woman)
            binding.womanTv.text = resources.getString(R.string.woman)
            binding.womanTv.setTextColor(resources.getColor(R.color.woman))
        } else {
            binding.womanImg.setImageResource(R.drawable.woman_grey)
            binding.womanTv.text = resources.getString(R.string.woman)
            binding.womanTv.setTextColor(resources.getColor(R.color.grey2))

            binding.manImg.setImageResource(R.drawable.man_grey)
            binding.manTv.text = resources.getString(R.string.man)
            binding.manTv.setTextColor(resources.getColor(R.color.grey2))

        }
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }


    fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onResume() {
        super.onResume()
        Cache.sex = ""
        Cache.birth = ""
        Cache.address = ""
        checkSex()
    }


}