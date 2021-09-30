package com.projectseoul.stockmarkettest.recyclerview.viewholders

import android.graphics.Color
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.projectseoul.stockmarkettest.databinding.ItemStockQuotationBinding
import com.projectseoul.stockmarkettest.models.SingleLineChart
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.utils.YAxisValueFormatter
import java.util.ArrayList

/**
 * Created by KING JINHO on 9/29/2021
 */
class SingleLineChartViewHolder(
    private val binding: ItemStockQuotationBinding
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.chart.also {
            it.setBorderColor(Color.WHITE)
            it.setTouchEnabled(true)
            it.isDragEnabled = true
            it.description.isEnabled = false
            it.isHighlightPerDragEnabled = true
            it.setScaleEnabled(true)
            it.setPinchZoom(true)
            it.xAxis.isEnabled = false

            it.axisRight.isEnabled = false
            it.axisLeft.enableGridDashedLine(10f, 10f, 0f)
            it.axisLeft.axisMinimum = 0f
            it.axisLeft.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
            it.axisLeft.valueFormatter = YAxisValueFormatter()
            it.axisLeft.textColor = Color.WHITE

            it.legend.isEnabled = false
        }

        val values = ArrayList<Entry>()
        val listItems = item as List<SingleLineChart>

        for (i in listItems.indices) {
            values.add(Entry(i.toFloat(), listItems[i].yAxis.toFloat()))
        }

        val lineDataSet = LineDataSet(values, "DataSet 1")

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(lineDataSet)

        val data = LineData(dataSets)

        lineDataSet.color = Color.RED
        lineDataSet.setDrawCircles(false)
        lineDataSet.setDrawValues(false)
        binding.chart.data = data
    }
}