package com.example.domain.usecase

import com.example.domain.param.WikiParam
import com.example.domain.repository.WikiRepository
import javax.inject.Inject

class WikiQAUseCase @Inject constructor(
    private val wikiRepository: WikiRepository
){
    suspend fun execute(wikiParam: WikiParam) = wikiRepository.wikiQA(wikiParam = wikiParam)
}