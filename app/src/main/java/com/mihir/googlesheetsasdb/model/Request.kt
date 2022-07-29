package com.mihir.googlesheetsasdb.model

import retrofit2.Response
import retrofit2.http.GET

interface Request {

    @GET("your url here")
    suspend fun getContent(): Response<SheetResponse>
}