package br.com.ruyano.trackit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_chart.*
import kotlin.random.Random


class ChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupChart()
        line_chart.data = setData(10)
        line_chart.animateX(300)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.menu_add -> Toast.makeText(this, "add", Toast.LENGTH_SHORT).show()
            R.id.menu_controls -> Toast.makeText(this, "Filtro", Toast.LENGTH_SHORT).show()
            R.id.menu_target -> Toast.makeText(this, "Meta", Toast.LENGTH_SHORT).show()
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
    }

    private fun setupChart() {
        line_chart.legend.isEnabled = false
        line_chart.description.isEnabled = false
        line_chart.isClickable = false
        line_chart.isLongClickable = false
        line_chart.setDrawBorders(false)
        line_chart.setDrawGridBackground(false)
        line_chart.setDrawMarkers(false)
        line_chart.setTouchEnabled(false)
        line_chart.setViewPortOffsets(0f,0f,0f,0f)

        line_chart.axisRight.apply {
            setDrawGridLines(false)
            setDrawLabels(false)
            setDrawAxisLine(false)
        }
        line_chart.axisLeft.apply {
            setDrawGridLines(false)
            setDrawLabels(false)
            setDrawAxisLine(false)
        }
        line_chart.xAxis.apply {
            setDrawGridLines(false)
            setDrawLabels(false)
            setDrawAxisLine(false)
        }
        line_chart.setDrawGridBackground(false)
        line_chart.setDrawBorders(false)

    }

    private fun setData(count: Int): LineData {
        val vals1 = ArrayList<Entry>()
        for (i in 1..count) {
            val value = Random.nextInt(0, count).toFloat()
            vals1.add(Entry(i.toFloat(), value))
        }

        // create a dataset and give it a type
        val set1 = LineDataSet(vals1, "DataSet 1")
        set1.setDrawCircles(false)
        set1.mode = LineDataSet.Mode.HORIZONTAL_BEZIER
        set1.setDrawFilled(true)

        val data = LineData(set1)
        data.setDrawValues(false)

        val ll1 = LimitLine(5f, "Meta 5")
        ll1.lineWidth = 1f
        ll1.lineColor = ContextCompat.getColor(this, R.color.gray)
        ll1.textColor = ContextCompat.getColor(this, R.color.gray)
        ll1.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
        ll1.textSize = 10f

        line_chart.axisLeft.removeAllLimitLines()
        line_chart.axisLeft.addLimitLine(ll1)

        return data
    }

}
