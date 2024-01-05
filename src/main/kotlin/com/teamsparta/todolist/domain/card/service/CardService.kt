package com.teamsparta.todolist.domain.card.service

import com.teamsparta.todolist.domain.card.dto.CardResponse
import com.teamsparta.todolist.domain.card.dto.CreateCardRequest
import com.teamsparta.todolist.domain.card.dto.UpdateCardRequest

interface CardService {

    fun getCards(): List<CardResponse>

    fun getCard(cardid: Long): CardResponse

    fun createCard(createCardRequest: CreateCardRequest): CardResponse

    fun updateCard(cardid: Long, updateCardRequest: UpdateCardRequest): CardResponse

    fun deleteCard(cardid: Long)
}