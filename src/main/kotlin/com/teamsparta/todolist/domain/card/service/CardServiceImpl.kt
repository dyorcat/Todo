package com.teamsparta.todolist.domain.card.service

import com.teamsparta.todolist.domain.card.dto.CardResponse
import com.teamsparta.todolist.domain.card.dto.CreateCardRequest
import com.teamsparta.todolist.domain.card.dto.UpdateCardRequest
import com.teamsparta.todolist.domain.card.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.card.model.Card
import com.teamsparta.todolist.domain.card.repository.CardRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository
): CardService {
    override fun getCards(): List<CardResponse> {
        return cardRepository.findAll().map { it.toResponse() }
    }

    override fun getCard(cardid: Long): CardResponse {
        val card = cardRepository.findByIdOrNull(cardid) ?: throw ModelNotFoundException("Card", cardid)
        return card.toResponse()}

    @Transactional
    override fun createCard(request: CreateCardRequest): CardResponse {
        return cardRepository.save(
            Card(
                title = request.title,
                content = request.content,
                nickname = request.nickname,
                cardday = request.cardday
            )
        ).toResponse()
    }

    @Transactional
    override fun updateCard(cardid: Long, request: UpdateCardRequest): CardResponse {
        val card = cardRepository.findByIdOrNull(cardid) ?: throw ModelNotFoundException("Card", cardid)
        val (title, content, nickname) = request

        card.title = title
        card.content = content
        card.nickname = nickname

        return cardRepository.save(card).toResponse()
    }

    @Transactional
    override fun deleteCard(cardid: Long) {
        val card = cardRepository.findByIdOrNull(cardid) ?: throw ModelNotFoundException("Card", cardid)
        cardRepository.delete(card)
    }

    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .build()
    }

}


