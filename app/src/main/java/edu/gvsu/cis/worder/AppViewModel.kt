package edu.gvsu.cis.worder

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Letter(val text: Char = '$', val point: Int = 0)

enum class Origin {
    Stock, CenterBox
}

class AppViewModel: ViewModel() {
    private val _sourceLetters = MutableStateFlow(emptyList<Letter?>())
    val sourceLetters = _sourceLetters.asStateFlow()
    private val _targetLetters = MutableStateFlow(emptyList<Letter?>())
    val targetLetters = _targetLetters.asStateFlow()
    init {
        selectRandomLetters()
    }

    fun selectRandomLetters() {
        _sourceLetters.update {
            // 60% vowels, 40% consonants
            val vowels = (1..6).map {
                "AEIOU".random()
            }
            val consontants = (1..4).map {
                "BCFGHJKLMNPQRSTVWXYZ".random()
            }
            (vowels + consontants).map {
                Letter(it)
            }.shuffled()
        }
        _targetLetters.update { emptyList() }
    }


    fun rearrangeLetters(group: Origin, arr: List<Letter>) {
        when (group) {
            Origin.Stock -> {
                _sourceLetters.update {
                    arr
                }
            }

            Origin.CenterBox -> {
                _targetLetters.update {
                    arr
                }
            }
        }
    }
}