package com.vatestkot.my_application_w_nit.feature.topWeather.presentation

import com.vatestkot.my_application_w_nit.Weather
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.OneExecutionStateStrategy

class TopWeathersPresenter : MvpPresenter<TopWeatherView>() {

    private val weathers : List<Weather> = listOf(
        Weather("Челябинск", "-7"),
        Weather("Миасс", "-8"),
        Weather("Сочи", "-1"),
        Weather("Уфа", "-6"),
        Weather("2Челябинск", "-7"),
        Weather("2Миасс", "-8"),
        Weather("2Сочи", "-1"),
        Weather("2Уфа", "-6")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setWeathers(weathers)
    }

    fun onWeatherClick(weather: Weather) {
        viewState.openDetails(weather)
    }

    fun onFavoritesClick() {
        viewState.openDetails()
    }
}

interface TopWeatherView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setWeathers(weather: List<Weather>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openDetails(weather: Weather)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openFavoritesScreen()
}
