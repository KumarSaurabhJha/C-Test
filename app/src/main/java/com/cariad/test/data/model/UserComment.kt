package com.kumar.test.data.model

data class UserComment(
    val ChargePointID: Int,
    val CheckinStatusType: CheckinStatusType,
    val CheckinStatusTypeID: Int,
    val Comment: String,
    val CommentType: CommentType,
    val CommentTypeID: Int,
    val DateCreated: String,
    val ID: Int,
    val IsActionedByEditor: Any,
    val Rating: Int,
    val RelatedURL: Any,
    val User: UserX,
    val UserName: String
)