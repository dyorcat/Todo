package com.teamsparta.todolist.domain.card.controller

import com.teamsparta.todolist.domain.card.dto.CardResponse
import com.teamsparta.todolist.domain.card.dto.CreateCardRequest
import com.teamsparta.todolist.domain.card.dto.UpdateCardRequest
import com.teamsparta.todolist.domain.card.service.CardService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
// Controller와 RestController 어노테이션의 차이는 응답하는 형태가 다른 것.
// Controllers는 view를 응답함(html파일 등). RestController는 data를 응답함. (문자열, Json, xml 등)
@RequestMapping("/cards") // Handler Mapping에게 어떤 url을 담당하는 지 알려주는 것.
@RestController
class CardController(
    private val cardService: CardService
) {

    @GetMapping()
    fun getCards(): ResponseEntity<List<CardResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCards())
    }
    @GetMapping("/{cardId}")
    fun getCard(@PathVariable cardId: Long): ResponseEntity<CardResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCard(cardId))
    }

    // RequestBody 어노테이션은 요청 DTO를 표기할 때 사용. 클라이언트로 요청받은 Json을 객체로 매핑해줌.
    // PathVariable 어노테이션은 URI 경로 변수 값을 매핑
    @PostMapping
    fun createCard(@RequestBody createCardRequest: CreateCardRequest): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED) // 201을 줘야함.
            .body(cardService.createCard(createCardRequest))
    }

    @PutMapping("/{cardId}")
    fun updateCard(@PathVariable cardId: Long, @RequestBody updateCardRequest: UpdateCardRequest): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.updateCard(cardId, updateCardRequest))
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(@PathVariable cardId: Long): ResponseEntity<Unit> {
        cardService.deleteCard(cardId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT) // 204
            .build()
    }
}