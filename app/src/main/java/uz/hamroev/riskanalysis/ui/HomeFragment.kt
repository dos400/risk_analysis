package uz.hamroev.riskanalysis.ui

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
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.riskanalysis.R
import uz.hamroev.riskanalysis.adapters.NavAdapter
import uz.hamroev.riskanalysis.cache.Cache
import uz.hamroev.riskanalysis.databinding.DialogLanguageBinding
import uz.hamroev.riskanalysis.databinding.FragmentHomeBinding
import uz.hamroev.riskanalysis.model.Nav
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    //nav menu list and navAdapter to down
    private lateinit var listNav: ArrayList<Nav>
    private lateinit var navAdapter: NavAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.menuButton.setOnClickListener {
            binding.drawerLayout.open()
        }

        loadNav()





        return binding.root
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


}