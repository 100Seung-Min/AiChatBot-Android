package com.example.domain.usecase

import com.example.domain.entity.LawEntity
import com.example.domain.param.LawParam
import com.example.domain.repository.LawRepository
import javax.inject.Inject

class LawQAUseCase @Inject constructor(
    private val lawRepository: LawRepository
) {
    suspend fun execute(lawParam: LawParam) = lawRepository.lawQA(lawParam = lawParam)
}