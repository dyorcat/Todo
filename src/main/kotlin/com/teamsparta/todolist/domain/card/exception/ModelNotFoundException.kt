package com.teamsparta.todolist.domain.card.exception

// RuntimeException이란 어플리케이션이 실행될 때 발생할 수 있는 예외.
// 예외 작성할 때 RuntimeException을 상속받으면 됨.
class ModelNotFoundException(val modelName: String, val id: Long): RuntimeException(
    "Model $modelName not found with given id: $id"
) {
}