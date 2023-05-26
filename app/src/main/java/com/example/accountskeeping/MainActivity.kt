package com.example.accountskeeping

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val acuntList = ArrayList<String>()
        acuntList.add("早餐")
        acuntList.add("午餐")
        acuntList.add("晚餐")
        acuntList.add("加值")
        acuntList.add("購物")
        val month_title: TextView = findViewById(R.id.month_title)
        val listView: ListView = findViewById(R.id.lvAcunt)

        pieChart = findViewById(R.id.pieChart)
        val calendar = Calendar.getInstance() //日期時間
        var theMonth = calendar.get(Calendar.MONTH) //取得月份
        theMonth += 1

        month_title.text = theMonth.toString() + '月'

        setPie()
    }

    private fun setPie(){
        val pieEntry1 = PieEntry(280f,"交通")
        val pieEntry2 = PieEntry(456f,"食物")

        val pieList = ArrayList<PieEntry>()
        pieList.add(pieEntry1)
        pieList.add(pieEntry2)

        val pieDataSet = PieDataSet(pieList, "")    //圓餅圖左下角資訊

        //一般有多少項數據，就配置多少個顏色的，少的話會複用最後一個顏色，多的話無大礙
        pieDataSet.colors = mutableListOf(
            Color.parseColor("#feb64d"),
            Color.parseColor("#ff7c7c"),
            Color.parseColor("#9287e7"),
            Color.parseColor("#60acfc"))

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData
        //顯示值格式化，這裏使用Api,添加百分號
        pieData.setValueFormatter(PercentFormatter())
        //設置值的顏色
        pieData.setValueTextColor(Color.parseColor("#FFFFFF"))
        //設置值的字型大小
        pieData.setValueTextSize(30f)

        val description= Description()
        description.text=""
        //把右下邊的Description label 去掉，也可以設置成餅圖說明
        pieChart.description=description

        //去掉中心圓，此時中心圓半透明
        pieChart.holeRadius=0f
        //去掉半透明
        pieChart.setTransparentCircleAlpha(0)
        pieChart.setRotationEnabled(false)  //圖表是否可以手動旋轉
        pieChart.setDrawEntryLabels(true)

        pieChart.invalidate()
    }
}