package com.ckc.latestnews.repository

import com.ckc.latestnews.model.NewsSectionsRequest

class NewsRepositoryImpl(private val apiService: APIService): NewsRepository {

    override suspend fun getNewsCategories(): List<String>? {
        return try {
            val response = apiService.getNewsSections()
            if (response.isSuccessful && response.body() != null) {
                response.body()
            } else {
                // Log or handle the error
                null
            }
        } catch (e: Exception) {
            // Handle exceptions
            println("Error getting news categories: ${e.message}")
            null
        }
    }

    override suspend fun getNewsBySections(request: NewsSectionsRequest): Map<String, List<Map<String, String>>>? {
        return try {
            val response = apiService.getNewsBySections(request)
            if (response.isSuccessful) {
                response.body()
            } else {
                // Log or handle the error
                null
            }
        } catch (e: Exception) {
            // Handle exceptions
            println("Error getting news by sections: ${e.message}")
            null
        }
    }
}