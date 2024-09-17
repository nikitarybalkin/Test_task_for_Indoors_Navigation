package com.example.network.data.model

import com.example.network.data.response.Pagination
import com.example.network.data.response.Response
import com.example.network.data.response.Search
import com.example.network.data.response.Segment

class ResponseModel (
    val interval_segments: List<Any?>,
    val pagination: Pagination,
    val search: Search,
    val segments: List<Segment>
)
fun Response.mapToDomain() = ResponseModel(
    interval_segments, pagination, search, segments
)
fun ResponseModel.mapToData() = Response(
    interval_segments, pagination, search, segments
)
