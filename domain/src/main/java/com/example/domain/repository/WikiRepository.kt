package com.example.domain.repository

import com.example.domain.entity.WikiEntity
import com.example.domain.param.WikiParam

interface WikiRepository {
    suspend fun wikiQA(wikiParam: WikiParam): WikiEntity
}