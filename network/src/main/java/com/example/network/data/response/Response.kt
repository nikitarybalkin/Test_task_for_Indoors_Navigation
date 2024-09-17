package com.example.network.data.response

data class Response(
    val interval_segments: List<Any?>,
    val pagination: Pagination,
    val search: Search,
    val segments: List<Segment>
)