package com.projectseoul.stockmarkettest.adapters

import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.models.EUnit
import java.text.NumberFormat
import java.util.*

/**
 * Created by KING JINHO on 9/18/2021
 */
@BindingAdapter("diff")
fun diff(view: MaterialTextView, value: String) {
    val newValue = if (!value.contains("-")) "+$value" else value
    view.text = newValue
    setTextColor(view, value)
}

@BindingAdapter("diffRatio")
fun diffInRatio(view: MaterialTextView, value: String) {
    val newValue = if (!value.contains("-")) "+$value%" else "$value%"
    view.text = newValue
    setTextColor(view, value)
}

@BindingAdapter("marketCap", "unit", requireAll = true)
fun marketCap(view: MaterialTextView, value: String, unit: EUnit) {
    val nf = NumberFormat.getInstance(Locale.US)
    val number = nf.parse(value)!!.toLong()

    view.text = view.context.getString(
        if (unit == EUnit.THOUSAND_BIL) R.string.all_money_unit_1000bil else R.string.all_money_unit_mil,
        if (unit == EUnit.THOUSAND_BIL) number / unit.value else value
    )
}

@BindingAdapter("weight")
fun weight(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_weight, value)
}

@BindingAdapter("sharesOwn")
fun sharesOwn(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_shares_own, value)
}

@BindingAdapter("volume")
fun volume(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_transaction_in_volume, value)
}

@BindingAdapter("blockDealVolume")
fun blockDealVolume(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_block_deal_transaction_in_volume, value)
}

@BindingAdapter("totalShares")
fun totalShares(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_total_shares, value)
}

@BindingAdapter("turnover")
fun turnover(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_turnover_ratio, value)
}

@BindingAdapter("amount")
fun amount(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_transaction_in_amount, value)
}

@BindingAdapter("opening")
fun opening(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_stock_opening_price, value)
}

@BindingAdapter("high")
fun high(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_stock_high_price, value)
}

@BindingAdapter("low")
fun low(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_stock_low_price, value)
}

@BindingAdapter("yearHigh")
fun yearHigh(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_stock_year_high_price, value)
}

@BindingAdapter("yearLow")
fun yearLow(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_stock_year_low_price, value)
}

@BindingAdapter("foreignerRatio")
fun foreignerRatio(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.all_stock_foreigner_ratio, value)
}

@BindingAdapter("tradeSurplus")
fun tradeSurplus(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.monthly_trading_surplus, value)
}

@BindingAdapter("exportVolume")
fun exportVolume(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.monthly_trading_export_volume, value)
}

@BindingAdapter("exportAmount")
fun exportAmount(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.monthly_trading_export_amount, value)
}

@BindingAdapter("importVolume")
fun importVolume(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.monthly_trading_import_volume, value)
}

@BindingAdapter("importAmount")
fun importAmount(view: MaterialTextView, value: String) {
    view.text = view.context.getString(R.string.monthly_trading_import_amount, value)
}


fun setTextColor(view: MaterialTextView, value: String) {
    view.setTextColor(
        view.context.getColor(if (value.contains("-")) R.color.cardview_shadow_end_color else R.color.design_default_color_on_primary)
    )
}