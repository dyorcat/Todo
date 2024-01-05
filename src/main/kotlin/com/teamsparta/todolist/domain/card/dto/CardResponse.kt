package com.teamsparta.todolist.domain.card.dto

import java.util.Date

// 간결하고 가독성 높고, toString(), equals(), hashCode() 메서드 자동 생성해주는 data class를 사용
// data class는 기본적으로 immutable을 유지해서, 객체가 변경 불가능하다. 그래서 dto로 활용하기 적합함.
// data class에는 컴파일러에서 자동으로 생성되는 componentN() 메서드도 있다.
// 구조 분해 선언 및 패턴 매칭과 같은 기능을 활용할 수 있게 한다.

data class CardResponse(
    val cardid: Long, // 고유 identifier. immutable함
    val title: String, // 할 일 제목. 필수
    val content: String?, // 할 일 내용. 필수 아니라서 nullable하게 설정
    val nickname: String, // 작성자 이름
    val cardday: Date
)

