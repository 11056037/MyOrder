package im.ntub.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import im.ntub.myapplication.databinding.ActivityMainBinding
import im.ntub.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {

            AlertDialog.Builder(this)
                .setMessage("是否確認")
                .setPositiveButton("是"){ dialog,i->
                    var TotalPrice = 0
                    var MainFood = ""
                    var Drink = ""
                    val Ice = binding.chbIce.isChecked
                    val Cake = binding.chbCake.isChecked

                    when(binding.radioGroup.checkedRadioButtonId) {
                        binding.rdbRice.id -> {
                            TotalPrice += 120
                            MainFood = "時蔬燉飯"
                        }

                        binding.rdbNoodles.id -> {
                            TotalPrice += 130
                            MainFood = "奶油義大利麵"
                        }

                        binding.rdbPizza.id -> {
                            TotalPrice += 110
                            MainFood = "海鮮披薩"
                        }
                    }

                    when(binding.radioGroup2.checkedRadioButtonId) {
                        binding.rdbCola.id -> {
                            TotalPrice += 50
                            Drink = "可樂"
                        }

                        binding.rdbSoda.id -> {
                            TotalPrice += 50
                            Drink = "雪碧"
                        }
                    }

                    if(binding.chbIce.isChecked){
                        TotalPrice += 60
                    }
                    if(binding.chbCake.isChecked){
                        TotalPrice += 80
                    }
                    intent.putExtra("Ice",Ice)
                    intent.putExtra("Cake",Cake)
                    intent.putExtra("MainFood",MainFood)
                    intent.putExtra("Drink",Drink)
                    intent.putExtra("TotalPrice", TotalPrice)
                    setResult(RESULT_OK, intent)
                    finish()
                }
                .setNegativeButton("否"){ dialog, i->

                }
                .show()
        }
    }
}