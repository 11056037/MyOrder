/**
 * 組員
 *11056018 楊凱恩
 * 11056023 郭育綺
 * 11056037 鄭宜心
 */

package im.ntub.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import im.ntub.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val data = result.data
                binding.txtMainFoodView.text = data?.getStringExtra("MainFood")
                binding.txtDrinkView.text = data?.getStringExtra("Drink")
                binding.txtDessertView.text =
                    if ((data?.getBooleanExtra("Ice", false) == true)&&(data?.getBooleanExtra("Cake", false) == true)) {
                        "香草冰淇淋,提拉米蘇"
                    }else if (data?.getBooleanExtra("Ice", false) == true){
                        "香草冰淇淋"
                    }else if (data?.getBooleanExtra("Cake", false) == true) {
                        "提拉米蘇"
                    }else{
                        "無"
                    }
                binding.txtTotalPriceView.text = data?.getIntExtra("TotalPrice", 0).toString()

            }else{
                binding.txtMainFoodView.text = ""
                binding.txtDrinkView.text = ""
                binding.txtDessertView.text = ""
            }

        }

        binding.btnOrder.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launcher.launch(intent)
        }

    }

}