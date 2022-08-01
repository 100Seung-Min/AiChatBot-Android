package com.example.domain.repository

import com.example.domain.entity.LawEntity
import com.example.domain.param.LawParam

interface LawRepository {
    suspend fun lawQA(lawParam: LawParam): LawEntity
}