package uz.hamroev.riskanalysis.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ResultEntity {

    @PrimaryKey(autoGenerate = true)  var id: Long? = null

    var fio: String? = null
    var birth: String? = null
    var sex: String? = null
    var address: String? = null
    var date: String? = null
    var risktype: String? = null
    var recommendation: String? = null
    var algorithmtext: String? = null




}