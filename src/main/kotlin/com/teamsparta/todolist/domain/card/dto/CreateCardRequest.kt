package com.teamsparta.todolist.domain.card.dto

import java.util.*

data class CreateCardRequest(
    val title: String, // 할 일 제목. 필수
    val content: String?, // 할 일 내용. 필수 아니라서 nullable하게 설정
    val name: String, // 작성자 이름
    val day: Date
)

