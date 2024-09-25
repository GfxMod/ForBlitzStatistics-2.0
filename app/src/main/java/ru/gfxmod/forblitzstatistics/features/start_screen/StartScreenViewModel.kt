package ru.gfxmod.forblitzstatistics.features.start_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.gfxmod.domain.applicationinfo.model.ApplicationInfoModel
import ru.gfxmod.domain.applicationinfo.repository.ApplicationInfoRepository

class StartScreenViewModel(
    private val repository: ApplicationInfoRepository
) : ViewModel() {

    private val _applicationInfo = MutableStateFlow<ApplicationInfoModel?>(null)
    val applicationInfo: StateFlow<ApplicationInfoModel?> get() = _applicationInfo

    fun getApplicationData() {
        viewModelScope.launch {
            _applicationInfo.value = repository.getApplicationInfo()
        }
    }
}