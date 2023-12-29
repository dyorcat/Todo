package com.teamsparta.todolist.domain.card.service

import com.teamsparta.todolist.domain.card.dto.CardResponse
import com.teamsparta.todolist.domain.card.dto.CreateCardRequest
import com.teamsparta.todolist.domain.card.dto.UpdateCardRequest
import com.teamsparta.todolist.domain.card.exception.ModelNotFoundException
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler

@Service
class CardServiceImpl: CardService {
    override fun getCards(): List<CardResponse> {
        TODO("DB에서 모든 카드목록 조회하여 CardResponse 목록으로 변환 후 반환")
    }

    override fun getCard(cardId: Long): CardResponse {
    throw ModelNotFoundException(modelName = "Card", id = 1L)}

    @Transactional
    override fun createCard(createCardRequest: CreateCardRequest): CardResponse {
        TODO("request를 Card로 변환 후 DB에 저장")
    }

    @Transactional
    override fun updateCard(cardId: Long, updateCardRequest: UpdateCardRequest): CardResponse {
        TODO("DB에서 cardId에 해당하는 Card를 가져와서 request기반으로 업데이트 후 DB에 저장, 결과를 CardResponse로 변환 후 반환" +
            "만약 cardId에 해당하는 card가 없다면 throw ModelNotFoundException")
    }

    @Transactional
    override fun deleteCard(cardId: Long) {
        TODO("DB에서 cardId에 해당하는 Card를 삭제. 연관된 것들 모두 삭제해야함." +
            "만약 cardId에 해당하는 card가 없다면 throw ModelNotFoundException")
    }

    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .build()
    }

}