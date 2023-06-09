package uz.hamroev.riskanalysis.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.riskanalysis.R
import uz.hamroev.riskanalysis.adapters.UserAdapter
import uz.hamroev.riskanalysis.cache.Cache
import uz.hamroev.riskanalysis.databinding.FragmentAuthorsBinding
import uz.hamroev.riskanalysis.model.MyUser

class AuthorsFragment : Fragment() {

    lateinit var binding: FragmentAuthorsBinding

    private lateinit var userAdapter: UserAdapter
    private lateinit var list: ArrayList<MyUser>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAuthorsBinding.inflate(layoutInflater)



        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        loadUsers()
        userAdapter = UserAdapter(requireContext(), list)
        binding.rvUsers.adapter = userAdapter

        return binding.root

    }

    private fun loadUsers() {
        list = ArrayList()
        list.clear()
        when (Cache.language) {
            "uz" -> {
                /*
                * kamilova
                * masharipova
                * beknazarova
                * nuriddinov
                * zakirova*/

                list.add(MyUser("Камилова \nУмида \nКабировна","м. ф. д., профессор, Ўзбекистон Республикаси Соғлиқни сақлаш вазирлиги Республика ихтисослаштирилган терапия ва тиббий реабилитация илмий-амалий тиббиёт маркази, илмий ишлар бўйича директори",R.drawable.ic_umida_kamilova))
                list.add(MyUser("Машарипова \nДиляфруз \nРахматиллаевна","Илмий котиб \"Республика ихтисослаштирилган тераия ва тиббий реабилитасия илмий-амалий тиббиёт маркази\" ДМ",R.drawable.ic_dilafruz))
                list.add(MyUser("Тагаева Дилноза Рамизуллаевна","Республика ихтисослаштирилган терапия ва тиббий реабилитация илмий-амалий тиббиёт маркази, кичик илмий ходим\n",R.drawable.ic_togayeva))
                list.add(MyUser("Бекназарова \nСаида \nСафибуллаевна","Профессор\n" +
                        "т.ф.д.\n" +
                        "Муҳаммад ал-Хоразмий номидаги Тошкент Ахборот технологиялари университети Аудиовизуал технологиялар кафедраси профессори",R.drawable.ic_saida))

                list.add(MyUser("Ахмедов Халмурад Садууллаевич","Тошкент тиббиёт академияси, кафедра мудири, профессор, тиббиёт фанлари доктори\n",R.drawable.ic_axmedov))
            }
            "ru" -> {
                list.add(MyUser("Камилова \nУмида \nКабировна","д.м.н., профессор, директор по научной работе Республиканского специализированного научно-практического медицинского центра терапии и медицинской реабилитации Министерства Здравоохранения Республики Узбекистан",R.drawable.ic_umida_kamilova))
                list.add(MyUser("Машарипова \nДиляфруз \nРахматиллаевна","Ученый секретарь, \nГУ \"Республиканский специализированный научно-практический медицинский центр терапии и медицинской реабилитации\"",R.drawable.ic_dilafruz))
                list.add(MyUser("Тагаева Дилноза Рамизуллаевна","Республиканский специализированный научно-практический медицинский центр терапии и медицинской реабилитации, младший научный сотрудник",R.drawable.ic_togayeva))

                list.add(MyUser("Бекназарова \nСаида \nСафибуллаевна","Профессор\n" + "д.т.н.\n" + "Профессор кафедры аудиовизуальные технологии Ташкентского университета информационных технологий имени Мухаммада ал-Хорезми",R.drawable.ic_saida))
                list.add(MyUser("Ахмедов Халмурад Садууллаевич","Ташкентская медицинская академия, заведующий кафедрой, профессор, доктор медицинских наук\n",R.drawable.ic_axmedov))
                  }

        }
    }


}